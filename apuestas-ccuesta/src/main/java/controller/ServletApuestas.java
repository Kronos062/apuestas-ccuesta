/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Apuestas.Apuestas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        String action = request.getParameter("action");
        //obtenemos la sesion acutal
        HttpSession session = request.getSession();
//empezamos  con la lista de apuestas
        List<Apuestas> apuestas = (List<Apuestas>) session.getAttribute("apuestas");
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
            response.sendRedirect(request.getContextPath() + "/listaApuestas.jsp");
        } else if ("delete".equals(action)) {
            //cogemos la apuesta a eliminar
            int index = Integer.parseInt(request.getParameter("index"));
            if (index >= 0 && index < apuestas.size()) {
                apuestas.remove(index);
            }
            response.sendRedirect(request.getContextPath() + "/listaApuestas.jsp");
        } else if ("modify".equals(action)) {
            //hacemos lo mismo para el modificar
            int index = Integer.parseInt(request.getParameter("index"));
            if (index >= 0 && index < apuestas.size()) {
                //cogemos los nuevos valores
                String nombre = request.getParameter("nombre");
                String equipos = request.getParameter("equipos");
                double dinero = Double.parseDouble(request.getParameter("dinero"));
                String fecha = request.getParameter("fecha");
                String resultado = request.getParameter("resultado");

                // modificamos la apuesta con esto
                Apuestas apuesta = apuestas.get(index);
                apuesta.setNombre(nombre);
                apuesta.setEquipos(equipos);
                apuesta.setDinero(dinero);
                apuesta.setFecha(fecha);
                apuesta.setResultado(resultado);
            }
            response.sendRedirect(request.getContextPath() + "/listaApuestas.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
