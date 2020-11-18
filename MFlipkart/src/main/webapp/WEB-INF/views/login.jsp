<%@ include file="../header.jspf"%>
<script>
	function validate(form) {
		var name = form.name.value;
		var password = form.password.value;

		if (name == '') {
			document.getElementById("name").innerHTML = "This field is required";
			return false;
		}
		if (password == '') {
			document.getElementById("password").innerHTML = "This field is required";
			return false;
		}

	}
</script>


</head>

<body>
	<nav class="navbar navbar-default">




		<a href="/home.all" class="navbar-brand"><i class="fa fa-home"
			style="font-size: 36px"></i></a>
		<ul class="nav navbar-nav navbar-left">
			<li><a href="/signup.all"><i class="fa fa-fw fa-user"></i><font>SignUp</font></a></li>
		</ul>



	</nav>


	<div class="container form1">
		<div class="jumbotron">
			<h1>Welcome to MiniFlipkart</h1>
			<h3>Enter your login details</h3>
		</div>

		<p>
			<font color="green">${Message}</font>
		</p>
		<p>
			<font color="red">${errorMessage}</font>
		</p>

		<form action="/login.all" method="post"
			onSubmit="return validate(this)">
			<fieldset>
				<label>UserName/Email/Phonenumber:</label> <span id="name"
					class="text-danger"></span> <input
					placeholder="shubham/shubham@gmail.com/234" name="name" type="text"
					class="form-control" /><br>
			</fieldset>
			<fieldset>
				<label>Password:</label> <span id="password" class="text-danger"></span>
				<input placeholder="123456" name="password" type="password"
					class="form-control" /><br>
			</fieldset>
			<input type="submit" class="btn btn-success btn1" value="Login" />
		</form>


	</div>


	<%@ include file="../footer.jspf"%>