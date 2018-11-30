import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.stream.DoubleStream;

public class ValidatorXYR  {
    public boolean validate(HttpServletRequest req){
        Map<String, String[]> parameterMap = req.getParameterMap();
        for(String k : parameterMap.keySet()) {
            if (parameterMap.get(k).length != 1) return false;
        }

        String strX = req.getParameter("hidden_field_X");
        String strY =  req.getParameter("Y");
        String strR = req.getParameter("hidden_field_R");
        if(strX == null || strY == null || strR == null) return false;
        if(strX.length() > 8 || strY.length() > 8 || strR.length() > 8) return false;

        double X, Y, R;
        try {
            X = Double.parseDouble(strX);
            Y = Double.parseDouble(strY);
            R = Double.parseDouble(strR);
        }
        catch (NumberFormatException e) {
            return false;
        }

        double[] validRValues = {1, 2, 3, 4, 5};
        if(X < -4 || X > 4) return false;
        if(Y < -5 || Y > 5) return false;
        if(DoubleStream.of(validRValues).noneMatch(a -> a == R)) return false;
        return true;
    }
}