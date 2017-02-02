<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

        <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>

    <c:url value="/css/style.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />

        <script>

            <%--
            Set start and end input fields mask and also use calendar from outside.
            --%>

            $(document).ready(function() {
                $("#start_date").datepicker({ dateFormat: "M dd yy"});
            });

            $(document).ready(function() {
                $("#end_date").datepicker({ dateFormat: "M dd yy"});
            });

            <%--
            This function sets values depends on select of Time Period.
            --%>

            function setElement(selectObject){
                var form = this.form;
                var date = new Date();
                var monthNames = [
                    "Jan", "Feb", "Mar",
                    "Apr", "May", "Jun", "Jul",
                    "Aug", "Sep", "Oct",
                    "Nov", "Dec"
                ];

                if (document.getElementById("period").value == 1) {
                    document.getElementById("start_date").value = "";
                    document.getElementById("end_date").value = "";
                }


                if (document.getElementById("period").value == 2) {
                    var start = new Date(new Date().setMonth(date.getMonth() - date.getMonth()%3, 1));
                    var end = new Date(new Date().setMonth(
                            date.getMonth() + 3 - date.getMonth() % 3, 0));

                    document.getElementById("start_date").value = start.getDate() + " " + monthNames[start.getMonth()]
                            + " " + start.getFullYear();
                    document.getElementById("end_date").value = end.getDate() + " " + monthNames[end.getMonth()]
                            + " " + end.getFullYear();
                }

                if (document.getElementById("period").value == 3) {
                    var start = new Date();

                    start.setDate(1);
                    start.setMonth(start.getMonth()-1);
                    document.getElementById("start_date").value = start.getDate() + " " + monthNames[start.getMonth()]
                            + " " + start.getFullYear();
                    var end = new Date();
                    end.setDate(0);
                    document.getElementById("end_date").value = end.getDate() + " " + monthNames[end.getMonth()]
                            + " " + end.getFullYear();

                }

                if (document.getElementById("period").value == 4) {
                    var start = new Date();

                    start.setFullYear(start.getFullYear() - 1);
                    start.setMonth(0);
                    start.setDate(1);
                    document.getElementById("start_date").value = start.getDate() + " " + monthNames[start.getMonth()]
                            + " " + start.getFullYear();

                    var end = new Date();
                    end.setFullYear(end.getFullYear() - 1);
                    end.setMonth(11);
                    end.setDate(31);
                    document.getElementById("end_date").value = end.getDate() + " " + monthNames[end.getMonth()]
                            + " " + end.getFullYear();
                }

                if (document.getElementById("period").value == 5) {
                    var start = new Date();

                    start.setMonth(0);
                    start.setDate(1);
                    document.getElementById("start_date").value = start.getDate() + " " + monthNames[start.getMonth()]
                            + " " + start.getFullYear();
                    document.getElementById("end_date").value = date.getDate() + " " + monthNames[date.getMonth()]
                            + " " + date.getFullYear();
                }

                if (document.getElementById("period").value == 6) {
                    var start = new Date(new Date().setMonth(date.getMonth() - date.getMonth()%3, 1));
                    document.getElementById("start_date").value = start.getDate() + " " + monthNames[start.getMonth()]
                            + " " + start.getFullYear();
                    document.getElementById("end_date").value = date.getDate() + " " + monthNames[date.getMonth()]
                            + " " + date.getFullYear();
                }

                if (document.getElementById("period").value == 7) {
                    var start = new Date();
                    start.setDate(1);
                    document.getElementById("start_date").value = start.getDate() + " " + monthNames[start.getMonth()]
                            + " " + start.getFullYear();
                    document.getElementById("end_date").value = date.getDate() + " " + monthNames[date.getMonth()]
                            + " " + date.getFullYear();
                }

            };

        </script>
    <title>Start page</title>
</head>
<body>

    <form action="test" method="post">
        <label>Start Date:</label><input name="start_date" id="start_date"><br>
        <label>End Date:</label><input name="end_date" id="end_date"><br>
        <label>Perfomer:</label><select name="perf" id="perf">
                <option value="0">All Perfomers</option>
                <c:forEach items="${report}" var="perfomer">
                    <option value=${perfomer.perfomer}>${perfomer.perfomer}</option>
                </c:forEach>
                </select><br>
        <label>Time Period:</label><select size = 1 name="period" id="period" onchange="setElement(this)">
        <option value="1"></option>
        <option value="2">Last Qrt</option>
        <option value="3">Last Month</option>
        <option value="4">Last Calendar Year</option>
        <option value="5">Current Year to Date</option>
        <option value="6">Current Qrt to Date</option>
        <option value="7">Current Month to Date</option>
        </select><br>

        <input type="submit"><br>
    </form>



</body>
</html>
