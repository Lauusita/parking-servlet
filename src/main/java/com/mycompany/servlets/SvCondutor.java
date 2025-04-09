/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.ConductorService;
import entities.Conductor;
import entities.Types;
/**
 *
 * @author Laura
 */
@WebServlet(name = "SvClientes", urlPatterns = {"/conductor"})
public class SvCondutor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                String nombre = request.getParameter("nombre");
                String apellido = request.getParameter("apellido");
                Types.tipo_documento tipoDocumento = Types.tipo_documento.valueOf(request.getParameter("tipo_documento"));
                String numeroDocumento = request.getParameter("numero_documento");
                String telefono = request.getParameter("telefono");
                String correo = request.getParameter("correo");
                String contrasena = request.getParameter("contrasena");
                
                Conductor con = new Conductor(nombre, apellido, tipoDocumento, numeroDocumento, telefono, correo, contrasena);
                int creation = new ConductorService().create(con);
                
                if ( creation == 0) response.setStatus(500);
                else response.setStatus(200);
                
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
