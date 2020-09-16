package kr.co.chj.servletParameter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/formRequest")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doPost() 호출");
		/*
		 * <한글처리>
		 * 1.톰캣서버의 default 문자 처리 방식 : ISO-8859-1 방식임.
		 * 2.서블릿단에서 별도의 한글 인코딩을 하지 않으면 한글이 깨질수 있음.
		 * 3.get 방식과 post방식의 한글처리가 다름.
		 * 4.get 방식 한글처리 : Servers(톰캣서버 폴더내)에 있는 server.xml에서 
		 * 					<connector>에 URIEncoding="UTF-8" 추가해야함.
		 * 5.post 방식 한글처리 : doPost() 메서드 내에서 설정함
		 * 					 request.setCharacterEncoding("UTF-8");
		 */
		request.setCharacterEncoding("utf-8");	//전송된 데이터를 UTF-8으로 인코딩함.
		
		//getParameter()를 이용해 <input>태그의 name 속성값으로 전송된 value값을 받아 옴.
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String password = request.getParameter("pw");
		
		//하나의 name으로 여러 값을 전송하는 경우 getParameterValues()를 이용해 배열 형태로 받아 옴.
		String[] hobbys = request.getParameterValues("hobby");
		
		String gender = request.getParameter("gender");
		String local = request.getParameter("local");
		
		//setContentType()을 이용해 응답할 데이터 종류가 HTML임을 설정함.
		response.setContentType("text/html; charset=utf-8");		
		//getWriter()를 이용해 출력 스트림 PrintWriter 객체를 받아옴
		//데이터를 출력할 PrintWriter 객체 생성
		PrintWriter out = response.getWriter();
		
		//출력 데이터를 HTML 형식으로 만듦
		//println()를 이용해 HTML 태그 문자열을 웹 브라우저로 출력함
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		
		out.println("이름 : " +name+ "<br/>");
		out.println("아이디 : " +id+ "<br/>");
		out.println("비밀번호 : " +password+ "<br/>");
		out.println("취미 : " +Arrays.toString(hobbys)+ "<br/>");
		out.println("성별 : " +gender+ "<br/>");
		out.println("지역 : " +local+ "<br/>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.close();
		
	}

}



























