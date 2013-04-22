<!DOCTYPE html>
<html lang="zh">
	<#assign ContextPath=springMacroRequestContext.getContextPath() />
	<head>
		<meta charset="utf-8">
		<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
		<title>${(site.title)!'哈哈乐视频'}</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="${(site.description)!}">
		<meta name="author" content="${(site.author)!}">
		<meta property="qc:admins" content="343476707014564671645060454" />
		<meta property="wb:webmaster" content="bee8028e40dbc2a7" />
		<link href="${ContextPath}/css/bootstrap.css" rel="stylesheet">
		<link href="${ContextPath}/css/style.css" rel="stylesheet">
		<link href="${ContextPath}/css/icon-style.css" rel="stylesheet">
		<link href="${ContextPath}/css/bootstrap-responsive.css" rel="stylesheet">
		<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	</head>
	<body>
		<div class="navbar navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</a>
					<a class="brand" href="${ContextPath}/index.html">哈哈乐视频</a>
					<div class="nav-collapse">
						<ul class="nav pull-right">
							<li>
								<#if userInfo?has_content>
								${userInfo.nickname!}
								<#else>
								<a href="${ContextPath}/connector/qq_login.do"><img alt="QQ登录" src="http://qzonestyle.gtimg.cn/qzone/vas/opensns/res/img/Connect_logo_7.png"></a>
								</#if>
							</li>
						</ul>
					</div><!--/.nav-collapse -->
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="span3">
					<div class="nav-headers">
						<h3>哈哈乐视频<br>只为你一笑</h3>
					</div>
					<ul class="nav nav-tabs nav-stacked">
						<li class="active"><a href="#"><i class="icon-picture"></i> 新视频</a></li>
						<li><a href="#"><i class="icon-ok"></i> 热门视频</a></li>
						<li><a href="#"><i class="icon-bookmark"></i> 访问最多</a></li>
						<li><a href="#"><i class="icon-download"></i> 最多下载</a></li>
						<li><a href="#"><i class="icon-heart"></i> 编辑推荐</a></li>
					</ul>
				</div>
				<div class="span3 galery">
					<div class="menu-galery">
						<ul>
							<li><a href="#" rel="tooltip" title="Detail"><i class="iconbig-search"></i></a></li>
							<li><a href="#" rel="tooltip" title="Add Comment"><i class="iconbig-speak"></i></a></li>
							<li><a href="#" rel="tooltip" title="Download"><i class="iconbig-download"></i></a></li>
							<li><a href="#" rel="tooltip" title="Like"><i class="iconbig-black-star"></i></a></li>
						</ul>
					</div>
					<div class="image-galery"><a class="group" rel="group1" href="img/1_b.jpg"><img src="img/1_b.jpg" /></a></div>
					<div class="count-galery">
						<ul>
							<li><i class="icon-comment"></i> 5</li>
							<li><i class="icon-download-alt"></i> 7</li>
							<li><i class="icon-star"></i> 2</li>
							<li><i class="icon-eye-open"></i> 20</li>
						</ul>
					</div>
					<div class="tags-galery">
						<p><i class="icon-tags"></i> Tags : <a href="#">Building</a>, <a href="#">Tower</a>, 
						<a href="#">Eifel</a>, <a href="#">Wonders of the world</a>, <a href="#">Miracle</a></p>
					</div>
				</div>
				<div class="span3 galery">
					<div class="menu-galery">
						<ul>
							<li><a href="#" rel="tooltip" title="Detail"><i class="iconbig-search"></i></a></li>
							<li><a href="#" rel="tooltip" title="Add Comment"><i class="iconbig-speak"></i></a></li>
							<li><a href="#" rel="tooltip" title="Download"><i class="iconbig-download"></i></a></li>
							<li><a href="#" rel="tooltip" title="Like"><i class="iconbig-black-star"></i></a></li>
						</ul>
					</div>
					<div class="image-galery"><a class="group" rel="group1" href="img/2_b.jpg"><img src="img/2_b.jpg" /></a></div>
					<div class="count-galery">
						<ul>
							<li><i class="icon-comment"></i> 5</li>
							<li><i class="icon-download-alt"></i> 7</li>
							<li><i class="icon-star"></i> 2</li>
							<li><i class="icon-eye-open"></i> 20</li>
						</ul>
					</div>
					<div class="tags-galery">
						<p><i class="icon-tags"></i> Tags : <a href="#">Sun</a>, <a href="#">Sunrise</a>, 
						<a href="#">Dawn</a>, <a href="#">Morning</a>, <a href="#">Landscape</a></p>
					</div>
				</div>
				<div class="span3 galery">
					<div class="menu-galery">
						<ul>
							<li><a href="#" rel="tooltip" title="Detail"><i class="iconbig-search"></i></a></li>
							<li><a href="#" rel="tooltip" title="Add Comment"><i class="iconbig-speak"></i></a></li>
							<li><a href="#" rel="tooltip" title="Download"><i class="iconbig-download"></i></a></li>
							<li><a href="#" rel="tooltip" title="Like"><i class="iconbig-black-star"></i></a></li>
						</ul>
					</div>
					<div class="image-galery"><a class="group" rel="group1" href="img/3_b.jpg"><img src="img/3_b.jpg" /></a></div>
					<div class="count-galery">
						<ul>
							<li><i class="icon-comment"></i> 5</li>
							<li><i class="icon-download-alt"></i> 7</li>
							<li><i class="icon-star"></i> 2</li>
							<li><i class="icon-eye-open"></i> 20</li>
						</ul>
					</div>
					<div class="tags-galery">
						<p><i class="icon-tags"></i> Tags : <a href="#">Sun</a>, <a href="#">Sunrise</a>, 
						<a href="#">Dawn</a>, <a href="#">Morning</a>, <a href="#">Landscape</a></p>
					</div>
				</div>
				<div class="span3 galery">
					<div class="menu-galery">
						<ul>
							<li><a href="#" rel="tooltip" title="Detail"><i class="iconbig-search"></i></a></li>
							<li><a href="#" rel="tooltip" title="Add Comment"><i class="iconbig-speak"></i></a></li>
							<li><a href="#" rel="tooltip" title="Download"><i class="iconbig-download"></i></a></li>
							<li><a href="#" rel="tooltip" title="Like"><i class="iconbig-black-star"></i></a></li>
						</ul>
					</div>
					<div class="image-galery"><a class="group" rel="group1" href="img/4_b.jpg"><img src="img/4_b.jpg" /></a></div>
					<div class="count-galery">
						<ul>
							<li><i class="icon-comment"></i> 5</li>
							<li><i class="icon-download-alt"></i> 7</li>
							<li><i class="icon-star"></i> 2</li>
							<li><i class="icon-eye-open"></i> 20</li>
						</ul>
					</div>
					<div class="tags-galery">
						<p><i class="icon-tags"></i> Tags : <a href="#">Sun</a>, <a href="#">Sunrise</a>, 
						<a href="#">Dawn</a>, <a href="#">Morning</a>, <a href="#">Landscape</a></p>
					</div>
				</div>
				<div class="span3 galery">
					<div class="menu-galery">
						<ul>
							<li><a href="#" rel="tooltip" title="Detail"><i class="iconbig-search"></i></a></li>
							<li><a href="#" rel="tooltip" title="Add Comment"><i class="iconbig-speak"></i></a></li>
							<li><a href="#" rel="tooltip" title="Download"><i class="iconbig-download"></i></a></li>
							<li><a href="#" rel="tooltip" title="Like"><i class="iconbig-black-star"></i></a></li>
						</ul>
					</div>
					<div class="image-galery"><a class="group" rel="group1" href="img/5_b.jpg"><img src="img/5_b.jpg" /></a></div>
					<div class="count-galery">
						<ul>
							<li><i class="icon-comment"></i> 5</li>
							<li><i class="icon-download-alt"></i> 7</li>
							<li><i class="icon-star"></i> 2</li>
							<li><i class="icon-eye-open"></i> 20</li>
						</ul>
					</div>
					<div class="tags-galery">
						<p><i class="icon-tags"></i> Tags : <a href="#">Sun</a>, <a href="#">Sunrise</a>, 
						<a href="#">Dawn</a>, <a href="#">Morning</a>, <a href="#">Landscape</a></p>
					</div>
				</div>
			</div>
		</div>
		<div class="container footer">
			<hr class="alt" />
			<div class="row">
				<div class="span6">&copy; 2012. All right reserved.</div>
				<div class="span6">
				</div>
			</div>
		</div>
		<script src="${ContextPath}/js/jquery.min.js"></script>
		<script src="${ContextPath}/js/bootstrap.js"></script>
		<script src="${ContextPath}/js/jquery.mousewheel-3.0.6.pack.js"></script>
	</body>
</html>
