<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSE Demo</title>

</head>
<body>


<div id="msgFrompPush"></div>
<script type="text/javascript" src="<c:url value="assets/js/jquery.js" />"></script>
<script type="text/javascript">


 //1.EventSource对象只有chrome，火狐等浏览器才有
 if (!!window.EventSource) {
       //设置消息源映射为:see/push
	   var source = new EventSource('push'); 
	   s='';
	   //2.添加SSE客户监听，在此获得服务器推送的消息
	   source.addEventListener('message', function(e) {
		   s+=e.data+"<br/>";
		   $("#msgFrompPush").html(s);
	     
	   });

	   source.addEventListener('open', function(e) {
	        console.log("连接打开.");
	   }, false);

	   source.addEventListener('error', function(e) {
	        if (e.readyState == EventSource.CLOSED) {
	           console.log("连接关闭");
	        } else {
	            console.log(e.readyState);    
	        }
	   }, false);
	} else {
	        console.log("你的浏览器不支持SSE");
	} 
</script>
</body>
</html>