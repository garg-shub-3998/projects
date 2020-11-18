<%@ include file="../header.jspf" %>

</head>
<body>
	<nav class="navbar navbar-default">

	

		

		<ul class="nav navbar-nav navbar-right">
			<li><a href="/logout.do"><font>Logout</font></a></li>
		</ul>

	</nav>

	<div class="container form1">
	<div class="jumbotron">
		
		<table class="table table-striped">
		<caption>Brands in the are</caption>
		   <thead>
		   
		   </thead>
		   <tbody>
		   <c:forEach items="${brands}" var="brand">
		     <tr>
		      <td>${brand}</td>
		      <td>&nbsp;&nbsp;<a class="btn btn-danger" href="/delete-brand.ad?brand=${brand}">Delete</a></td>
		     </tr>
		    </c:forEach>
		   </tbody>
		
		</table>
		
		<p>
		<font color="red">${errorMessage }</font>
		</p>
		
		
		<a class="btn btn-sucess" href="add-brand.ad">Add New Brand</a>
	</div>
</div>

<%@ include file="../footer.jspf" %>