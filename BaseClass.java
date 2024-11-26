package DbBase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass {
    public static Connection con;

    @BeforeMethod
    public Connection setup() throws SQLException
    {

        try {
            String url = "jdbc:mysql://localhost:3306/dbtesting";
            String user = "root";
            String password = "root";
            con= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
           System.out.println(e.getErrorCode());
            System.out.println(e.getSQLState());
            System.out.println(e.getMessage());
        }
        return con;
    }
@AfterMethod
    public void termDown() throws  SQLException{
        con.close();
}
}
