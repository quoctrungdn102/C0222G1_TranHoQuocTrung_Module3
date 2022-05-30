import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CalculatorServlet" , urlPatterns = "/Product")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
try{
    String ProductDescription = request.getParameter("Description");
    Double ListPrice = Double.parseDouble(request.getParameter("price"));
    Double DiscountPercent = Double.parseDouble(request.getParameter("DiscountPercent"));
    Double amount  =(ListPrice * DiscountPercent *0.01 );
    Double discountAmount = ListPrice-amount;

    writer.println(ProductDescription);
    writer.println("gia chua chiet khau "+ListPrice);
    writer.println("chiet khau "+ amount+"%");
    writer.println("gia sau chiet khau "+discountAmount);
}catch (Exception e){
    writer.println("loi roi chu oi ");
}



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
