

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Dashboard
 */
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession(); //Calling getSession() and getSession(true) are 
											//functionally the same: retrieve the current session, 
											//and if one doesn't exist yet, create it. 
											//Calling getSession(false), though, retrieves the current session, 
											//and if one doesn't exist yet, returns null
		String userId = (String)session.getAttribute("userId");	
		
		PrintWriter out = response.getWriter();
        out.println("<html><body>");        
        if (userId == null) {
            out.println("No UserId was found in HTTP Session.<br>");
        } else {
            out.println("UserId found in HTTP Session: " + userId + "<br>");            
        }
        out.println("</body></html>");
        
        session.invalidate();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
