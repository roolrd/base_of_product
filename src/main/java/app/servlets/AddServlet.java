package app.servlets;

import app.dao.CategoryDao;
import app.dao.DBconnect;
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


       // String nameJ = req.getParameter("nameJ");
      //  product.setName(!nameJ.isEmpty() ? nameJ : "null");
        product.setName(req.getParameter("nameJ"));


        product.setCategory(Integer.parseInt(req.getParameter("categoryId")));
//        int category = (!categoryJ.isEmpty() ? Integer.parseInt(categoryJ) : null);

        product.setDateOfProduce(Date.valueOf(req.getParameter("dateOfProduceJ")));
//        Date dateOfProduce = (!dateOfProduceJ.isEmpty() ? Date.valueOf(dateOfProduceJ) : null);

        product.setDateOfExpired(Date.valueOf(req.getParameter("dateOfExpiredJ")));
//        Date dateOfExpired = (!dateOfExpiredJ.isEmpty() ? Date.valueOf(dateOfExpiredJ) : null);

        product.setAmount(Integer.parseInt(req.getParameter("amountJ")));
//        int amount = (!amountJ.isEmpty() ? Integer.parseInt(amountJ) : 0);

        product.setPrice(Double.parseDouble(req.getParameter("priceJ")));
//        double price = (!priceJ.isEmpty() ? Double.parseDouble(priceJ) : 0);

        product.setProvider(req.getParameter("providerJ"));
//        String provider = (!providerJ.isEmpty() ? providerJ : null);

        product.setnPhoneProvider(req.getParameter("nPhoneProviderJ"));
//        String nPhoneProvider = (!nPhoneProviderJ.isEmpty() ? nPhoneProviderJ : null);

        product.setDateOfDelivery(Date.valueOf(req.getParameter("dateOfDeliveryJ")));
//        Date dateOfDelivery = (!dateOfDeliveryJ.isEmpty() ? Date.valueOf(dateOfDeliveryJ) : null);

        product.setNoWarehouse(req.getParameter("noWarehouseJ"));
//        String noWarehouse = (!noWarehouseJ.isEmpty() ? noWarehouseJ : null);

        product.setDescription(req.getParameter("descriptionJ"));
//        String description = (!descriptionJ.isEmpty() ? descriptionJ : null);

        product.setNotes(req.getParameter("notesJ"));
  //      String notes = (!notesJ.isEmpty() ? notesJ : null);

//        Product product = new Product(name, category, dateOfProduce, dateOfExpired, amount, price, provider, nPhoneProvider,
//               dateOfDelivery, noWarehouse, description, notes);
        ProductDao.create(product);

        //resp.sendRedirect("/products/all");

        req.setAttribute("productName", req.getParameter("nameJ"));
        System.out.println(req.getParameter("nameJ"));

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
