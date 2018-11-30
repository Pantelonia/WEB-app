<%@ page import="Bean.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        body {
            text-align: center;
        }
        table {
            margin: auto;
            border: 1px solid lime;
        }
        td {
            border: 1px solid lime;
            text-align: center;
        }
        tbody, thead {
            border: 1px solid lime;
        }
    </style>
</head>
<body>
    <%
        HitsHandler handler = (HitsHandler) session.getAttribute("previousHits");
        Hit hit = handler.getPreviousHits().getFirst();
    %>

    <table>
        <thead>
            <td>X</td>
            <td>Y</td>
            <td>R</td>
            <td>Is in area</td>
            <td>Now</td>
        </thead>
        <tbody>
            <td><%=hit.getX()%></td>
            <td><%=hit.getY()%></td>
            <td><%=hit.getR()%></td>
            <td><%=hit.isInArea() ? "Да" : "Нет"%></td>
            <td><%=hit.getHitTime()%></td>
        </tbody>
    </table>

    <a href="index.jsp">Try again!</a>
</body>
</html>