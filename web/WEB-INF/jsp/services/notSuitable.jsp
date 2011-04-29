<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/" %>
<ui:servicesTemplate pageTitle="pageTitle.services">

    <h1><fmt:message key="pageTitle.services"/></h1>
    <fmt:message key="error.notSuitable"/>
    <ul>
        <li><a href="<c:url value='/'/>" title="<fmt:message key='gotoHomepage'/>"><fmt:message key="gotoHomepage"/></a>
        </li>
    </ul>

</ui:servicesTemplate>