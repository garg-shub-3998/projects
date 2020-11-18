<%@ include file="../header.jspf"%>

</head>
<body>
	<nav class="navbar navbar-default">





		<ul class="nav navbar-nav navbar-left">
			<li><a href="/logout.do"><i class="fa fa-fw fa-user"></i><font>Logout</font></a></li>
		</ul>
		<ul class="nav navbar-nav navbar-left">
			<li><a href="/order.cu"><font>My Orders</font></a></li>
		</ul>

		<a href="/cart.cu" class="nav navbar-nav navbar-right"
			style="margin-right: 20px; margin-top: 10px;"><i
			class="fa fa-shopping-cart" style="font-size: 36px;"></i><span
			class="badge badge-warning">${cartcount }</span></a>



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
								href="/add-cart.cu?name=${product[0]}&price=${product[1]}&bname=${product[2]}&pid=${product[3]}">Add
									<i class="fa fa-shopping-cart"></i>
							</a></td>
						</tr>
						<p>
							<font color="red">${errorMessage }</font>
						</p>
						<p>
							<font color="red">${Message }</font>
						</p>
					</c:forEach>
				</tbody>

			</table>

			<p>
				<font color="red">${errorMessage }</font>
			</p>



		</div>
	</div>

	<%@ include file="../footer.jspf"%>