package webcam;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Calendar;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileControl implements Runnable {
	private static FileSystem fs = FileSystems.getDefault();
	private static Configuration config = readConfig();
	private static Path wc = fs.getPath(config.getPathToWebCamFile());
	private static Path cd = fs.getPath(config.getpathToClipDir());
	
	protected FileControl() {}

	protected static void saveClip() {
		Calendar cal = Calendar.getInstance();
		Path newClip = cd.resolve("Clip-" + cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "."
				+ cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":"
				+ cal.get(Calendar.SECOND));
		try {
			Files.copy(wc, newClip);
			Files.delete(wc);
		} catch (IOException e) {
			System.out.println("Failed to create clip. ");
			e.printStackTrace();

		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				if (Files.exists(wc) && Files.size(wc) >= 1000000000) {
					System.out.println("Deleting file...");
					Files.delete(wc);
					CameraStream.killStream();
					Thread.sleep(1000);
					CameraStream.startStream();
				}
				Thread.sleep(10000);
			}
		} catch (IOException ioe) {
			System.out.println("An error occured in file control system. Shutting down to prevent further problems.");
			ioe.printStackTrace();
			CameraStream.killStream();
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted.");
		}

	}
	
	public static Configuration readConfig() {
		Configuration newConfig = null;
		Path configFile = fs.getPath("/etc/WebCamConfig");
		try {
			String configString = new String(Files.readAllBytes(configFile));
			ObjectMapper mapper = new ObjectMapper();
			newConfig = mapper.readValue(configString, Configuration.class);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return newConfig;
	}
	
	public static Configuration getConfig() {
		return config;
	}
}
