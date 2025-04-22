<%-- 
    Document   : formulario
    Created on : Jan 14, 2025, 12:01:01 PM
    Author     : ubuntu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Apuestas</title>
    </head>
    <body>
        <h1>Formulario Apuestas</h1>
        <form action="ServletApuestas" method="post">
            Nombre: <input type="text" name="nombre" placeholder="Nombre" required><br>
            Equipos: <input type="text" name="equipos" placeholder="Equipo 1 y Equipo 2" required><br>
            Resultado del partido: <input type="text" name="resultado" placeholder="Resultado partido" required><br> 
            Fecha del partido: <input type="date" name="fecha" placeholder="dd/mm/aa" required><br>   
            Dinero: <input type="number" name="dinero" required><br>
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Apostar">
        </form>
        <br>
        <hr>
        <!-- Enlace corregido para que pase por el Servlet y gestione la sesión -->
        <a href="ServletApuestas">Detalles de Apuestas</a>
        <hr>
    </body>
</html>