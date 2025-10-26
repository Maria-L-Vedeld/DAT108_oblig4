<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="simple.css">
    <title>Påmeldingsbekreftelse</title>
</head>
<body>
<h2>Påmeldingsbekreftelse</h2>
<p>Påmeldingen er mottatt for:</p>
<p>
    &nbsp;&nbsp;&nbsp;<strong>${deltager.fornavn}<br/>
    &nbsp;&nbsp;&nbsp;${deltager.etternavn}</strong><br/>
    &nbsp;&nbsp;&nbsp;${deltager.mobil}<br/>
    &nbsp;&nbsp;&nbsp;${deltager.kjonn}
</p>
<a href="deltagerliste">Gå til deltagerlisten</a></br>
<a href="${pageContent.request.contextPath}/"> Tilbake til påmelding</a>
</body>
</html>
