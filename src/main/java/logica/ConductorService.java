/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import entities.Conductor;
import persistencia.ConductorController;

/**
 *
 * @author Laura
 */
public class ConductorService {
    
    private static final ConductorController cli = new ConductorController();
    
    public int create(Conductor conductor) {
        return cli.create(conductor);
    }
}
