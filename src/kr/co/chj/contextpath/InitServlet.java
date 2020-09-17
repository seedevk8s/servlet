package kr.co.chj.contextpath;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(urlPatterns = {"/Init", "/Init2"},   //urlPatterns를 이용해 매핑 이름을 여러 개 설정할수 있음.
			initParams = {@WebInitParam(name="id", value="admin2"),		//@WebInitParam을 이용해 여러 개의 매개변수를 설정.
						  @WebInitParam(name="pw", value ="12345"),
						  @WebInitParam(name="local", value ="Inchon")})
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ServletConfig
		String id = getInitParameter("id");		//설정한 매개변수의 name으로 값을 가져옴.
		String pw = getInitParameter("pw");
		String local = getInitParameter("local");
		
		System.out.println("id : " + id);
		System.out.println("비밀번호 : " + pw);
		System.out.println("지역 : " + local);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
