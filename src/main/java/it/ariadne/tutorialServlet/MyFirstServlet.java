package it.ariadne.tutorialServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyFirstServlet
 */

@WebServlet(
		name = "MyFirstServlet",
		urlPatterns = {"/seiMongo", "/MyFirstServlet"},
		loadOnStartup = 1)

public class MyFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	public MyFirstServlet() {
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet " + this.getServletName() + " has started.");
	}

	@Override
	public void destroy() {
		System.out.println("Servlet " + this.getServletName() + " has stopped.");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private static final String DEFAULT_USER = "Guest";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("I am in the doGET method");
		/*
		 * System.out.println("Content type: " + request.getContentType());
		 * System.out.println("Character Encoding: " +
		 * request.getCharacterEncoding());
		 * System.out.println("Content Length: " +request.getContentLength());
		 * System.out.println("Input Stream: " +
		 * request.getInputStream().toString()); System.out.println("URL: "
		 * +request.getRequestURL()); System.out.println("URL: "
		 * +request.getRequestURI());
		 * response.getWriter().println("Ciao, Mongo!");
		 * System.out.println("Sei Mongo?");
		 */
		String user = request.getParameter("user");
		if (user == null)
			user = MyFirstServlet.DEFAULT_USER;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\r\n").append("<html>\r\n").append(" <head>\r\n")
				.append(" <title>Hello User Application</title>\r\n").append(" </head>\r\n").append(" <body>\r\n")
				.append(" Hello, ").append(user).append("!<br/><br/>\r\n")
				.append(" <form action=\"seiMongo\" method=\"POST\">\r\n").append(" Enter your name:<br/>\r\n")
				.append(" <input type=\"text\" name=\"user\"/><br/>\r\n")
				.append(" <input type=\"submit\" value=\"Submit\"/>\r\n").append(" </form>\r\n").append(" </body>\r\n")
				.append("</html>\r\n");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("I am in the doPOST method");
		this.doGet(request, response);
	}
}
