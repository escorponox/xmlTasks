<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:set var="baseURL" value="${fn:replace(req.requestURL, fn:substring(req.requestURI, 0, fn:length(req.requestURI)), req.contextPath)}"/>
<html>
<head>
    <title>JSTL</title>
</head>
<body>
<c:set var="xmltext">
    <agenda xmlns="http://myNameSpace.com"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://myNameSpace.com agenda.xsd">
        <contactos>
            <contacto alias="pavo1">
                <nombre>pavo1nombre</nombre>
                <telefono>999-999-999</telefono>
                <email>aaa@gmail.com</email>
            </contacto>
            <contacto alias="pavo2">
                <nombre>pavo2nombre</nombre>
                <apellidos>pavo2apellidos</apellidos>
                <telefono>999-999-999</telefono>
            </contacto>
            <contacto alias="amigo1">
                <nombre>amigo1</nombre>
                <apellidos>amigo1apellidos</apellidos>
                <telefono>999-999-999</telefono>
            </contacto>
            <contacto alias="amigo2">
                <nombre>amigo2</nombre>
                <apellidos>amigo2apellidos</apellidos>
                <telefono>999-999-999</telefono>
            </contacto>
        </contactos>
        <citas>
            <cita>
                <titulo>titulo1</titulo>
                <lugar>girona</lugar>
                <fecha>2015-02-19</fecha>
                <hora>19:15:00</hora>
            </cita>
            <cita>
                <titulo>titulo2</titulo>
                <lugar>girona2</lugar>
                <fecha>2015-02-21</fecha>
                <hora>19:10:00</hora>
            </cita>
        </citas>
    </agenda>
</c:set>

<c:import url="${baseURL}/xml/agenda.xsl" var="xslt"/>
<x:transform xml="${xmltext}" xslt="${xslt}"/>
</body>
</html>
