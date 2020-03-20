package app.servlets;

import app.dao.CategoryDao;
import app.dao.ProductDao;
import app.entities.Category;
import app.entities.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "AddServlet"/*,value = "addProduct"*/)
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product product = new Product();

       // Validator validator = new Validator();

        product.setName(req.getParameter("nameJ"));
       // product.setName(req.getParameter("nameJ").isEmpty() ? null : req.getParameter("nameJ"));
        // String nameS = req.getParameter("nameJ");

        product.setCategory(Integer.parseInt(req.getParameter("categoryId")));
        //  int category = (!categoryJ.isEmpty() ? Integer.parseInt(categoryJ) : null);

        product.setDateOfProduce(Date.valueOf(req.getParameter("dateOfProduceJ")));
//          String dateOfProduceS = req.getParameter("dateOfProduceJ");
//          product.setDateOfProduce(Date.valueOf(!(dateOfProduceS.isEmpty() && dateOfProduceS!=null)? dateOfProduceS : "01.01.2000"));

        product.setDateOfExpired(Date.valueOf(req.getParameter("dateOfExpiredJ")));
        product.setAmount(Integer.parseInt(req.getParameter("amountJ")));
       // product.setAmount(Integer.parseInt(!req.getParameter("amountJ").isEmpty() ? req.getParameter("amountJ") : 0));
        //  String amountS = req.getParameter("amountJ");

        product.setPrice(Double.parseDouble(req.getParameter("priceJ")));
        //  product.setPrice(!req.getParameter("priceJ").isEmpty() ? Double.parseDouble(req.getParameter("priceJ")) : 0.00);
        //  String priceS = req.getParameter("priceJ");

        product.setProvider(req.getParameter("providerJ"));
        product.setnPhoneProvider(req.getParameter("nPhoneProviderJ"));
        product.setDateOfDelivery(Date.valueOf(req.getParameter("dateOfDeliveryJ")));
        product.setNoWarehouse(req.getParameter("noWarehouseJ"));
        product.setDescription(req.getParameter("descriptionJ"));
        product.setNotes(req.getParameter("notesJ"));

        ProductDao.create(product);

        //resp.sendRedirect("/products/all");

        req.setAttribute("productName", req.getParameter("nameJ"));
       // System.out.println(req.getParameter("nameJ"));

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/add.jsp");
        requestDispatcher.forward(req, resp);
            }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Category> categories = CategoryDao.readAll();
        req.setAttribute("categories",categories);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/add.jsp");
        requestDispatcher.forward(req, resp);
    }
}
