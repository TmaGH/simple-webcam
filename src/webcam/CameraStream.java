package webcam;

import java.io.IOException;

public class CameraStream {

	private static double streamid;
	private final static FileControl fc = new FileControl();
	private static Thread fileSizeLimiter = null;

	private CameraStream() {
	}

	protected static void killStream() {
		ProcessBuilder pb = new ProcessBuilder("killall", "vlc");
		try {
			pb.start();
			if (fileSizeLimiter != null) {
				fileSizeLimiter.interrupt();
			}
			System.out.println("Killed stream.");
		} catch (IOException e) {
			System.out.println("Killing process failed.");
			e.printStackTrace();
		}
	}

	protected static void startStream() {
		Configuration conf = FileControl.getConfig();
		streamid = Math.random();
		System.out.println("started stream.");
		try {
			ProcessBuilder pb = new ProcessBuilder(conf.getpathToScriptDir() + "/start_stream.sh", conf.getDevice(), conf.getPort(),
					Double.toString(streamid), conf.getPathToWebCamFile());
			pb.start();
			fileSizeLimiter = new Thread(fc);
			fileSizeLimiter.start();
		} catch (Exception e) {
			e.printStackTrace();
			killStream();
		}
	}

	public static double getStreamid() {
		return streamid;
	}
}
