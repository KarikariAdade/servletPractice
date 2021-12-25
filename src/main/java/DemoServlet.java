

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DemoServlet() {
        super();
    }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int total = (int) request.getAttribute("total");
		
		response.getWriter().println("The total is: "+total);
		
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		HttpSession session = request.getSession();
		
		response.getWriter().println(session.getAttribute("total"));
		
		
	}


}
