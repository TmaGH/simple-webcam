package webcam;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebCamControl
 */
@WebServlet("/WebCamControl")
public class WebCamControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WebCamControl() {
		super();
		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			CameraStream.killStream();
		}));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String start = request.getParameter("start");
		String stop = request.getParameter("stop");
		String save = request.getParameter("save");

		if (start != null) {
			try {
				CameraStream.startStream();
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (stop != null) {
			CameraStream.killStream();
		}

		if (save != null) {
			System.out.println("save.");
			CameraStream.killStream();
			FileControl.saveClip();
			try {
				TimeUnit.SECONDS.sleep(1);
				CameraStream.startStream();
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		doGet(request, response);
	}
}
