<%-- 
    Document   : listaApuestas
    Created on : Jan 14, 2025, 1:02:40 PM
    Author     : ubuntu
--%>

<%@page import="java.util.List"%>
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
        <h1>Apuestas Anteriores</h1>

        <%
            //cogemos la sesión y la lista de apuestas de ella
            List<Apuestas> apuestas = (List<Apuestas>) session.getAttribute("apuestas");
            if (apuestas != null && !apuestas.isEmpty()) {
                for (int i = 0; i < apuestas.size(); i++) {
                    Apuestas apuesta = apuestas.get(i);
        %>
        <!-- La listamos con esto-->
        <p>Nombre: <%= apuesta.getNombre()%></p>
        <p>equipos: <%= apuesta.getEquipos()%></p>
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
            <!-- Te llevara al form de modificar-->
        <form action="modificar.jsp" method="get" style="display:inline;">
            <input type="hidden" name="index" value="<%= i%>">
            <input type="submit" value="Modificar">
        </form>
        <hr>
        <%
            }
        } else {
        %>
        <p>No hay apuestas anteriores.</p>
        <%
            }
        %>
        <form action="formulario.jsp" method="get">
            <input type="submit" value="Apuesta mas, pobre">
        </form>
</html>
