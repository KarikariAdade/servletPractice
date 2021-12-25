

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ComputeServlet
 */
@WebServlet("/ComputeServlet")
public class ComputeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ComputeServlet() {
        super();
    }

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numb1 = Integer.parseInt(request.getParameter("numb1"));
		
		int numb2 = Integer.parseInt(request.getParameter("numb2"));
		
		String type = request.getParameter("type");
	
		
		int total = 0;
		

		if("add".equals(type)) {
			total = numb1 + numb2;
		}
		if("subtract".equals(type)) {
			total = numb1 - numb2;
		}
		if("divide".equals(type)){
			total = numb1 / numb2;
		}
		
		if("multiply".equals(type)) {
			total = numb1 * numb2;
		}
		
		// Call another servelet
		// You can pass request and response parameters to the 
		// newly called servlet through requestDispatcher
		
		request.setAttribute("total", total);
		
		RequestDispatcher rd = request.getRequestDispatcher("DemoServlet");
		
		
//		rd.forward(request, response);
		
		
		// Send redirect and store session 
		
		HttpSession session = request.getSession();
		
		session.setAttribute("total", total);
		
		
		response.sendRedirect("DemoServlet");
		
//		response.getWriter().println("The total value is: "+total);
	}

}
