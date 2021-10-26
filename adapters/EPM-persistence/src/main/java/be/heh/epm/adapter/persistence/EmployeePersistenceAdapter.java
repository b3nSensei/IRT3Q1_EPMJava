package be.heh.epm.adapter.persistence;

import be.heh.epm.application.employee.Employee;
import be.heh.epm.application.port.out.EmployeePort;
import be.heh.epm.common.PersistenceAdapter;
import java.sql.*;
import java.util.ArrayList;

@PersistenceAdapter
public class EmployeePersistenceAdapter implements EmployeePort {

    //Preparation de la DB
    private String url = "jdbc:postgresql://127.0.0.1:5432/epm";
    private String user = "postgres";
    private String password = "root";
    private Connection connection = null;
    private Statement stmt;

    //Connection
    public EmployeePersistenceAdapter() {
        Connect();
    }
    private Connection Connect() {
        try {
            this.connection = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Connected to database successfully");
            stmt = this.connection.createStatement();
            String sql = "CREATE TABLE employees " +
                    "(idemp SERIAL PRIMARY KEY ," +
                    " name          TEXT    NOT NULL UNIQUE, " +
                    " address       CHAR(50), " +
                    " mail          VARCHAR)"; //Crée la table Employees avec les collones et parametres spécifié.
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Cannot connect to database\n" + e.getMessage());
        }
        return this.connection;
    }

    //Implemente la methode de l'interface qui insere un employee dans la DB
    public Employee save(Employee employee) {
        String sql = "INSERT INTO employees(name, address, mail) VALUES (?, ?, ?)";
        try (PreparedStatement ps = this.connection.prepareStatement(sql, new String[] { "idemp" })) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getAddress());
            ps.setString(3, employee.getMail());
            int id = ps.executeUpdate();
            if (id > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        employee.setEmpId(rs.getInt("idemp"));
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }

    //Implemente la methode de l'interface qui retourne tout les employee de la DB
    @Override
    public ArrayList<Employee> getAllEmployee() {
        Employee employee = null;
        ArrayList<Employee> listEmp = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if(!rs.next())
                return null;
            else do{
                listEmp.add(employee = new Employee(rs.getInt("idemp"), rs.getString("name"), rs.getString("address"), null));
            }while(rs.next());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listEmp;
    }

    //Implemente la methode de l'interface qui retourne un employee spécifique de la DB
    @Override
    public Employee getBy(int EmpID) {
        String sql = "SELECT * FROM employees WHERE idemp=?";
        Employee emp = new Employee();
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, EmpID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                emp.setEmpId(rs.getInt("idemp"));
                emp.setName(rs.getString("name"));
                emp.setAddress(rs.getString("address"));
            };
            if (emp.getName() == null){
                System.out.println("User not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return emp;
    }

    //Implemente la methode de l'interface qui supprime un employee dans la DB
    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE idemp=?";
        try (PreparedStatement ps = this.connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            //System.out.println("Employee deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
