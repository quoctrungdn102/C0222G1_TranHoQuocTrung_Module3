package controler;

import model.Product;
import service.ProductServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/productServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "creat":
                creatProduct(request, response);
                break;
            case "edit":
                editProduct(request,response);
                break;
        }
    }

    ProductServicelmpl productServicelmpl = new ProductServicelmpl();



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "displayProduct":
                goProductList(request, response);
                break;
            case "creatProduct":
                response.sendRedirect("creat.jsp");
                break;
            case "edit":
                goEditProduct(request, response);
            case "delete":
                deleteProduct(request,response);
                break;
            case "view":
                goView(request,response);
            case "search":
                goSearch(request,response);
                break;

            default:
                request.getRequestDispatcher("menu.jsp").forward(request, response);
        }

    }

    private void goSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("input");
        Product product = productServicelmpl.searchProduct(name);
        if (product == null){
            request.setAttribute("mes","khong tim thay san pham hop le");
        }else {
            request.setAttribute("product",product);
        }
        request.getRequestDispatcher("search.jsp").forward(request,response);
    }

    private void goView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product =  productServicelmpl.viewProduct(id);
        request.setAttribute("product",product);
        request.getRequestDispatcher("view.jsp").forward(request,response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id = Integer.parseInt(request.getParameter("id"));
       productServicelmpl.deleteProduct(id);
       request.setAttribute("mes" , "delete product <"+ id+ "> successful " );
       goProductList(request,response);
    }

    private void goEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }
    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String origin = request.getParameter("origin");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(id, name, origin, price);
        productServicelmpl.creatProduct(product);
        request.setAttribute("mes", "update successful");
        goProductList(request, response);
    }


    private void goProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productServicelmpl.displayProduct();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void creatProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String origin = request.getParameter("origin");
        double price = Double.parseDouble(request.getParameter("price"));
        Product product = new Product(id, name, origin, price);
        productServicelmpl.creatProduct(product);
        request.setAttribute("mes", "create successful");
        goProductList(request, response);
    }

}
