A Java servlet app designed to run on Tomcat8 and Linux with VLC media player.
After proper configuration simply uses VLC to stream camera through HTTP which is then displayed in Tomcat with controls to start or stop streaming and to save clips of the stream.

Configuration saved in a simple JSON file. Empty example can be found in WebContent/WEB-INF/WebCamConfig.

Clips can be saved to a designated folder by pressing a button on the website. This saves the previous 1 GB of data, the size limit is set in FileControl.java.
