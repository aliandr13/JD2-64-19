package by.it.academy.offer.servlet;

import by.it.academy.offer.model.Product;
import by.it.academy.offer.service.ProductService;
import by.it.academy.offer.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/productCreate")
public class ProductCreateService extends HttpServlet {

    private ProductService productService = ProductServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/productCreate.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String carModel = req.getParameter("carModel");
        String priceForHour = req.getParameter("priceForHour");
        String color = req.getParameter("color");
        String engine = req.getParameter("engine");
        String year = req.getParameter("year");

        Product product = new Product(null, carModel, Double.valueOf(priceForHour), color, engine, Integer.valueOf(year));
        productService.addNewProduct(product);

        resp.sendRedirect(req.getContextPath() + "/productList");
    }
}
