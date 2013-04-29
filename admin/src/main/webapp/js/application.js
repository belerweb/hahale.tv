/* Placeholder IE */
(function($) {
	function Placeholder(input) {
		this.input = input;
		if (input.attr('type') == 'password') {
			this.handlePassword();
		}
		// Prevent placeholder values from submitting
		$(input[0].form).submit(function() {
			if (input.hasClass('placeholder') && input[0].value == input.attr('placeholder')) {
				input[0].value = '';
			}
		});
	}
	Placeholder.prototype = {
		show : function(loading) {
			// FF and IE saves values when you refresh the page. If the user refreshes
			// the page with
			// the placeholders showing they will be the default values and the input
			// fields won't be empty.
			if (this.input[0].value === '' || (loading && this.valueIsPlaceholder())) {
				if (this.isPassword) {
					try {
						this.input[0].setAttribute('type', 'text');
					} catch (e) {
						this.input.before(this.fakePassword.show()).hide();
					}
				}
				this.input.addClass('placeholder');
				this.input[0].value = this.input.attr('placeholder');
			}
		},
		hide : function() {
			if (this.valueIsPlaceholder() && this.input.hasClass('placeholder')) {
				this.input.removeClass('placeholder');
				this.input[0].value = '';
				if (this.isPassword) {
					try {
						this.input[0].setAttribute('type', 'password');
					} catch (e) {
					}
					// Restore focus for Opera and IE
					this.input.show();
					this.input[0].focus();
				}
			}
		},
		valueIsPlaceholder : function() {
			return this.input[0].value == this.input.attr('placeholder');
		},
		handlePassword : function() {
			var input = this.input;
			input.attr('realType', 'password');
			this.isPassword = true;
			// IE < 9 doesn't allow changing the type of password inputs
			if ($.browser.msie && input[0].outerHTML) {
				var fakeHTML = $(input[0].outerHTML.replace(/type=(['"])?password\1/gi, 'type=$1text$1'));
				this.fakePassword = fakeHTML.val(input.attr('placeholder')).addClass('placeholder').focus(function() {
					input.trigger('focus');
					$(this).hide();
				});
				$(input[0].form).submit(function() {
					fakeHTML.remove();
					input.show()
				});
			}
		}
	};
	var NATIVE_SUPPORT = !!("placeholder" in document.createElement("input"));
	$.fn.placeholder = function() {
		return NATIVE_SUPPORT ? this : this.each(function() {
			var input = $(this);
			var placeholder = new Placeholder(input);
			placeholder.show(true);
			input.focus(function() {
				placeholder.hide();
			});
			input.blur(function() {
				placeholder.show(false);
			});

			// On page refresh, IE doesn't re-populate user input
			// until the window.onload event is fired.
			if ($.browser.msie) {
				$(window).load(function() {
					if (input.val()) {
						input.removeClass("placeholder");
					}
					placeholder.show(true);
				});
				// What's even worse, the text cursor disappears
				// when tabbing between text inputs, here's a fix
				input.focus(function() {
					if (this.value == "") {
						var range = this.createTextRange();
						range.collapse(true);
						range.moveStart('character', 0);
						range.select();
					}
				});
			}
		});
	}
})(jQuery);
jQuery('input[placeholder], textarea[placeholder]').placeholder();

$(function() {
	var h = $(document.body).height() - $('#header').height();
	$('#wrap').height(h);
	$('#mb').height(h - 20).css('overflow', 'auto');
	$(window).on('resize', function() {
		var h = $(document.body).height() - $('#header').height();
		$('#wrap').height(h);
		$('#mb').height(h - 20).css('overflow', 'auto');
	});
});

window.cqlybest = {
	parseHash : function(hash) {
		var result = {};
		var hashData = (hash ? hash : location.hash).match(/^#(.+)$/);
		if (hashData) {
			var pa = hashData[1].split(';');
			for ( var i = 0; i < pa.length; i++) {
				var kv = pa[i].split('=');
				result[kv[0]] = kv[1];
			}
		}
		return result;
	},
	buildHash : function(param) {
		var hash = [];
		$.each(param, function(k, v) {
			hash.push(k + '=' + encodeURIComponent(v));
		});
		return '#' + hash.join(';');
	},
	ajaxSubmit : function($form, event) {
		event.preventDefault();
		event.stopPropagation();
		$form.ajaxSubmit({
			success : function(response) {
				cqlybest.success();
			},
			error : function() {
				cqlybest.error();
			}
		});
	},
	success : function(message, label, func) {
		var _message = message ? messsage : '<div class="alert alert-success">操作成功</div>';
		var _label = label ? label : '确定';
		var _func = func ? func : function() {
			history.go(-1);
		};
		bootbox.alert(_message, _label, _func);
	},
	error : function(message, label, func) {
		var _message = message ? messsage : '<div class="alert alert-error">操作失败</div>';
		var _label = label ? label : '确定';
		var _func = func ? func : function() {
		};
		bootbox.alert(_message, _label, _func);
	}
};

$(window).hashchange(function() {
	var param = cqlybest.parseHash();
	if (param.m) {
		// 主菜单
		$('#menu .main-menu > li').removeClass('active');
		$('#menu .main-menu > li[data-m=' + param.m + ']').addClass('active');
		$('#menu .additional-menu > li').hide().removeClass('active');
		$('#menu .additional-menu > li[data-m=' + param.m + ']').show();
		if (param.n) {
			// 子菜单
			$('#menu .additional-menu > li[data-n="' + param.n + '"]').addClass('active');
		}
	}
	if (param.u && param.t) {
		var container = $(param.t == '#main' ? '#mb' : param.t);
		if (container.length) {
			container.load(decodeURIComponent(param.u));
		} else {
			var hash = $('#menu .additional-menu .active a').attr('href');
			var p = cqlybest.parseHash(hash);
			$('#mb').load(p.u, function() {
				$(param.t).load(param.u);
			});
		}
	}
});

(function() {
	if (location.hash == '') {
		location.hash = $('#menu .additional-menu > li:first a').attr('href');
	} else {
		$(window).hashchange();
	}
})();

(function() {
	$('.page-load-btn').live('click', function() {
		$($(this).attr('data-target')).load($(this).attr('data-url'), function() {
			var param = cqlybest.parseHash();
			delete param.u;
			param['_t'] = new Date().getTime();
			location.hash = cqlybest.buildHash(param);
		});
	});
	$('.ajax-action-btn').live('click', function() {
		var url = $(this).attr('data-url');
		var execute = function() {
			$.get(url).done(function() {
				cqlybest.success(null, null, function() {
					var param = cqlybest.parseHash();
					param['_t'] = new Date().getTime();
					location.hash = cqlybest.buildHash(param);
				});
			}).fail(function() {
				cqlybest.error();
			}).always(function() {
			});
		};
		var confirm = $(this).attr('data-confirm');
		if (confirm) {
			var action = $(this).attr('data-action');
			var title = $(this).attr('data-title');
			bootbox.confirm('确认' + action + ' [' + title + '] ？', '取消', '确认', function(result) {
				if (result) {
					execute();
				}
			});
		} else {
			execute();
		}
	});
})();