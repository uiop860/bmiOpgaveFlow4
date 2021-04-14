<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Resultatside for beregning af BMI
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${true}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">

                <h2>BMI resultat</h2>

                <p> Din højde er ${requestScope.height} cm <br/>
                    Din vægt er ${requestScope.weight} kg
                </p>
                <p>
                    Dit BMI er beregnet til ${requestScope.bmi}
                </p>
                <p>
                    Du er ${requestScope.category}
                </p>
                <p>
                    Køn: ${requestScope.gender}
                </p>
                <p>
                    Sports_id: ${requestScope.sport_id}
                </p>
                <c:forEach var="hobbyItem" items="${requestScope.hobbies}">
                    hobby: ${hobbyItem}<br>
                </c:forEach>
            </div>
            <div class="col-sm-4"></div>
        </div>


    </jsp:body>
</t:genericpage>