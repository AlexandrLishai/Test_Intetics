package beans;

import db.Database;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClientList {

    private ArrayList<Client> clientList = new ArrayList<Client>();

    private ArrayList<Client> getClients(String str) {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        
        clientList.clear();
        
        try {
            conn = Database.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery(str);
            while (rs.next()) {
                Client client = new Client(rs.getInt("idclients"),rs.getString("FirstName"),rs.getString("LastName"),rs.getDate("DateofBirth"),rs.getString("Address"),
                rs.getString("Phone"),
                rs.getString("Email"));                
                clientList.add(client);
            }

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

        return clientList;
    }

    public ArrayList<Client> getClientList() {
        String str = "select * from clients order by FirstName";
        return getClients(str);
        
    }
    
    public ArrayList<Client> getClientListSearch(String FirstName, String LastName) {
        String str = "select * from clients where FirstName = '" + FirstName + "' and LastName = '" + LastName + "' order by FirstName";
        return getClients(str);
        
    }
    
    public ArrayList<Client> getClientListSearchById(int id) {
        String str = "select * from clients where idclients = " + id + " order by FirstName";
        return getClients(str);        
    }
    
    
}
