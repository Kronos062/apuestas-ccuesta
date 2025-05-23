<%-- 
    Document   : modificar
    Created on : Jan 14, 2025, 1:10:25 PM
    Author     : ubuntu
--%>

<%@page import="java.util.List"%>
<%@page import="Apuestas.Apuestas"%>
<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar Apuestas</h1>
        <%
            // Recupera la apuesta y el índice desde los atributos de request
            Apuestas apuesta = (Apuestas) request.getAttribute("apuestaEditar");
            Integer index = (Integer) request.getAttribute("indiceEditar");
            if (apuesta != null && index != null) {
        %>
        <form action="ServletApuestas" method="post">
            <input type="hidden" name="action" value="modify">
            <input type="hidden" name="index" value="<%= index%>">
            Nombre: <input type="text" name="nombre" value="<%= apuesta.getNombre()%>" required><br>
            Equipos: <input type="text" name="equipos" value="<%= apuesta.getEquipos()%>" required><br>
            Resultado: <input type="text" name="resultado" value="<%= apuesta.getResultado()%>" required><br>
            Fecha: <input type="date" name="fecha" value="<%= apuesta.getFecha()%>" required><br> 
            Dinero: <input type="numbre" name="dinero" value="<%= apuesta.getDinero()%>" required><br>
            <input type="submit" value="Modificar">
        </form>
        <%
            } else {
                out.println("<p>La apuesta no se puede modificar.</p>");
            }
        %>
    </body>
</html>
