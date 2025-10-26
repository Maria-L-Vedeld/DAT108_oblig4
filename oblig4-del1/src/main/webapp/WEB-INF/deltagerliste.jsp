<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="simple.css">
    <title>Deltagerliste</title>
</head>
<body>
<h2>Deltagerliste</h2>

<table border ="1" cellpadding="5">
    <tr>
        <th>Kjønn</th>
        <th>Navn</th>
        <th>Mobil</th>
    </tr>
    <c:forEach var="d" items="${deltagere}">
        <tr>
            <td align="center">
                <c:choose>
                    <c:when test="${d.kjonn eq 'mann'}">&#9794;</c:when>
                    <c:otherwise>&#9792;</c:otherwise>
                </c:choose>
            </td>
            <td>${d.fornavn} ${d.etternavn}</td>
            <td>${d.mobil}</td>
        </tr>
    </c:forEach>
</table>
</br>
<a href="${pageContent.request.contextPath}/"> Tilbake til påmelding</a>
</body>
</html>
