package fr.khouya.app.servlets;

import java.io.IOException;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.khouya.beans.HelloBean;
import fr.khouya.ejb.HelloEJBRemote;

/**
 * Servlet implementation class HelloEJBServlet
 */
@WebServlet("/HelloEJB")
public class HelloEJBServlet extends HttpServlet {

	private static final long serialVersionUID = 7637150755433767736L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public HelloEJBServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String name = request.getParameter("nom");
		String message = "";
		HelloBean bean = new HelloBean();
		

		// Connexion JNDI (annuaire pour localiser l'EJB)
		try {
			final Hashtable<String, String> jndiProperties = new Hashtable<>();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

			final Context context = new InitialContext(jndiProperties);
			final String appName = "HelloEAR";
			final String moduleName = "HelloEJBProject";
			final String beanName = "HelloJNDI";
			final String viewClassName = HelloEJBRemote.class.getName();
			HelloEJBRemote remote =
					(HelloEJBRemote) context.lookup("ejb:"+appName+"/"+moduleName+"/"+beanName+"!"+viewClassName);
			remote.insertIntoTable(name);
		} catch (Exception e) {
			e.printStackTrace();
		}

		bean.setName(message);
		session.setAttribute("beanHello", bean);
		response.sendRedirect("HelloBean.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
