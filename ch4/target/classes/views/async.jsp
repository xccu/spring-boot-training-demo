<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>servlet async support</title>

</head>
<body>



<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript">

    //1.页面打开后就向后台发送请求
	deferred();
	
	function deferred(){
	    $.get('defer',function(data){ //ajax的get请求
	        //2.在控制台输出服务端的推送数据
	        console.log(data);
	        //3.一次请求完成后再向后台发送请求
	        deferred();
	    });
	}


</script>
</body>
</html>