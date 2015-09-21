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

public class Order {
    
    private int idorders;
    private Date Date;
    private int OrderAmount;
    private int  OrderStatus_id;
    private String  OrderStatus_name;    
    private int Car_id;
    private String Car_make;
    
    public Order() {
    }

    public Order(int idorders, Date Date, int OrderAmount, int OrderStatus_id, String OrderStatus_name, int Car_id, String Car_make) {
        this.idorders = idorders;
        this.Date = Date;
        this.OrderAmount = OrderAmount;
        this.OrderStatus_id = OrderStatus_id;        
        this.OrderStatus_name = OrderStatus_name;
        this.Car_id = Car_id;
        this.Car_make = Car_make;
    }       

    public int getIdorders() {
        return idorders;
    }

    public Date getDate() {
        return Date;
    }

    public int getOrderAmount() {
        return OrderAmount;
    }

    public int getOrderStatus_id() {
        return OrderStatus_id;
    }

    public String getOrderStatus_name() {
        return OrderStatus_name;
    }

    public int getCar_id() {
        return Car_id;
    }

    public String getCar_make() {
        return Car_make;
    }

    public void setIdorders(int idorders) {
        this.idorders = idorders;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public void setOrderAmount(int OrderAmount) {
        this.OrderAmount = OrderAmount;
    }

    public void setOrderStatus_id(int OrderStatus_id) {
        this.OrderStatus_id = OrderStatus_id;
    }

    public void setOrderStatus_name(String OrderStatus_name) {
        this.OrderStatus_name = OrderStatus_name;
    }

    public void setCar_id(int Car_id) {
        this.Car_id = Car_id;
    }

    public void setCar_make(String Car_make) {
        this.Car_make = Car_make;
    }

        public static boolean updateOrderdb(int idorders, Date Date, int OrderAmount, int OrderStatus_id, String OrderStatus_name, int Car_id, String Car_make) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        //UPDATE `test`.`clients` SET `Address`='adress', `Phone`='555' WHERE `idclients`='1';
        
        String str = "UPDATE orders" +
       "    SET Date = '" + Date + "', "
                + "    OrderAmount = '" + OrderAmount + "', "
                + "    OrderStatus_id = '" + OrderStatus_id + "', "
                + "    Car_id = '" + Car_id + "' "                
                + "    WHERE idorders = '" + idorders + "';";
        
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
    
    public static boolean addOrderdb(Date Date, int OrderAmount, int OrderStatus_id, int Car_id) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        //INSERT INTO `test`.`clients` (`FirstName`, `LastName`) VALUES ('Alexandr', 'Alexandrov');

        
        String str = "INSERT INTO orders " +
        "(Date, OrderAmount, OrderStatus_id, Car_id)" +
        "VALUES ('" + Date  
                + "','" + OrderAmount 
                + "','" + OrderStatus_id               
                + "','" + Car_id + "')";
        
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
    
    public static boolean deleteOrderdb(int idorders) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        //DELETE FROM `test`.`clients` WHERE `idclients`='4';

        
        String str = "DELETE FROM orders WHERE idorders='" + idorders + "'";
        
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
