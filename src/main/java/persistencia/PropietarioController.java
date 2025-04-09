/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;
import entities.Propietario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.UUID;
/**
 *
 * @author Laura
 */
public class PropietarioController {
    
    private static final DatabaseConnection DB = new DatabaseConnection();
    
    public int create(Propietario propietario) {
            String sql = "INSERT INTO propietario (nombre, apellido, tipo_documento, numero_documento, telefono, correo, contrasena, createdat, id_propietario) VALUES (?, ?, ?::tipo_documento, ?, ?, ?, ?, ?, ?)";
            int rowsAffected = 0;
            try {
                Connection conn = DB.connect();
                PreparedStatement stm = conn.prepareStatement(sql);

                UUID idPropietario = UUID.randomUUID();

                stm.setObject(9, idPropietario, java.sql.Types.OTHER);
                stm.setString(1, propietario.getNombre());
                stm.setString(2, propietario.getApellido());
                stm.setString(3, propietario.getTipoDocumento().name());
                stm.setString(4, propietario.getNumeroDocumento());
                stm.setString(5, propietario.getTelefono());
                stm.setString(6, propietario.getCorreo());
                stm.setString(7, propietario.getContrasena());
                stm.setDate(8, new Date(System.currentTimeMillis()));

              rowsAffected = stm.executeUpdate();
              if (rowsAffected > 0) System.out.println("Propietario almacenado exitosamente"); 

            } catch (Exception e) {
                System.out.println(" "+e.getMessage());
                e.printStackTrace();
            }
           return rowsAffected;
        }
}
