<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="menu.jsp" %>
<div id="zawartosc">
    <h2>Kontakt</h2>
    <p>Adres: Moja Firma, Ulica 1, 81-000 Gdynia</p>
    <h3>Wydawnictwa</h3>
    <c:forEach var="wyd" items="${lw}">
        <p>${wyd.nazwa}, ${wyd.miasto}, ${wyd.panstwo}</p>
    </c:forEach>
</div>
