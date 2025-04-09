/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import entities.Propietario;
import persistencia.PropietarioController;

/**
 *
 * @author Laura
 */
public class PropietarioService {
    private static final PropietarioController prop = new PropietarioController();
    
    public int create(Propietario propietario) {
        return prop.create(propietario);
    }
}
