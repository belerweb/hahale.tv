<!DOCTYPE html>
<html lang="zh" class="body-error">
	<#assign ContextPath=springMacroRequestContext.getContextPath() />
	<head>
		<meta charset="utf-8">
		<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
		<title>哈哈乐视频网 - 登录</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">
		<link href="${ContextPath}/css/login.css" rel="stylesheet">
		<link href="${ContextPath}/css/bootstrap.css" rel="stylesheet">
		<link rel="stylesheet" href="${ContextPath}/css/icon/font-awesome.css">    
		<link rel="stylesheet" href="${ContextPath}/css/bootstrap-responsive.css">
		<!--[if lt IE 9]>
		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
	</head>
	<body>
		<div id="wrapper">
			<div id="login" class="animate form position">
				<form action="${ContextPath}/login.do" method="post" class="form-login"> 
					<div class="content-login">
						<div class="header">账号登录</div>
						<div class="inputs">
							<input name="j_username" type="text" placeholder="" />
							<input name="j_password" type="password"  placeholder="" />
						</div>
						<div class="link-1"><a href="#">注册</a></div>
						<div class="link-2"><a href="#">忘记密码？</a></div>
						<div class="clear"></div>
						<div class="button-login"><input type="submit" class="" value="登录"></div>
					</div>
					<div class="footer-login">
						<div class="pull-left">合作网站账号登录</div>
						<div class="pull-right">
							<ul class="social-links">
								<li class="qq text-center"><a href="${ContextPath}/connector/qq_login.do"><img alt="QQ登录" src="http://qzonestyle.gtimg.cn/qzone/vas/opensns/res/img/Connect_logo_7.png"></a></li>
								<li class="sina text-center"><a href="${ContextPath}/connector/weibo_login.do"><img alt="用微博登录" src="http://timg.sjs.sinajs.cn/t4/appstyle/widget/images/loginButton/loginButton_24.png"></a></li>
							</ul>
						</div>
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>
		<script src="${ContextPath}/js/jquery.js"></script>
	</body>
</html>
