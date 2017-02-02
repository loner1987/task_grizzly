<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Result</title>
    <c:url value="/css/table.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
      <h1>RESULT</h1>
      <table class="gridtable">
          <th>Start Date</th><th>End Date</th><th>Perfomer</th><th>Activity</th>
      <c:forEach items="${List}" var="item">
         <tr>
             <td><fmt:formatDate type="date" value="${item.startDate}" /></td>
             <td><fmt:formatDate type="date" value="${item.endDate}" /></td>
             <td>${item.perfomer}</td>
             <td>${item.activity}</td>
         </tr>
      </c:forEach>
      </table>
</body>
</html>
