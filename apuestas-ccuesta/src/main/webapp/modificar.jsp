<%-- 
    Document   : modificar
    Created on : Jan 14, 2025, 1:10:25 PM
    Author     : ubuntu
--%>

<%@page import="java.util.List"%>
<%@page import="Apuestas.Apuestas"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar Apuestas</h1>
        <%
            //es lo mismo de antes para tener la lista de la sesión
            List<Apuestas> apuestas = (List<Apuestas>) session.getAttribute("apuestas");
            //tengo que obtener la apuesta por indice:
            int index = Integer.parseInt(request.getParameter("index"));
            Apuestas apuesta = apuestas.get(index);
            //valida la apuesta por si no es valida
            if (apuesta != null) {
        %>
        <form action="ServletApuestas" method="post">
            <input type="hidden" name="action" value="modify">
            <input type="hidden" name="index" value="<%= index%>">
            Nombre: <input type="text" name="nombre" value="<%= apuesta.getNombre()%>" required><br>
            Equipos: <input type="text" name="equipos" value="<%= apuesta.getEquipos()%>" required><br>
            Resultado: <input type="text" name="resultado" value="<%= apuesta.getResultado()%>" required><br>
            Fecha: <input type="date" name="fecha" value="<%= apuesta.getFecha()%>" required><br> 
            Dinero: <input type="number" name="cantidad" value="<%= apuesta.getDinero()%>" required><br>
            <input type="submit" value="Modificar">
        </form>
        <%
            } else {
                out.println("<p>La apuesta no se puede modificar.</p>");
            }
        %>
    </body>
</html>
