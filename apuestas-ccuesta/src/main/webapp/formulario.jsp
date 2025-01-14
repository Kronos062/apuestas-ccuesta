<%-- 
    Document   : formulario
    Created on : Jan 14, 2025, 12:01:01 PM
    Author     : ubuntu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apuestas</title>
    </head>
    <body>
        <h1>Formulario Apuestas</h1>
        <form action="ServletApuestas" method="post">
            Nombre: <input type="text" name="nombre" placeholder="Nombre" required><br>
            Equipos: <input type="text" name="equipos" placeholder="Equipo 1 vs Equipo 2" required><br>
            Resultado del partido: <input type="text" name="resultado" placeholder="Resultado del partido" required><br> 
            Fecha del partido: <input type="date" name="fecha" placeholder="dd/mm/aa" required><br>   
            Dinero a Apostar: <input type="number" name="cantidad" required><br>
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Apostar">
        </form>
        <br>
        <hr>
        <a href="listaApuestas.jsp">Detalles de Apuestas</a>
        <hr>
    </body>
</html>
