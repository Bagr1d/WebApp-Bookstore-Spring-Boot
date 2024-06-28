<div id="menu">
    <ul>
        <li><a href="index.jsp">Strona domowa</a></li>
        <li><a href="listaKsiazek.jsp">Wszystkie książki</a></li>
        <li class="podmenu">Kategorie
            <ul>
                <c:forEach var="kat" items="${lk}">
                    <li><a href="listaKsiazek?idkat=${kat.idk}">${kat.opis}</a></li>
                </c:forEach>
            </ul>
        </li>
        <li><a href="kontakt.jsp">Kontakt</a></li>
    </ul>
</div>
