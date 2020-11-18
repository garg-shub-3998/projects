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
					<h2>Available Brands are</h2>
				</caption>
				<thead>

				</thead>
				<tbody>
					<c:forEach items="${brands}" var="brand">
						<tr>
							<td class="font-weight-bold td"><h4>${brand}</h4></td>
							<td class="font-weight-bold td"><a class="btn btn-danger"
								href="/delete-brand.ad?brand=${brand}"
								onClick="return confirm()"><i class="fa fa-trash"></i></a></td>
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

	<%@ include file="../footer.jspf"%>