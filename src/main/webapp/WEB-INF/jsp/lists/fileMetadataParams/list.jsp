<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="ui" tagdir="/WEB-INF/tags/" %>
<%@taglib prefix="auth" tagdir="/WEB-INF/tags/auth/" %>

<ui:listsTemplate pageTitle="pageTitle.fileMetadataDefinitionsList">
    <h1><fmt:message key="pageTitle.fileMetadataDefinitionsList"/></h1>

    <table class="dataTable">
        <thead>
        <tr>
            <th style="width: 50px;"><fmt:message key="dataTable.heading.id"/></th>
            <th style="width: 150px;"><fmt:message key="dataTable.heading.fileMetadataParameterName"/></th>
            <th><fmt:message key="dataTable.heading.fileMetadataParameterDataType"/></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${fileMetadataParamsList}" var="fileMetadataParam">
            <tr>
                <td><c:out value="${fileMetadataParam.fileMetadataParamDefId}" /></td>
                <td><c:out value="${fileMetadataParam.paramName}" /></td>
                <td><c:out value="${fileMetadataParam.paramDataType}" /></td>
                <td>
                    <a href="<c:url value='/lists/file-metadata-definitions/edit.html?id=${fileMetadataParam.fileMetadataParamDefId}' />"><fmt:message
                            key="link.edit"/></a>
                    <auth:experimenter>
                        <a href="<c:url value='/lists/file-metadata-definitions/delete.html?id=${fileMetadataParam.fileMetadataParamDefId}' />"
                           onclick="return confirm('Are you sure you want to delete item?');"><fmt:message
                                key="link.delete"/></a>
                    </auth:experimenter>
                </td>
            </tr>
        </c:forEach>
    </table>

    <auth:experimenter>
        <div class="actionBox">
            <a href="<c:url value='add.html'/>" class="lightButtonLink"><fmt:message
                    key="link.addFileMetadataDefinition"/></a>
        </div>
    </auth:experimenter>

</ui:listsTemplate>