package fr.khouya.app.servlets;

import fr.khouya.beans.HelloBean;

import java.io.IOException;
import java.util.Collection;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 4214547814660559772L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session
		HttpSession session = request.getSession(true);

		String nom = request.getParameter("n");

		HelloBean helloBean = new HelloBean();
		helloBean.setName(nom + " One Just");
		request.setAttribute("beanHello", helloBean);

		// list Of Beans
		Collection<HelloBean> listBeansHello = new Vector<>();
		for (int i = 0; i < 3; i ++) {
			HelloBean bean = new HelloBean();
			bean.setName(nom + " " + i);
			listBeansHello.add(bean);
		}
		session.setAttribute("listBean", listBeansHello);

		response.sendRedirect("HelloListBean.jsp");
		// request.getRequestDispatcher("HelloListBean.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
