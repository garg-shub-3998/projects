<%@ include file="../header.jspf"%>
<script>
	function validate(form) {
		var name = form.product.value;
		var price = form.price.value;
		var brand = form.brand.value;

		if (name == "") {
			document.getElementById("name").innerHTML = "This field is required";
			return false;
		}
		if (price == "") {
			document.getElementById("price").innerHTML = "This field is required";
			return false;
		}
		if (brand == "") {
			document.getElementById("brand").innerHTML = "This field is required";
			return false;
		}
	}
</script>
</head>
<body>
	<nav class="navbar navbar-default">

		<ul class="nav navbar-nav navbar-left">
			<li><a href="/product.ve"><font>List Product</font></a></li>
		</ul>
		<ul class="nav navbar-nav navbar-left">
			<li><a href="/logout.do"><i class="fa fa-fw fa-user"></i><font>Logout</font></a></li>
		</ul>

	</nav>

	<div class="container form1">
		<div class="jumbotron">

			<p>YOUR NEW Product IS</p>

			<form action="/add-product.ve" method="post"
				onSubmit="return validate(this)">
				<fieldset class="form-group">
					<label>Name<span class="required">*</span></label> <span id="name"
						class="text-danger"></span> <input name="product" type="text"
						class="form-control" /><br>
				</fieldset>
				<fieldset class="form-group">
					<label>Price<span class="required">*</span></label> <span
						id="price" class="text-danger"></span> <input name="price"
						type="text" class="form-control" /><br>
				</fieldset>
				<fieldset class="form-group">
					<label>Brand<span class="required">*</span></label> <span
						id="brand" class="text-danger"></span> <select name="brand"
						class="form-control">
						<br>
						<option></option>
						<c:forEach items="${brands }" var="brand">
							<option>${brand }</option>
						</c:forEach>
					</select>
				</fieldset>
				<p>
					<font color="red">${errorMessage}</font>
				</p>
				<input type="submit" name="add" class="btn btn-success"
					value="Submit">
			</form>
		</div>
	</div>

	<%@ include file="../footer.jspf"%>