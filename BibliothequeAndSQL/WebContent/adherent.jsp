<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adherents</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style><%@include file="/WEB-INF/style.css"%></style>
</head>
<body>
<%--------------------------------------HEADER-----------------------------------------------------%>
	<header class="header">       
    	<div id="burger">
        	<span></span>
            <span></span>
            <span></span>
		</div>
        <ul class="menu">
        	<li class="logo"><a href="#"><svg xmlns="http://www.w3.org/2000/svg" width="46" height="46" fill="currentColor" class="bi bi-book" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M1 2.828v9.923c.918-.35 2.107-.692 3.287-.81 1.094-.111 2.278-.039 3.213.492V2.687c-.654-.689-1.782-.886-3.112-.752-1.234.124-2.503.523-3.388.893zm7.5-.141v9.746c.935-.53 2.12-.603 3.213-.493 1.18.12 2.37.461 3.287.811V2.828c-.885-.37-2.154-.769-3.388-.893-1.33-.134-2.458.063-3.112.752zM8 1.783C7.015.936 5.587.81 4.287.94c-1.514.153-3.042.672-3.994 1.105A.5.5 0 0 0 0 2.5v11a.5.5 0 0 0 .707.455c.882-.4 2.303-.881 3.68-1.02 1.409-.142 2.59.087 3.223.877a.5.5 0 0 0 .78 0c.633-.79 1.814-1.019 3.222-.877 1.378.139 2.8.62 3.681 1.02A.5.5 0 0 0 16 13.5v-11a.5.5 0 0 0-.293-.455c-.952-.433-2.48-.952-3.994-1.105C10.413.809 8.985.936 8 1.783z"/>
</svg></a></li>
            <li class=" books"><a href="#">Books</a></li> 
            <li class=" exampl"> <a href="#">Examples</a></li>
        </ul>       
    </header>
<%--------------------------------------NAV-----------------------------------------------------%>
	<nav class="container mt-5 mb-1 d-flex justify-content-center">
		<h3>Adherents of the Library</h3>
		<ul id="btnContainer" class="row">
			<li><button id="popupCreate" type="button" class="btn btn-outline-success">Create an Adherent</button></li>
			<li><button id="popupFind" type="button" class="btn btn-outline-success">Find an adherent</button></li>	
		</ul>
		<p id="note" style="visibility:hidden">You can't make a search yet</p>
	</nav>
			
<%--------------------------------------CREATE-----------------------------------------------------%>
	<div class="formCreate popup">
		<div class="container form-adherent-create py-5 my-5">	
			<h3 class="section-heading text_center">Add a new adherent</h3>
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle-fill closeCreate" viewBox="0 0 16 16">
 				 <path fill-rule="evenodd" d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
			</svg>
			<div class="text-center">
		
				<form action="ServletAdherent" method="Post" class="container popup">
			
					<label>Name:</label> <input type="text" name="nom" >
					<label>Surname:</label> <input type="text" name="prenom" >
					<label>Mail:</label> <input type="email" name="mail" >
					<label>Address:</label> <input type="text" name="adressePost" >
					<label>Date of birth:</label> <input type="text" name="dateOfB" >
					<input type="hidden" name="action" value="create"> 
					<input type="submit" value="create" class="btn btn-success py-2 mt-2">
					<!-- <a href="./">back</a> -->
				</form>
		
		</div>
		</div>
	</div>		
	<%--------------------------------------MODIFY-----------------------------------------------------%>
	<div class="formModify popup">
		<div class="container form-adherent-modify py-5 my-5">	
		<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle-fill closeModify" viewBox="0 0 16 16">
 				 <path fill-rule="evenodd" d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
			</svg>
			<h3 class="section-heading text_center">Modify Adherents Data</h3>
		
			<div class="text-center">	
				<form action="ServletAdherent" method="Post" class="container popup mt-3 pt-2">		
					<input type="hidden" name="action" value="modify">
					<div class="input-group my-2"><!-- class="input-group my-2" -->
						<label>ID:</label> 
						<input type="number" name="idAdherent" value="${nata.id}"><br>
					</div>
					<div class="input-group my-2"><!-- class="input-group my-2" -->
						<label>Name:</label>
						<input type="text" name="nom" value="${nata.nom}"><br>
					</div>
					<div class="input-group my-2"><!-- class="input-group my-2" -->
						<label>Surname:</label> 
						<input type="text" name="prenom" value="${nata.prenom}"><br>
					</div>
					<div class="input-group my-2"><!-- class="input-group my-2" -->
						<label>Mail:</label> 
						<input type="email" name="mail" value="${nata.mail}"><br>
					</div>
					<div class="input-group my-2"> <!-- class="input-group my-2" -->
						<label>Address:</label> 
						<input type="text" name="adressePost" value="${nata.adressePost}"><br>
					</div>
					<div class="input-group my-2"> <!-- class="input-group my-2" -->
						<label>Date of birth:</label> 
						<input type="text" name="dateOfB" value="${nata.dateOfB}"><br>
					</div>
					<input type="hidden" name="action" value="save"> 
				
					<input type="submit"  value="save" class="btn btn-success py-2 mt-2 closeModify">
					<!-- <a href="./">back</a> -->
				</form>
			</div>
		</div>
	</div>
<%--------------------------------------POP-UP---------Find is still not active------------------------------%>
	<div class="formFind popup">
		<div class="popup-content">
			<svg xmlns="http://www.w3.org/2000/svg" width="46" height="46" fill="#50a3b9" class="bi bi-person-fill" viewBox="0 0 16 16">
  				<path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
			</svg>
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle-fill closeFind" viewBox="0 0 16 16">
 				 <path fill-rule="evenodd" d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z"/>
			</svg>
			<input type="text" placeholder="Surname">
			<input type="submit" value="find" class="btn btn-info">
		</div>
	</div>
	<%--------------------------------------READ-----------------------------------------------------%>
	<div class="container">
		<h3 class="text-center section-heading my-3 mb-2">List of Adherents</h3>
		<table id="adherent">
			<thead>
				<tr>
					<td>id</td>
					<td>name</td>
					<td>surname</td>
					<td>mail</td>
					<td>address</td>
					<td>date of birth</td>
					<td colspan="2">action</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="nata" items="${requestScope.listAdherent}">
					<tr>
						<td><c:out value="${nata.id}" /></td>
						<td><c:out value="${nata.nom}" /></td>
						<td><c:out value="${nata.prenom}" /></td>
						<td><c:out value="${nata.mail}" /></td>
						<td><c:out value="${nata.adressePost}" /></td>
						<td><c:out value="${nata.dateOfB}" /></td>
						<td>
							<form action="ServletAdherent" method="Post"  class="delete">
								<input type="hidden" name="action" value="delete"> 
								<input type="hidden" name="idAdherent" value="<c:out value = "${nata.id}"/>"> 
								<button type="submit" value="delete"><i class="fa fa-trash btn btn-danger fa-lg" aria-hidden="true"></i></button>
							</form>
						</td>
						<td>
							<form action="ServletAdherent" method="Post">
								<input type="hidden" name="action" value="modify"> 
								<input type="hidden" name="idAdherent" value="<c:out value = "${nata.id}"/>">
								<input type="hidden" name="nom" value="<c:out value = "${nata.nom}"/>">
								<input type="hidden" name="prenom" value="<c:out value = "${nata.prenom}"/>"> 
								<input type="hidden" name="mail" value="<c:out value = "${nata.mail}"/>"> 
								<input type="hidden" name="adressePost" value="<c:out value = "${nata.adressePost}"/>"> 
								<input type="hidden" name="dateOfB" value="<c:out value = "${nata.dateOfB}"/>"> 
								<button type="submit" id="popupModify" value="modify" class="btn btn-info"><i class="fa fa-pencil fa-fw" aria-hidden="true"></i></button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<script src="main.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
</body>
</html>