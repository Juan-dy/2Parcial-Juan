<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Estudiante"%>
<%@page import="com.emergentes.modelo.Estudiante"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    Estudiante estudiante = (Estudiante) request.getAttribute("estudiante");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        
        <h1>Registro</h1>

        
        <form action="" method="post">


            <input type="hidden" name="id" value="${estudiante.id}">
            <label>
                Nombres: <input type="text" name="nombres" value="${estudiante.nombres}">
            </label>
            <br>
            <label>
                Apellidos: <input type="text" name="apellidos" value="${estudiante.apellidos}">
            </label>
            <br>
            <label>
                Seminario: <input type="text" name="seminario" value="${estudiante.seminario}">
            </label>
            <br>
            <label> Confirmado:

                <c:if test="${estudiante.confirmado == 1}">
                    <input type="checkbox" name="confirmado" value="1" checked>
                </c:if>

                <c:if test="${estudiante.confirmado == 0}">
                    <input type="checkbox" name="confirmado" value="1">                
                </c:if>
            </label>
            <br>
            <label>
                <input type="date" name="fecha_ins" value="${estudiante.fecha_ins}">
            </label>
            <br>
            <input type="submit">
        </form>
    </body>
</html>
