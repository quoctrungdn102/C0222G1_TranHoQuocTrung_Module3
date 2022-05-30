package controller;

import model.Customer;
import service.CustomerServicelmpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customerServlet")
public class CustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action"); 
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                addNewCustomer(request, response);
                break;
            case "upDate":
                upDateCustomer(request, response);
                break;
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                response.sendRedirect("create.jsp");
                break;
            case "viewCustomer":

                viewCustomer(request, response);
                break;
            case "upDate":
                goUpDate(request, response);

                break;
            case "delete":
                delete(request,response);
                break;
            default:
                goCustomerList(request, response);

        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CustomerServicelmpl customerServicelmpl = new CustomerServicelmpl();
        customerServicelmpl.remove(id);
        goCustomerList(request,response);
    }


    private void goCustomerList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerServicelmpl customerServicelmpl = new CustomerServicelmpl();
        request.setAttribute("CustomerList", customerServicelmpl.findAll());
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    private void addNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, email, address);
        CustomerServicelmpl customerServicelmpl = new CustomerServicelmpl();
        customerServicelmpl.save(customer);
        request.setAttribute("mes", "add new successful ");
        goCustomerList(request, response);

    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        CustomerServicelmpl customerServicelmpl = new CustomerServicelmpl();
        Customer customer = customerServicelmpl.findById(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("veiw.jsp").forward(request, response);
    }

    private void upDateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CustomerServicelmpl customerServicelmpl = new CustomerServicelmpl();
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, name, email, address);

        customerServicelmpl.update(id, customer);
        request.setAttribute("mes", "update successful");
        goCustomerList(request, response);

    }

    private void goUpDate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id", id);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
        ;
    }
}
