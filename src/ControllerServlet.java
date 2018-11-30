import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidatorXYR validator = new ValidatorXYR();
        RequestDispatcher requestDispatcher;
        if (validator.validate(req)) {
            requestDispatcher = req.getRequestDispatcher("AreaCheckServlet");
        }
        else {
            requestDispatcher = req.getRequestDispatcher("index.jsp");
        }
        requestDispatcher.forward(req, resp);
    }
}