package by.it.academy.offer.servlet;

import by.it.academy.entity.Order;
import by.it.academy.offer.service.OrderService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Slf4j
@WebServlet(urlPatterns = "/Orders")
public class OrdersServlet extends HttpServlet {

    private OrderService orderService = new OrderService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Order> AllOrders = orderService.getAllOrders();

        log.info("cars {}", AllOrders);

        req.setAttribute("AllOrders",AllOrders);

        req.getRequestDispatcher("/WEB-INF/jsp/show-orders.jsp").forward(req, resp);
    }

}
