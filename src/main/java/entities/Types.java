/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Laura
 */
public class Types {
    
    public enum tipo_documento {
        CC,
        PASAPORTE
    };
    
    public enum tipo_vehiculos_aceptados {
        CARRO,
        MOTO,
        BUS,
        BICICLETA,
        CAMION
    }
    
    public enum estado_reserva {
        RESERVADA, 
        CANCELADA,
        COMPLETADA
    }
    
    public enum estado_historial {
        COMPLETADA,
        CANCELADA
    }
}
