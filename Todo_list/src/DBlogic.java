import java.sql.*;

public class DBlogic {
    private String DB = "jdbc:mysql://localhost:3306/todo";

    private String USER = "";

    private String PASS = "";

    //crud -create, read, update, delete

    //create = insert

    public void create(String task) throws SQLException {
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String insert = "INSERT INTO todo (task) VALUES ('"+ task +"')";

        stmt.executeUpdate(insert);
    }

    //delete = delete

    public void delete(String rowID) throws SQLException {
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String delete = "DELETE FROM todo WHERE id = '"+ rowID +"'";

        stmt.executeUpdate(delete);
    }

    //update = update

    public void update(String rowID, String rowValue) throws SQLException {
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String update = "UPDATE todo SET task = '"+ rowValue +"' WHERE id = '"+ rowID +"'";

        stmt.executeUpdate(update);
    }

    //update status
    public void updateStatus(String rowID) throws SQLException {
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String update = "UPDATE todo SET status = '"+"done"+"' WHERE id = '"+ rowID +"'";

        stmt.executeUpdate(update);
    }

    //read = select

    public void read() throws SQLException {
        Connection conn = DriverManager.getConnection(DB, USER, PASS);
        Statement stmt = conn.createStatement();

        String select = "SELECT * FROM todo ";
        ResultSet resultSet = stmt.executeQuery(select);

        while (resultSet.next()) {
            System.out.print(resultSet.getInt("id") + "." + " ");
            System.out.println(resultSet.getString("task") + " ");
            System.out.print("Status: " + resultSet.getString("status") + " | ");
            System.out.println("Created at: " + resultSet.getString("created"));
            System.out.println(" ");
        }
    }

}
