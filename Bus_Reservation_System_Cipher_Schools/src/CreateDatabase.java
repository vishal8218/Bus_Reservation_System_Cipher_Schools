/*import java.sql.*;

public class CreateDatabase {
    public  void Create_Database(Passenger p)throws SQLException,ClassNotFoundException
    {
          try
          {
              Class.forName("com.mysql.cj.jdbc.Driver");
              Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "root");
              Statement stmt = con.createStatement();
            //   1.Create BusDetails table
              //   2.PassengerDetails table
            String query="CREATE TABLE PassengerDetails (name VARCHAR(20),Mobile_Number BIGINT(10) PRIMARY KEY,Email VARCHAR(20),Password VARCHAR(20),Street VARCHAR(20),State VARCHAR(20))";
            stmt.executeUpdate(query);
             String q="INSERT INTO PassengerDetails VALUES(?,?,?,?,?,?)";
              PreparedStatement ps = con.prepareStatement(q);
              ps.setString(1,p.getName1());
              ps.setLong(2,p.getMoblie_number());
              ps.setString(3, p.getEmail());
              ps.setString(4,p.getPassword());
              ps.setString(5,p.getStreet());
              ps.setString(6,p.getState());
         ps.executeUpdate();
         ps.close();
          /*   for(int i=0;i<3;i++) {
                  ps.setInt(1, bus[i].getBus_Number());
                  ps.setString(2, bus[i].getName());
                  ps.setString(3,bus[i].getSource());
                  ps.setString(4,bus[i].getDes());
                  ps.setString(5,bus[i].getDate());
                  ps.executeUpdate();
              }

stmt.close();
              con.close();
          }
          catch(Exception e)
          {
              System.out.println(e);
          }
    }
}*/
