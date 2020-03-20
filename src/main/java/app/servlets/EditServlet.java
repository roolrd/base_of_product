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

@WebServlet(name = "EditServlet", value = "/product/edit")
public class EditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Product product = new Product();

        product.setName(req.getParameter("nameJ"));
        product.setCategory (Integer.parseInt(req.getParameter("categoryId")));
        product.setDateOfProduce(Date.valueOf(req.getParameter("dateOfProduceJ")));
        product.setDateOfExpired(Date.valueOf(req.getParameter("dateOfExpiredJ")));
        product.setAmount(Integer.parseInt(req.getParameter("amountJ")));
        product.setPrice(Double.parseDouble(req.getParameter("priceJ")));
        product.setProvider(req.getParameter("providerJ"));
        product.setnPhoneProvider(req.getParameter("nPhoneProviderJ"));
        product.setDateOfDelivery(Date.valueOf(req.getParameter("dateOfDeliveryJ")));
        product.setNoWarehouse(req.getParameter("noWarehouseJ"));
        product.setDescription(req.getParameter("descriptionJ"));
        product.setNotes(req.getParameter("notesJ"));

        int productID = Integer.parseInt(req.getParameter("id"));
        ProductDao.update(product, productID);

        resp.sendRedirect("/list");

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int productID = Integer.parseInt(req.getParameter("id"));
       Product product = ProductDao.read(productID);
        req.setAttribute("product",product);

        List<Category> categories = CategoryDao.readAll();
        req.setAttribute("categories",categories);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/edit.jsp");
        requestDispatcher.forward(req, resp);

    }
}