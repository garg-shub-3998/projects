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
		<ul class="nav navbar-nav navbar-left">
			<li><a href="/product.cu"><font>List Product</font></a></li>
		</ul>




	</nav>

	<div class="container form1">
		<div class="jumbotron">
			<p class="btn btn-info">Total cart amount = ${carttotal }</p>
			<table class="table table-striped">
				<caption>
					<h2>Products in cart are</h2>
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
								<strong>Quantity</strong>
							</h4></td>
						<td class="td"><h4>
								<strong>TotalPrice</strong>
							</h4></td>
						<td class="td"><h4>
								<strong></strong>
							</h4></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${products}" var="product">
						<tr>
							<td class="td"><h4>${product[1]}</h4></td>
							<td class="td"><h4>${product[2]}</h4></td>
							<td class="td"><h4>${product[3]}</h4></td>
							<td class="td"><a
								href="/update-cart.cu?value=-1&pid=${product[0]}&cartid=${product[5] }&price=${product[2]}"><span
									class="glyphicon glyphicon-minus"></span></a> <strong>${product[4]}</strong><a
								href="/update-cart.cu?value=1&pid=${product[0]}&cartid=${product[5] }&price=${product[2]}"><span
									class="glyphicon glyphicon-plus"></span></a></td>
							<td class="td"><h4>${product[6] }</h4></td>
							<td>&nbsp;&nbsp;<a class="btn btn-danger"
								href="/delete-cart.cu?pid=${product[0]}&cartid=${product[5] }&price=${product[2]}&quantity=${product[4]}"
								onClick="return confirm()"> <i class="fa fa-trash"></i>
							</a></td>
						</tr>

						<p>
							<font color="red">${Message }</font>
						</p>
					</c:forEach>
				</tbody>

			</table>
			

			<a href="checkout.cu" class="btn btn-primary">Checkout</a>
			<p>
				<font color="red">${errorMessage }</font>
			</p>



		</div>
	</div>

	<%@ include file="../footer.jspf"%>