<%@ page import="Bean.*" %>
<%@ page import="java.util.Deque" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <head>
    <meta charset="utf-8">
    <title>Pip_lab2</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="script.js"></script>
  </head>
 <center>
 
  	<div class="container header">

		<span class="left">Вариант:1806</span>
		<span class="center">Сыроватский П.В.</span>
		<span class="right">Группа:P3218</span>
		
	</div>

  <body>
      <canvas id="canv" width= "300" height ="300">Ooops something is going wrong :(</canvas>
      <div class="container form">
      <form  id="XYR_input" action="ControllerServlet" method="Post">
        <table>
          <tr>
            <td>
              <div >X:</div>
           <select name="selectX" id = "x_value">
           		<option name="X" value = "-4" > -4</option>
           		<option name="X" value = "-3" > -3</option>
           		<option name="X" value = "-2" > -2</option>
           		<option name="X" value = "-1" > -1</option>
           		<option name="X"  value = "0" > 0</option>
           		<option name="X" value = "1" > 1</option>
           		<option name="X" value = "2" > 2</option>
           		<option name="X" value = "3" > 3</option>
           		<option name="X" value = "4" > 4</option>         		
           		
           </select>
            </td>
          </tr>
          <tr>
            <td>
              <div>Y:</div>
              <input type="text" maxlength="8" id="y_value" style="text-align: center;" name="Y">
            </td>
          </tr>
          <tr>
            <td>
              <div>R:</div>
               <div style="width: 300px;">
                <div style="width: 100%">
                  
                  
                  <div class="buttonAndValue" style="text-align: center;">1</div>
                  <div class="buttonAndValue" style="text-align: center;">2</div>
                  <div class="buttonAndValue" style="text-align: center;">3</div>
                  <div class="buttonAndValue" style="text-align: center;">4</div>
                  <div class="buttonAndValue" style="text-align: center;">5</div>
                </div>

                <div>
                  <div class="buttonAndValue" style="text-align: center;">
                    <input type="radio" name="R" value="1">
                  </div>
                  <div class="buttonAndValue" style="text-align: center;">
                    <input type="radio" name="R" value="2">
                  </div>
                  <div class="buttonAndValue" style="text-align: center;">
                    <input type="radio" name="R" value="3">
                  </div>
                  <div class="buttonAndValue" style="text-align: center;">
                    <input type="radio" name="R" value="4">
                  </div>
                  <div class="buttonAndValue" style="text-align: center;">
                    <input type="radio" name="R" value="5">
                  </div>                  
                </div>
              </div>
            </td>
          </tr>
        </table>
        <input type="submit" id="submitButton">
        <input type="hidden" name="hidden_field_R" value="">
        <input type="hidden" name="hidden_field_X" value="">
      </form>
      </div>
      <div id="previousHits">
        <table id="t1" class="container">
        <caption>Logs</caption>

          <thead>
             <td><b>X</b></td>
             <td><b>Y</b></td>
             <td><b>R</b></td>
             <td><b>Is in area</b></td>
             <td><b>Now</b></td>
          </thead>

          <tbody>
            <%
              if (session.getAttribute("previousHits") != null) {
                HitsHandler handler = (HitsHandler) session.getAttribute("previousHits");
                Deque<Hit> previousHits = handler.getPreviousHits();
                while(previousHits.peek() != null){
                Hit currentHit = previousHits.pop();
              %>
            <tr>
              <td class="previousX"><%=currentHit.getX()%></td>
              <td class="previousY"><%=currentHit.getY()%></td>
              <td><%=currentHit.getR()%></td>
              <td><%=currentHit.isInArea() ? "Да" : "Нет"%></td>
              <td><%=currentHit.getHitTime()%></td>
            </tr>
            <%
              }
              }
            %>
          </tbody>

        </table>
      </div>
      
      </center>
  </body>

</html>