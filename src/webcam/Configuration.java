package webcam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Configuration {

	// --------------- Configuration -----------------------------

	private String device;
	private String source;
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
	
	public String getSource() {
		return source;
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
	
	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Configuration[device=" + device + ",source=" + source + ",pathToScriptDir=" + pathToScriptDir
				+ ",pathToClipDir=" + pathToClipDir + ",pathToWebCamFile=" + pathToWebCamFile + ",pathToClips="
				+ pathToClips + "]";
	}

}