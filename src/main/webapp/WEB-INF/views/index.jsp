<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Static content -->
<link rel="stylesheet" href="/resources/css/style.css">

<title>Spring Boot</title>
</head>
<body>
  <h1>Spring Boot - Number Play Game</h1>
  <hr>

  <div class="form">
    <form action="guess" method="post">
      <table>
      	<tr> <td colspan="3">I am thinking a number from 1 to 10</td></tr>
      	<tr> <td colspan="3">You must guess what it is in three times</td></tr>
        <tr>
          <td>Enter Your Guess</td>
          <td><input id="myText" type="number" min ="1" max="10" onkeyup="validateNumber();"  name="number"></td>
          <td><input type="submit" value="guess"></td>
        </tr>
      </table>
      <span>       
      	${message}
      </span>  
    </form>
  </div>

</body>
<script>
	function validateNumber(){
		var value = document.getElementById("myText").value;
		if(parseInt(value) > 0 && parseInt(value) <= 10){
			return true;
		}else{
			document.getElementById("myText").value = "";
		}
	}
</script>
</html>

