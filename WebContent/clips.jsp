<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="webcam.*, java.util.ArrayList, java.nio.file.Path"%>
    <%
    ArrayList<Path> clips = FileControl.getClips();
    Configuration conf = FileControl.getConfig();
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Clips</title>
</head>
<body>
<h1>Saved clips:</h1>
<%
for(Path clip : clips) {
%>
<a href="<%=conf.getPathToClips()%>/<%=clip.getFileName()%>"><%=clip.getFileName()%></a>
<%	
}
%>
</body>
</html>