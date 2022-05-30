import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet" , urlPatterns = "/trung")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float firstOperand = Float.parseFloat(request.getParameter("num1"));
        float secondOperand = Float.parseFloat(request.getParameter("num2"));
        String operator = request.getParameter("operator");
        request.setAttribute("num1", firstOperand);
        request.setAttribute("num2", secondOperand);
        request.setAttribute("opera", operator);

        float result = 0;
        switch (operator){
            case "+":
                result = firstOperand + secondOperand;
                break;
            case "-":
                result = firstOperand -secondOperand;
                break;
            case "*":
                result = firstOperand*secondOperand;
                break;
            case "/":
                result = firstOperand/secondOperand;
                break;
        }
        request.setAttribute("result",result);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
