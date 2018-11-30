import Bean.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.Calendar;

public class AreaCheckServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double X, Y, R;

        X = Double.parseDouble(req.getParameter("hidden_field_X"));
        Y = Double.parseDouble(req.getParameter("Y"));
        R = Double.parseDouble(req.getParameter("hidden_field_R"));

        boolean isInArea = true;

        if (X > 0 && Y > 0) isInArea = false;
        else if (X <= 0 && Y >= 0 && X >= -R && Y <= R/2) isInArea = true;
        else if (X <= 0 && Y <= 0 && Y >= -X/2 - R/2) isInArea = true;
        else if (X >= 0 && Y <= 0 &&  X*X + Y*Y <= R*R) isInArea = true;
        else isInArea = false;

        Hit hit = new Hit(X, Y, R, isInArea, new SimpleDateFormat("yyyy.MM.dd/HH.mm.ss").format(Calendar.getInstance().getTime()));
        HttpSession session = req.getSession();

        HitsHandler handler;
        ArrayDeque<Hit> previousHits;

        if (session.getAttribute("previousHits") == null) {
            handler = new HitsHandler();
            previousHits = new ArrayDeque<>();
        } else {
            handler = (HitsHandler) session.getAttribute("previousHits");
            previousHits = handler.getPreviousHits();
        }
        previousHits.push(hit);
        handler.setPreviousHits(previousHits);
        session.setAttribute("previousHits", handler);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/MyView.jsp");
        requestDispatcher.forward(req, resp);
    }
}