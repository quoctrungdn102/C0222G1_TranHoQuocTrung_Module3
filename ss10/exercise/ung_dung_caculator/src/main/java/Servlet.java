import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet",urlPatterns ="")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double firstOperand = Double.parseDouble(request.getParameter("num1"));
        Double secondOperand = Double.parseDouble(request.getParameter("num2"));
        String operator = request.getParameter("operator");
        request.setAttribute("num1", firstOperand);
        request.setAttribute("num2", secondOperand);
        request.setAttribute("opera", operator);
        request.getRequestDispatcher("trung.jsp").forward(request, response);
    }
}
