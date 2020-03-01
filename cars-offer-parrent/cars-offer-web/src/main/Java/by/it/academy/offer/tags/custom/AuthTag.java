package by.it.academy.offer.tags.custom;

import by.it.academy.entity.Access;
import by.it.academy.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.ConditionalTagSupport;

public class AuthTag extends ConditionalTagSupport {

    private String path = "";

    @Override
    protected boolean condition() {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

        HttpSession session = request.getSession();

//        Access access = (Access) session.getAttribute("role");
//        return access != null && access.getRole().equals("Admin");

        User user = (User) session.getAttribute("userName");

        return user != null && user.getUserName().equals("Kris");
    }

    public void setPath(String path) {
        this.path = path;
    }
}
