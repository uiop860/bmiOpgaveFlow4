<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         List of BMI Entries
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.

        This is a list of all BMI entries in the database

        <table>
            <thead><th>Id</th><th>BMI</th><th>Højde</th><th>Vægt</th></thead>
            <tr><td></td><td></td><td></td><td></td></tr>
        </table>

    </jsp:body>
</t:genericpage>
