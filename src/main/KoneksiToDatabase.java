package main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiToDatabase {
    private static Connection MySQLConfig;
    
    public Connection getKoneksi()throws SQLException{
        try{
            String url = "jdbc:mysql://localhost:3306/sepeda_store"; // kita masukan nama database setelah localhost
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            MySQLConfig = DriverManager.getConnection(url, user, pass);
        }catch(SQLException e){
            System.out.println("Koneksi dengan database gagal" + e.getMessage());
        }
        return MySQLConfig;
    }
}
