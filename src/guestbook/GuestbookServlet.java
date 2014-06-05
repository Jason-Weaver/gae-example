package guestbook;

import java.io.IOException;
import javax.servlet.http.*;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class GuestbookServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
              throws IOException {
        User user = UserServiceFactory.getUserService().getCurrentUser();
        
        if (user != null) {
            resp.setContentType("text/plain");
            resp.getWriter().println("Howdy, " + user.getNickname());
        } else {
            resp.sendRedirect(UserServiceFactory.getUserService().createLoginURL(req.getRequestURI()));
        }
    }
}