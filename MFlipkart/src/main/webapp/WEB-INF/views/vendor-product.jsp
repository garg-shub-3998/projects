<%@ include file="../header.jspf"%>
<script type="text/javascript">
	function confirm() {
		alert("Are you sure you want to delete");
		return true;
	}
</script>
</head>
<body>
	<nav class="navbar navbar-default">





		<ul class="nav navbar-nav navbar-left">
			<li><a href="/logout.do"><i class="fa fa-fw fa-user"></i><font>Logout</font></a></li>
		</ul>

	</nav>

	<div class="container form1">
		<div class="jumbotron">

			<table class="table table-striped">
				<caption>
					<h2>Available Products are</h2>
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
								<strong>Brand</strong>
							</h4></td>
						<td class="td"><h4>
								<strong></strong>
							</h4></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="product">
						<tr>
							<td class="td"><h4>${product[0]}</h4></td>
							<td class="td"><h4>${product[1]}</h4></td>
							<td class="td"><h4>${product[2]}</h4></td>
							<td>&nbsp;&nbsp;<a class="btn btn-danger"
								href="/delete-product.ve?name=${product[0]}&price=${product[1]}&bname=${product[2]}"
								onClick="return confirm()"><i class="fa fa-trash"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>

			</table>

			<p>
				<font color="red">${errorMessage }</font>
			</p>


			<a class="btn btn-sucess" href="add-product.ve">Add New Product</a>
		</div>
	</div>

	<%@ include file="../footer.jspf"%>