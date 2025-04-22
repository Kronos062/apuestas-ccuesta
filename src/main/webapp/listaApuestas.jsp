<%-- 
    Document   : listaApuestas
    Created on : Jan 14, 2025, 1:02:40 PM
    Author     : ubuntu
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Apuestas.Apuestas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de apuestas</h1>
        <!--creo el filtro por nombre que redirije a ServletApuestas (despues el te redirigira a listaApuestas.jsp)-->
        <form action="ServletApuestas" method="get">
            <input type="hidden" name="action" value="filter">
            <input type="text" name="filtroNombre" placeholder="Filtrar por nombre">
            <input type="submit" value="Filtrar">
        </form>
        <%
            // Recupera la lista filtrada si existe, si no la lista completa
            List<Apuestas> apuestas = (List<Apuestas>) session.getAttribute("apuestasFiltradas");
            if (apuestas == null) {
                apuestas = (List<Apuestas>) session.getAttribute("apuestas");
            }
            // Recupera el filtro
            String filtroNombre = request.getParameter("filtroNombre");
            
            if (apuestas != null && !apuestas.isEmpty()) {
                for (int i = 0; i < apuestas.size(); i++) {
                    Apuestas apuesta = apuestas.get(i);
        %>
        <!-- La listamos con esto-->
        <p>Nombre: <%= apuesta.getNombre()%></p>
        <p>Equipos: <%= apuesta.getEquipos()%></p>
        <p>Resultado: <%= apuesta.getResultado()%></p> 
        <p>Fecha: <%= apuesta.getFecha()%></p>
        <p>Dinero Apostado: $<%= apuesta.getDinero()%></p>
        <!-- Te llevara al form de eliminar-->
        <form action="ServletApuestas" method="post" style="display:inline;">
            <input type="hidden" name="action" value="delete">
            <input type="hidden" name="index" value="<%= i%>">
            <input type="submit" value="Eliminar">
        </form>
        <!-- Te llevara a ServletApuestas.java (te redirigira al modificar.jsp)-->
        <form action="ServletApuestas" method="get" style="display:inline;">
            <input type="hidden" name="action" value="prepareUpdate">
            <input type="hidden" name="index" value="<%= i%>">
            <input type="submit" value="Modificar">
        </form>
        <hr>
        <%
                }
            } else {
                // Mensaje si no hay apuestas
                if (filtroNombre != null && !filtroNombre.isEmpty()) {
                    out.println("<p>No se encontraron apuestas con el nombre especificado.</p>");
                } else {
                    out.println("<p>APUESTA MAS PERRO.</p>");
                }
            }
        %>
        <!-- Te llevara a ServletApuestas.java (te redirigira al formulario.jsp)-->
        <form action="ServletApuestas" method="get">
            <input type="hidden" name="action" value="nuevaApuesta">
            <input type="submit" value="Apuesta mas, pobre">
        </form>
    </body>
</html>