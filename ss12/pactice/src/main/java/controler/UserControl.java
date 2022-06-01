package controler;

import model.User;
import service.ServiceUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserControl" , urlPatterns = "/userControl")
public class UserControl extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "creat" :
                try {
                    creatUser(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "update" :
                try {
                    update(request,response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "delete":
                delete(request,response);
                break;
            default:
                listUser(request, response);
        }
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "creat" :
                response.sendRedirect("creat.jsp");
                break;
            case "update":
                goUpdate(request,response);
                break;
            case "delete":
                delete(request,response);
                break;
            case "search":
                searchByCountry(request,response);
                break;
            case "sort":
                sortByName(request,response);
                break;
            default:
                listUser(request, response);
        }
    }




    ServiceUser serviceUser = new ServiceUser();

    private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> list = serviceUser.selectAllUsers();
        request.setAttribute("list", list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }
    private void creatUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name,email,country);
        serviceUser.insertUser(user);
        listUser(request,response);
    }
    private void goUpdate(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        request.getRequestDispatcher("update.jsp").forward(request,response);

    } private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id,name,email,country);
        serviceUser.updateUser(user);
        listUser(request,response);
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            serviceUser.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        listUser(request,response);
    }
    private void searchByCountry(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String country = request.getParameter("country");
       List<User> list= serviceUser.findCountry(country);
       if (list.size()==0){
           request.setAttribute("mes","khong tim thay");
       }else{
           request.setAttribute("list",list);
       }

       request.getRequestDispatcher("list.jsp").forward(request,response);
    }
    private void sortByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       List<User> list = serviceUser.sortUserByName();
       request.setAttribute("list",list);
       request.getRequestDispatcher("list.jsp").forward(request,response);
//        listUser(request,response);
    }
}
