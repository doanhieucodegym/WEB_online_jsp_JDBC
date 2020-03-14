package DoanHieu.controller.admin;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/admin-new-list"})
public class NewController extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				RequestDispatcher rd= req.getRequestDispatcher("/views/admin/new/list.jsp");
				rd.forward(req, resp);
	
}
}
