package by.it.academy.offer.servlet;

import by.it.academy.service.OrderDaoImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/Car-order")
public class OrderVerificationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/order-verification.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String errorMsg = "";
        boolean hasError = false;

        String name = req.getParameter("Name");

        if (name.length() == 0) {
            hasError = true;
            errorMsg = "name should't be emnpty";
        }

        String telephone = req.getParameter("MobileTelephone");
        String email = req.getParameter("Email");
        int kolVoDay = Integer.parseInt(req.getParameter("NumberOfDays"));
        String wishes = req.getParameter("Wishes");

        OrderDaoImpl orderService = new OrderDaoImpl();
        orderService.create(null,name,telephone,email,kolVoDay,wishes);

        PrintWriter pw = resp.getWriter();
        pw.print("Your order has been successfully added. Expect to be contacted.");

    }
}
