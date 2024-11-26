package DbBase;

import org.testng.annotations.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudOprations extends BaseClass{
    @Test
    public void DB_Test_InsertData() throws SQLException{
        con=this.setup();
        PreparedStatement ps=con.prepareStatement("insert into User values (?,?)");
        ps.setString(1,"101");
        ps.setString(2,"DHARSHAN");
        ps.executeUpdate();
        DB_Test_SelectQuery();
    }
    @Test
    public void DB_Test_SelectQuery() throws SQLException{
        con=this.setup();
        Statement stm=con.createStatement();
        ResultSet rs= stm.executeQuery("select * from User");
        while (rs.next()){
            int u_id=rs.getInt(1);
            String u_name=rs.getString(2);
            System.out.println(u_id+" "+u_name);

        }
    }
    @Test
    public  void DB_Test_UpdateData() throws SQLException{
        con=this.setup();
        PreparedStatement ps=con.prepareStatement("update User set u_name='DPL' where u_id=101");
        ps.executeUpdate();
        DB_Test_SelectQuery();
    }
    @Test
    public  void DeleteData() throws SQLException{
        con=this.setup();
        PreparedStatement ps=con.prepareStatement("delete from  User  where u_id=101");
        ps.executeUpdate();
        DB_Test_SelectQuery();
    }
}
