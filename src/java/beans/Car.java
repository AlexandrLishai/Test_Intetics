package beans;

import db.Database;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Car {
    
    private String Make;
    private String Model;
    private int Year;
    private String VIN;    
    private int idcars;
    private int client_id;
    
    public Car() {
    }

    public Car(int idcars, String Make, String Model, int Year, String VIN, int client_id) {
        this.Make = Make;
        this.Model = Model;
        this.Year = Year;
        this.VIN = VIN;        
        this.idcars = idcars;
        this.client_id = client_id;
    }       

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public String getMake() {
        return Make;
    }

    public String getModel() {
        return Model;
    }

    public int getYear() {
        return Year;
    }

    public String getVIN() {
        return VIN;
    }

    public int getIdcars() {
        return idcars;
    }

    public void setMake(String Make) {
        this.Make = Make;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public void setYear(int Year) {
        this.Year = Year;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public void setIdcars(int idcars) {
        this.idcars = idcars;
    }
  
    
    public static boolean updateCardb(int idcars, String Make, String Model, int Year, String VIN) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        //UPDATE `test`.`clients` SET `Address`='adress', `Phone`='555' WHERE `idclients`='1';
        
        String str = "UPDATE cars" +
       "    SET Make = '" + Make + "', "
                + "    Model = '" + Model + "', "
                + "    Year = '" + Year + "', "
                + "    VIN = '" + VIN + "' "                
                + "    WHERE idcars = '" + idcars + "';";
        
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            stmt.executeUpdate(str); 
            
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ClientList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //try {
                //if (stmt!=null) stmt.close();
                //if (rs!=null)rs.close();
                //if (conn!=null)conn.close();
            //} catch (SQLException ex) {
            //    Logger.getLogger(ClientList.class.getName()).log(Level.SEVERE, null, ex);
            // }
        }

        return false;
    }
    
    public static boolean addCardb(String Make, String Model, int Year, String VIN, int client_id) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        //INSERT INTO `test`.`clients` (`FirstName`, `LastName`) VALUES ('Alexandr', 'Alexandrov');

        
        String str = "INSERT INTO cars " +
        "(Make, Model, Year, VIN, client_id)" +
        "VALUES ('" + Make  
                + "','" + Model 
                + "','" + Year
                + "','" + VIN
                + "','" + client_id + "')";
        
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            stmt.executeUpdate(str); 
            
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ClientList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //try {
                //if (stmt!=null) stmt.close();
                //if (rs!=null)rs.close();
                //if (conn!=null)conn.close();
            //} catch (SQLException ex) {
            //    Logger.getLogger(ClientList.class.getName()).log(Level.SEVERE, null, ex);
            // }
        }

        return false;
    }
    
    public static boolean deleteCardb(int idcars) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        //DELETE FROM `test`.`clients` WHERE `idclients`='4';

        
        String str = "DELETE FROM cars WHERE idcars='" + idcars + "'";
        
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            stmt.executeUpdate(str); 
            
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(ClientList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //try {
                //if (stmt!=null) stmt.close();
                //if (rs!=null)rs.close();
                //if (conn!=null)conn.close();
            //} catch (SQLException ex) {
            //    Logger.getLogger(ClientList.class.getName()).log(Level.SEVERE, null, ex);
            // }
        }

        return false;
    }

    

}
