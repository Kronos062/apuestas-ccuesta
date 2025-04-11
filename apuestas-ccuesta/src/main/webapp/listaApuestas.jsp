<%-- 
    Document   : listaApuestas
    Created on : Jan 14, 2025, 1:02:40 PM
    Author     : ubuntu
--%>

<%@page import="java.util.List"%>
<%@page import="Apuestas.Apuestas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Listado de Apuestas</title>
    </head>
    <body>
        <h1>Listado de apuestas</h1>
        
        <!-- Filtro: toda la lógica se maneja en el Servlet (action="ServletApuestas") -->
        <form action="ServletApuestas" method="get">
            <input type="hidden" name="action" value="filter">
            <input type="text" name="filtroNombre" placeholder="Filtrar por nombre">
            <input type="submit" value="Filtrar">
        </form>

        <%
            List<Apuestas> apuestasMostrar = (List<Apuestas>) session.getAttribute("apuestasFiltradas");
            if(apuestasMostrar == null) {
                apuestasMostrar = (List<Apuestas>) session.getAttribute("apuestas");
            }

            if (apuestasMostrar != null && !apuestasMostrar.isEmpty()) {
                for (int i = 0; i < apuestasMostrar.size(); i++) {
                    Apuestas apuesta = apuestasMostrar.get(i);
        %>
        <p>Nombre: <%= apuesta.getNombre()%></p>
        <p>Equipos: <%= apuesta.getEquipos()%></p>
        <p>Resultado: <%= apuesta.getResultado()%></p> 
        <p>Fecha: <%= apuesta.getFecha()%></p>
        <p>Dinero Apostado: $<%= apuesta.getDinero()%></p>

        <form action="ServletApuestas" method="post" style="display:inline;">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="index" value="<%= i%>">
            <input type="submit" value="Eliminar">
        </form>

        <form action="ServletApuestas" method="get" style="display:inline;">
            <input type="hidden" name="action" value="prepareUpdate">
            <input type="hidden" name="index" value="<%= i%>">
            <input type="submit" value="Modificar">
        </form>
        <hr>
        <%
                }
            } else {
        %>
        <p>No hay apuestas para mostrar</p>
        <%
            }
        %>
        <form action="ServletApuestas" method="get">
            <input type="hidden" name="action" value="nuevaApuesta">
            <input type="submit" value="Apuesta mas, pobre">
        </form>
    </body>
</html>
