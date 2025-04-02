/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import entities.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
/**
 *
 * @author Laura
 */
public class ClientesController {
    
    private static final DatabaseConnection DB = new DatabaseConnection();
    
    public int create(Clientes cliente) {
         String sql = "INSERT INTO clientes (fullname, email, phone) VALUES (?, ?, ?)";
         int rowsAffected = 0;
        try {
           Connection  conn = DB.connect();
           PreparedStatement stm = conn.prepareStatement(sql);
           
           stm.setString(1, cliente.getFullname());
           stm.setString(2, cliente.getEmail());
           stm.setString(3, cliente.getPhone());
           
           rowsAffected = stm.executeUpdate();
           if (rowsAffected > 0) System.out.println("Cliente almacenado exitosamente"); 
            
        } catch (Exception e) {
            System.out.println(" "+e.getMessage());
            e.printStackTrace();
        }
        return rowsAffected;
    }
}
