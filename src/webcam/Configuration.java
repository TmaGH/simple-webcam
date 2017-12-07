package webcam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Configuration {

	// --------------- Configuration -----------------------------

	private String device;
	private String port;
	private String pathToScriptDir;
	private String pathToClipDir;
	private String pathToWebCamFile;
	private String pathToClips;

	// ----------------------------------------------------------

	public String getPathToClips() {
		return pathToClips;
	}

	public String getPathToWebCamFile() {
		return pathToWebCamFile;

	}

	public String getpathToClipDir() {
		return pathToClipDir;
	}

	public String getpathToScriptDir() {
		return pathToScriptDir;
	}

	public String getDevice() {
		return device;
	}

	public String getPort() {
		return port;
	}

	public void setPathToClips(String pathToClips) {
		this.pathToClips = pathToClips;
	}

	public void setPathToWebCamFile(String pathToWebCamFile) {
		this.pathToWebCamFile = pathToWebCamFile;

	}

	public void setPathToClipDir(String pathToClipDir) {
		this.pathToClipDir = pathToClipDir;
	}

	public void setPathToScriptDir(String pathToScriptDir) {
		this.pathToScriptDir = pathToScriptDir;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public void setPort(String port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Configuration[device=" + device + ",port=" + port + ",pathToScriptDir=" + pathToScriptDir
				+ ",pathToClipDir=" + pathToClipDir + ",pathToWebCamFile=" + pathToWebCamFile + ",pathToClips="
				+ pathToClips + "]";
	}

}