<%@ include file="../header.jspf"%>
<script type="text/javascript">
	
	
	
</script>

</head>
<body>
	<nav class="navbar navbar-default">





		<ul class="nav navbar-nav navbar-left">
			<li><a href="/logout.do"><i class="fa fa-fw fa-user"></i><font>Logout</font></a></li>
		</ul>
		<ul class="nav navbar-nav navbar-left">
			<li><a href="/product.cu"><font>List Product</font></a></li>
		</ul>




	</nav>

	<div class="container form1">
		<div class="jumbotron">
			
			<table class="table table-striped">
				<caption>
					<h2>Orders made are</h2>
				</caption>
				<thead>
					<tr>
						<td class="td"><h4>
								<strong>ID</strong>
							</h4></td>
						<td class="td"><h4>
								<strong>Amount</strong>
							</h4></td>
						<td class="td"><h4>
								<strong>Payment Type</strong>
							</h4></td>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${orders}" var="order">
						<tr>
							<td class="td"><h4><a  href="/list-order.cu?orderid=${order[0]}">${order[0]}</a></h4></td>
							<td class="td"><h4>${order[1]}</h4></td>
							<td class="td"><h4>${order[2]}</h4></td>
							
						</tr>

						
					</c:forEach>
				</tbody>

			</table>
			

			



		</div>
	</div>

	<%@ include file="../footer.jspf"%>