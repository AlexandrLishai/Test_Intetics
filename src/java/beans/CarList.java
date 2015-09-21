package beans;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CarList {

    private ArrayList<Car> carList = new ArrayList<Car>();

    private ArrayList<Car> getCars(String str) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        carList.clear();
        
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                Car car = new Car(rs.getInt("idcars"),rs.getString("Make"),
                        rs.getString("Model"),rs.getInt("Year"),rs.getString("VIN"),rs.getInt("client_id"));                
                carList.add(car);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CarList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //try {
                //if (stmt!=null) stmt.close();
                //if (rs!=null)rs.close();
                //if (conn!=null)conn.close();
            //} catch (SQLException ex) {
            //    Logger.getLogger(ClientList.class.getName()).log(Level.SEVERE, null, ex);
            // }
        }

        return carList;
    }

    public ArrayList<Car> getCarList() {
        String str = "select * from cars order by Make";
        return getCars(str);
        
    }
    
    public ArrayList<Car> getCarListSearch(String Make) {
        String str = "select * from cars where Make = '" + Make + "' order by Make";
        return getCars(str);
        
    }
    
    public ArrayList<Car> getClientListSearchById(int id) {
        String str = "select * from cars where client_id = '" + id + "' order by Make";
        return getCars(str);        
    }
    
    
}
