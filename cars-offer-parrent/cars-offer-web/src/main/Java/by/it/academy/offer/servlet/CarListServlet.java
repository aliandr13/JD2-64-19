package by.it.academy.offer.servlet;

import by.it.academy.offer.model.Client;
import by.it.academy.offer.service.ClientService;
import by.it.academy.offer.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/productList")
public class CarListServlet extends HttpServlet {

    private ClientService service = ClientServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> allClients = service.getAllClients();
        req.setAttribute("model-list", allClients);
        req.getRequestDispatcher("/WEB-INF/jsp/model-list.jsp")
                .forward(req, resp);
    }
}
