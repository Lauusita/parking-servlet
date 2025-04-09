/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import entities.Conductor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.util.UUID;
/**
 *
 * @author Laura
 */
public class ConductorController {
    
    private static final DatabaseConnection DB = new DatabaseConnection();
    
        public int create(Conductor conductor) {
            String sql = "INSERT INTO conductor (nombre, apellido, tipo_documento, numero_documento, telefono, correo, contrasena, createdat, id_conductor) VALUES (?, ?, ?::tipo_documento, ?, ?, ?, ?, ?, ?)";
            int rowsAffected = 0;
            try {
              Connection  conn = DB.connect();
              PreparedStatement stm = conn.prepareStatement(sql);
              
              UUID idConductor = UUID.randomUUID();

              stm.setObject(9, idConductor, java.sql.Types.OTHER);
              stm.setString(1, conductor.getNombre());
              stm.setString(2, conductor.getApellido());
              stm.setString(3, conductor.getTipoDocumento().name());
              stm.setString(4, conductor.getNumeroDocumento());
              stm.setString(5, conductor.getTelefono());
              stm.setString(6, conductor.getCorreo());
              stm.setString(7, conductor.getContrasena());
              stm.setDate(8, new Date(System.currentTimeMillis()));

              rowsAffected = stm.executeUpdate();
              if (rowsAffected > 0) System.out.println("Conductor almacenado exitosamente"); 

            } catch (Exception e) {
                System.out.println(" "+e.getMessage());
                e.printStackTrace();
            }
           return rowsAffected;
        }
}   
