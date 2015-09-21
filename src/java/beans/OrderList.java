package beans;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OrderList {

    private ArrayList<Order> orderList = new ArrayList<Order>();

    private ArrayList<Order> getOrders(String str) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        orderList.clear();
        
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                Order order = new Order(rs.getInt("idorders"), rs.getDate("Date"),
                        rs.getInt("OrderAmount"),rs.getInt("OrderStatus_id"),rs.getString("statusName"),rs.getInt("car_id"), rs.getString("Make"));                
                orderList.add(order);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OrderList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //try {
                //if (stmt!=null) stmt.close();
                //if (rs!=null)rs.close();
                //if (conn!=null)conn.close();
            //} catch (SQLException ex) {
            //    Logger.getLogger(ClientList.class.getName()).log(Level.SEVERE, null, ex);
           // }
        }

        return orderList;
    }

    public ArrayList<Order> getOrderList() {
        String str = "select orders.idorders, orders.Date, orders.OrderAmount, orders.OrderStatus_id, ostatus.Name as statusName, orders.car_id, c.Make from orders  \n" +
                "inner join orderstatus as ostatus on orders.orderstatus_id = ostatus.idorderstatus \n" +
                "inner join cars as c on orders.car_id = c.idcars;";
        return getOrders(str);
        
    }
    
    public ArrayList<Order> getOrderListSearch(Date date) {
        String str = "select * from orders where Date = '" + date + "' order by Date";
        return getOrders(str);
        
    }
    
    public ArrayList<Order> getOrderListSearchByCarId(int id) {
        String str = "select orders.idorders, orders.Date, orders.OrderAmount, orders.OrderStatus_id, ostatus.Name as statusName, orders.car_id, c.Make from orders  \n" +
                "inner join orderstatus as ostatus on orders.orderstatus_id = ostatus.idorderstatus \n" +
                "inner join cars as c on orders.car_id = c.idcars \n" +
                "where orders.car_id = '" + id + "';";        
        return getOrders(str);        
    }
    
    
}
