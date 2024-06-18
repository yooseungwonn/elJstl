package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import vo.UserVo;

@WebServlet("/04")
public class Servlet04 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		UserVo userVo = new UserVo(1, "박명수", "park", "1234", "male");
		
		// PageScope -> 세팅 불가
		
		// RequestScope
		
		request.setAttribute("userVo", userVo);		
		request.setAttribute("num", 1);
		request.setAttribute("str", "안녕하세요");
		
		// SessionScope
		UserVo userVo2 = new UserVo(2, "홍길동", "hong", "4567", "male");
		request.getSession(true).setAttribute("userVo2", userVo2);
		
		// ApplicationScope : 모든 서블릿이 공유하는 객체
		UserVo userVo3 = new UserVo(3, "장길산", "jang", "9876", "male");
		request.getServletContext().setAttribute("userVo3", userVo3);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/04.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
