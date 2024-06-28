<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="menu.jsp" %>
<div id="zawartosc">
    <p>Liczba książek: ${tk.size()}</p>
    <h2>Lista książek</h2>
    <c:forEach var="el" items="${tk}">
        <p>${el.tytul}, ${el.wyd.nazwa}, ${el.rokWydania}</p>
    </c:forEach>
</div>
