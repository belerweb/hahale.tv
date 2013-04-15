<!DOCTYPE html>
<html lang="zh" class="body-error">
	<#assign ContextPath=springMacroRequestContext.getContextPath() />
	<head>
		<meta charset="utf-8">
		<meta content="text/html; charset=UTF-8" http-equiv="Content-Type">
		<title>哈哈乐后台管理 - 登录</title>
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
				<form action="" class="form-login"> 
					<div class="content-login">
						<div class="header">账号登录</div>
						<div class="inputs">
							<input name="" type="text" placeholder="" />
							<input name="" type="password"  placeholder="" />
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
								<li class="qq text-center" id="qqLoginBtn"></li>
							</ul>
						</div>
						<div class="clear"></div>
					</div>
				</form>
			</div>
		</div>
		<script src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" data-appid="100420587" data-redirecturi="${scheme}://${serverName}${ContextPath}/connector/qq.htm" charset="utf-8"></script> 
		<script>QC.Login({btnId:'qqLoginBtn'},function(){console.log(arguments);});</script>
	</body>
</html>
