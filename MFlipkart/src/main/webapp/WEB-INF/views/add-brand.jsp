<%@ include file="../header.jspf"%>

<script>
	function validate(form) {

		var brand = form.newbrand.value;

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
			<li><a href="/brand.ad"><font>List Brand</font></a></li>
		</ul>
		<ul class="nav navbar-nav navbar-left">
			<li><a href="/logout.do"><i class="fa fa-fw fa-user"></i><font>Logout</font></a></li>
		</ul>

	</nav>

	<div class="container form1">
		<div class="jumbotron">

			<p>YOUR NEW Brand IS</p>

			<form action="/add-brand.ad" method="post"
				onSubmit="return validate(this)">
				<fieldset class="form-group">
					<label>Name<span class="required">*</span></label> <span id="brand"
						class="text-danger"></span> <input name="newbrand" type="text"
						class="form-control" /><br>
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