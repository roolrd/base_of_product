package app.servlets;

//import app.dao.ProductDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "DeleteServlet", value = "/product/delete")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int productID = Integer.parseInt(req.getParameter("id"));
        ProductDao.delete(productID);
       // resp.sendRedirect("/list");

        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
        //requestDispatcher.forward(req, resp);


            }
}
