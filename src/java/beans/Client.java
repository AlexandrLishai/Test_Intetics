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

public class Client {
    
    private String FirstName;
    private String LastName;
    private Date DateofBirth;
    private String Address;
    private String Phone;
    private String Email;
    private int idclients;
    
    public Client() {
    }

    public Client(int idclients, String FirstName, String LastName, Date DateofBirth, String Address, String Phone, String Email) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.DateofBirth = DateofBirth;
        this.Address = Address;
        this.Phone = Phone;
        this.Email = Email;
        this.idclients = idclients;
    }

    public void setIdclients(int idclients) {
        this.idclients = idclients;
    }

    public int getIdclients() {
        return idclients;
    }

    public String getLastName() {
        return LastName;
    }

    public Date getDateofBirth() {
        return DateofBirth;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setDateofBirth(Date DateofBirth) {
        this.DateofBirth = DateofBirth;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }   
    

    public Client(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    
    public static boolean updateClientdb(int idclients, String FirstName, String LastName, Date DateofBirth, String Address, String Phone, String Email) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        //UPDATE `test`.`clients` SET `Address`='adress', `Phone`='555' WHERE `idclients`='1';
        
        String str = "UPDATE clients" +
       "    SET FirstName = '" + FirstName + "', "
                + "    LastName = '" + LastName + "', "
                + "    DateofBirth = '" + DateofBirth + "', "
                + "    Address = '" + Address + "', "
                + "    Phone = '" + Phone + "', "
                + "    Email = '" + Email + "' "
                + "    WHERE idclients = '" + idclients + "';";
        
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
    
    public static boolean addClientdb(String FirstName, String LastName, Date DateofBirth, String Address, String Phone, String Email) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        //INSERT INTO `test`.`clients` (`FirstName`, `LastName`) VALUES ('Alexandr', 'Alexandrov');

        
        String str = "INSERT INTO clients " +
        "(FirstName, LastName, DateofBirth, Address, Phone, Email)" +
        "VALUES ('" + FirstName  
                + "','" + LastName 
                + "','" + DateofBirth 
                + "','" + Address 
                + "','" + Phone 
                + "','" + Email + "')";
        
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
    
    public static boolean deleteClientdb(int idclients) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        //DELETE FROM `test`.`clients` WHERE `idclients`='4';

        
        String str = "DELETE FROM clients WHERE idclients='" + idclients + "'";
        
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
