<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="no">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/simple.css">
    <script src="${pageContext.request.contextPath}/js/validation.js" defer></script>

    <title>Påmelding</title>
</head>

<body>
<h2>Påmelding</h2>

<c:if test="${not empty valideringsfeil}">
    <ul style="color:red;">
        <c:forEach var="feil" items="${valideringsfeil}">
            <li>${feil.defaultMessage}</li>
        </c:forEach>
    </ul>
</c:if>


<form action="paamelding" method="post" > <!--onsubmit="return validateForm()">-->
    <label>Fornavn:</label>
    <input type="text" name="fornavn" required><br>

    <label>Etternavn:</label>
    <input type="text" name="etternavn" required><br>

    <label>Mobil (8 siffer):</label>
    <input type="text" name="mobil" pattern="\d{8}" required><br>

    <label>Passord:</label>
    <input type="password" name="passord" minlength="4" required><br>

    <label>Gjenta passord:</label>
    <input type="password" name="repeterPassord" minlength="4" required><br>

    <label>Kjønn:</label>
    <input type="radio" name="kjonn" value="mann" required> Mann
    <input type="radio" name="kjonn" value="kvinne"> Kvinne<br><br>
    

    <input type="submit" value="Meld meg på">
</form>

</body>
</html>
