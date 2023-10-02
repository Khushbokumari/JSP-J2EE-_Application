package khushi;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class curd
 */
@WebServlet("/user")
public class curd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public curd() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null && action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            deleteRegistration(id);
        }

        List<Registration> registrations = getRegistrations();
        request.setAttribute("registrations", registrations);
        request.getRequestDispatcher("registrations.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        
        if (action != null && action.equals("create")) {
            String name = request.getParameter("firstname");
            String city = request.getParameter("city");
            String email = request.getParameter("email");
            String mobile = request.getParameter("mobile");

            insertRegistration(name, city, email, mobile);
        }

        response.sendRedirect("user");
    }

    private void insertRegistration(String name, String city, String email, String mobile) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg2", "root", "1234");
            PreparedStatement stmnt = con
                    .prepareStatement("INSERT INTO registration (name, city, email, mobile) VALUES (?, ?, ?, ?)");
            stmnt.setString(1, name);
            stmnt.setString(2, city);
            stmnt.setString(3, email);
            stmnt.setString(4, mobile);
            stmnt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Registration> getRegistrations() {
        List<Registration> registrations = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg2", "root", "1234");
            java.sql.Statement stmnt = con.createStatement();
            ResultSet resultSet = stmnt.executeQuery("SELECT * FROM registration");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String city = resultSet.getString("city");
                String email = resultSet.getString("email");
                String mobile = resultSet.getString("mobile");
                Registration registration = new Registration(id, name, city, email, mobile);
                registrations.add(registration);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registrations;
    }

    private void deleteRegistration(int id) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/reg2", "root", "1234");
            PreparedStatement stmnt = con.prepareStatement("DELETE FROM registration WHERE id = ?");
            stmnt.setInt(1, id);
            stmnt.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
