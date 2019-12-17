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


@WebServlet(urlPatterns =  "/client-list")
public class ClientListServlet extends HttpServlet {

    private final ClientService service = ClientServiceImpl.getService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> allStudents = service.getAllClients();
        req.setAttribute("clients", allStudents);
        req.getRequestDispatcher("/WEB-INF/jsp/client-list.jsp")
                .forward(req, resp);
    }
}

