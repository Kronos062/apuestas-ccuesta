<%-- 
    Document   : listaApuestas
    Created on : Jan 14, 2025, 1:02:40 PM
    Author     : ubuntu
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.List"%>
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
        <!--creo el filtro por nombre-->
        <form action="listaApuestas.jsp" method="get">
            <input type="text" name="filtroNombre" placeholder="Filtrar por nombre">
            <input type="submit" value="Filtrar">
        </form>
        <%
            //cogemos la sesión y la lista de apuestas de ella
            List<Apuestas> apuestas = (List<Apuestas>) session.getAttribute("apuestas");
            String filtroNombre = request.getParameter("filtroNombre");

            if (apuestas != null && !apuestas.isEmpty()) {
                // Aplicamos el filtro si existe
                //if (filtroNombre != null && !filtroNombre.isEmpty()) {
                //    apuestas = apuestas.stream()
                //            .filter(a -> a.getNombre().toLowerCase().contains(filtroNombre.toLowerCase()))
                //            .collect(Collectors.toList());
                //}
                if (filtroNombre != null && !filtroNombre.isEmpty()) {
                    List<Apuestas> apuestasFiltradas = new ArrayList<>();
                    String filtroLower = filtroNombre.toLowerCase();
                    for (int i = 0; i < apuestas.size(); i++) {
                        if (apuestas.get(i).getNombre().toLowerCase().contains(filtroLower)) {
                            apuestasFiltradas.add(apuestas.get(i));
                        }
                    }
                    apuestas = apuestasFiltradas;
                }

                if (apuestas.isEmpty()) {
                    out.println("<p>No se encontraron apuestas con el nombre especificado.</p>");
                } else {
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
        <!-- Te llevara al form de modificar-->
        <form action="modificar.jsp" method="get" style="display:inline;">
            <input type="hidden" name="index" value="<%= i%>">
            <input type="submit" value="Modificar">
        </form>
        <hr>
        <%
                    }
                }
            }
            if (filtroNombre != null && !filtroNombre.isEmpty()) {
                out.println("<p>No se encontraron apuestas con el nombre especificado.</p>");
            } else {
                out.println("<p>No hay apuestas anteriores.</p>");
            }
        %>
        <form action="formulario.jsp" method="get">
            <input type="submit" value="Apuesta mas, pobre">
        </form>
</html>
