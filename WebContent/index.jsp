<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="webcam.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Camera Control</title>
</head>
<body>
<h1>
<%
Configuration conf = FileControl.getConfig();
double streamid = CameraStream.getStreamid();
if (request.getParameter("start") != null) { %>
Please wait while the stream loads... 
<%} else if(request.getParameter("stop") != null) {
	streamid = 0;
	%>
Stopped stream 
<%} else if(request.getParameter("save") != null){%>
Saved clip
<%} else { %>
Camera Control Utility <%} %> 

</h1>
<video controls preload="none" id="stream" autoplay>
<source src="http://<%=conf.getSource()%><%=streamid%>" type="video/webm">
    Your browser does not support the VIDEO tag and/or WebM.
</video>

<form method="post" action="WebCamControl">
<input type="submit" name="start" value="Start" />
<input type="submit" name="stop" value="Stop" />
<input type="submit" name="save" value="Save Clip" />
</form>
<p>
Start/stop to control camera stream. Press "save clip" to save a portion of the stream (Approx. previous 1GB of stream) to the clips directory (link below).
</p>
<a href="<%=conf.getPathToClips()%>">Saved Clips</a>
</body>
</html>