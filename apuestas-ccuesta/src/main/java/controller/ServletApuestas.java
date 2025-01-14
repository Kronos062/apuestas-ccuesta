/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Apuestas.Apuestas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ubuntu
 */
@WebServlet(name = "ServletApuestas", urlPatterns = {"/ServletApuestas"})
public class ServletApuestas extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //empezamos  con la lista de apuestas
        List<Apuestas> apuestas = (List<Apuestas>) session.getAttibute("apuestas");
        if (apuestas == null) {
            apuestas = new ArrayList<>();
            session.setAttribute("apuestas", apuestas);
        }
        
        if ("add".equals(action)) {
            //para los datos del forulario
            String nombre = request.getParameter("nombre");
            String equipos = request.getParameter("equipos");
            double dinero = Double.parseDouble(request.getParameter("dinero"));
            String fecha = request.getParameter("fecha");
            String resultado = request.getParameter("resultado");
            
            //creo la nueva instancia para la apuesta
            Apuestas apuesta = new Apuestas(nombre, equipos, dinero, fecha, resultado);
            
            //añadimos la nueva apuesta a la lista de apuestas
            apuestas.add(apuesta);
            
            //luego hago el redirigir para ir las apuestas
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
