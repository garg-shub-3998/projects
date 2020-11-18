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
			<li><a href="/order.cu"><font>Orders</font></a></li>
		</ul>




	</nav>

	<div class="container form1">
		<div class="jumbotron">
			
			<table class="table table-striped">
				<caption>
					<h2>Items inside order</h2>
				</caption>
				<thead>
					<tr>
						<td class="td"><h4>
								<strong>Name</strong>
							</h4></td>
						<td class="td"><h4>
								<strong>Price</strong>
							</h4></td>
						<td class="td"><h4>
								<strong>Quantity</strong>
							</h4></td>
						<td class="td"><h4>
								<strong>Total Price</strong>
							</h4></td>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${items}" var="item">
						<tr>
							<td class="td"><h4>${item[0]}</h4></td>
							<td class="td"><h4>${item[1]}</h4></td>
							<td class="td"><h4>${item[2]}</h4></td>
							<td class="td"><h4>${item[3]}</h4></td>
						</tr>

						
					</c:forEach>
				</tbody>

			</table>
			

			



		</div>
	</div>

	<%@ include file="../footer.jspf"%>