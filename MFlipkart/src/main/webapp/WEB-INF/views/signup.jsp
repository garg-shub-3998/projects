<%@ include file="../header.jspf"%>

<script>
	function validate(form) {
		console.log("ho");

		/*       	var usertype = document.getElementByName("usertype").value;/>
		        	var username = document.getElementByName("username").value;
		        	var email = document.getElementByName("email").value;
		        	var phonenumber = document.getElementByName("phonenumber").value;
		        	var password = document.getElementByName("password").value;
		        	var cpassword = document.getElementByName("cpassword").value;
		        	var firstname = document.getElementByName("firstname").value;
		        	var lastname = document.getElementByName("lastname").value;
		        	var housenumber = document.getElementByName("housenumber").value;
		        	var locality = document.getElementByName("locality").value;
		        	var state = document.getElementByName("state").value;
		        	var country = document.getElementByName("country").value;
		        	var pincode = document.getElementByName("pincode").value; */

		var usertype = form.usertype.value;
		var username = form.username.value;
		var email = form.email.value;
		var phonenumber = form.phonenumber.value;
		var password = form.password.value;
		var cpassword = form.cpassword.value;
		var firstname = form.firstname.value;
		var lastname = form.lastname.value;
		var housenumber = form.housenumber.value;
		var locality = form.locality.value;
		var state = form.state.value;
		var country = form.country.value;
		var pincode = form.pincode.value;

		document.getElementById('usertype').innerHTML = "";
		if (usertype == "") {
			document.getElementById('usertype').innerHTML = "Please fill this field";
			alert();
			return false;
		}
		document.getElementById('username').innerHTML = "";
		if (username == "") {
			document.getElementById('username').innerHTML = "Please fill this field";
			return false;
		}
		document.getElementById('email').innerHTML = "";
		if (email == "") {
			document.getElementById('email').innerHTML = "Please fill this field";
			return false;
		}
		document.getElementById('phonenumber').innerHTML = "";
		if (phonenumber == "") {
			document.getElementById('phonenumber').innerHTML = "Please fill this field";
			return false;
		}
		if (phonenumber.length != 10) {
			document.getElementById('phonenumber').innerHTML = "Invalid phone number";
			return false;
		}
		document.getElementById('password').innerHTML = "";
		document.getElementById('cpassword').innerHTML = "";
		if (password == "") {
			document.getElementById('password').innerHTML = "Please fill this field";
			return false;
		}
		if (cpassword == "") {
			document.getElementById('cpassword').innerHTML = "Please fill this field";
			return false;
		}
		if (password != cpassword) {
			document.getElementById('cpassword').innerHTML = "Passowrd did not match";
			return false;
		}
		document.getElementById('firstname').innerHTML = "";
		if (firstname == "") {
			document.getElementById('firstname').innerHTML = "Please fill this field";
			return false;
		}
		document.getElementById('lastname').innerHTML = "";
		if (lastname == "") {
			document.getElementById('lastname').innerHTML = "Please fill this field";
			return false;
		}
		document.getElementById('housenumber').innerHTML = "";
		if (housenumber == "") {
			document.getElementById('housenumber').innerHTML = "Please fill this field";
			return false;
		}
		document.getElementById('locality').innerHTML = "";
		if (locality == "") {
			document.getElementById('locality').innerHTML = "Please fill this field";
			return false;
		}
		document.getElementById('state').innerHTML = "";
		if (state == "") {
			document.getElementById('state').innerHTML = "Please fill this field";
			return false;
		}
		document.getElementById('country').innerHTML = "";
		if (country == "") {
			document.getElementById('country').innerHTML = "Please fill this field";
			return false;
		}
		document.getElementById('pincode').innerHTML = "";
		if (pincode == "") {
			document.getElementById('pincode').innerHTML = "Please fill this field";
			return false;
		}

	}
</script>
</head>

<body>
	<nav class="navbar navbar-default">


		<a href="/home.all" class="navbar-brand"><i class="fa fa-home"
			style="font-size: 36px"></i></a>




	</nav>

	<div class="container form1" style="width: 60%">

		<div class="signupform">
			<h2>Enter The User Details</h2>
		</div>
		<div class="jumbotron">
			<form action="/signup.all" method="post"
				onSubmit="return validate(this)">
				<fieldset>
					<label>UserType<span class="required">*</span></label> <input
						type="radio" id="customer" name="usertype" value="customer"
						checked> <label for="customer">Customer</label> <input
						type="radio" id="vendor" name="usertype" value="vendor"> <label
						for="vendor">Vendor</label><br> <span id="usertype"
						class="text-danger"></span>
				</fieldset>
				<fieldset>
					<label>UserName<span class="required">*</span></label> <span
						id="username" class="text-danger"></span> <input
						placeholder="shubham@garg" name="username" type="text"
						class="form-control" value="${username }" /><br>
					<p>
						<font color="red">${usernameMessage}</font>
					</p>
				</fieldset>
				<fieldset>
					<label>Email<span class="required">*</span></label> <span
						id="email" class="text-danger"></span> <input
						placeholder="shubham.garg@fin.co.in" name="email" type="email"
						class="form-control" value="${email}" /><br>
					<p>
						<font color="red">${emailMessage}</font>
					</p>
				</fieldset>
				<fieldset>
					<label>Phone Number<span class="required">*</span></label> <span
						id="phonenumber" class="text-danger"></span> <input
						placeholder="0123456789" name="phonenumber" type="number"
						class="form-control" value="${phonenumber}" /><br>
					<p>
						<font color="red">${phonenumberMessage}</font>
					</p>
				</fieldset>
				<fieldset>
					<label>Password<span class="required">*</span></label> <span
						id="password" class="text-danger"></span> <input
						placeholder="123456" name="password" type="password"
						class="form-control" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
						title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" /><br>
				</fieldset>
				<fieldset>
					<label>Confirm Password<span class="required">*</span></label> <span
						id="cpassword" class="text-danger"></span> <input
						placeholder="123456" name="cpassword" type="password"
						class="form-control" /><br>
				</fieldset>
				<fieldset>
					<label class="formheding">Personel Details</label>
					<fieldset>
						<label>FirstName<span class="required">*</span></label> <span
							id="firstname" class="text-danger"></span> <input
							placeholder="shubham" name="firstname" type="text"
							class="form-control" value="${firstname}" /><br>
					</fieldset>
					<fieldset>
						<label>LastName<span class="required">*</span></label> <span
							id="lastname" class="text-danger"></span> <input
							placeholder="garg" name="lastname" type="text"
							class="form-control" value="${lastname}" /><br>
					</fieldset>
					<fieldset>
						<label>Age</label> <input placeholder="25" name="age"
							type="number" class="form-control" value="${age}" /><br>
					</fieldset>
					<fieldset>
						<label for="gender">Gender</label> <select id="gender"
							name="gender">
							<option value="" selected></option>
							<option value="male">Male</option>
							<option value="female">Female</option>
							<option value="other">Other</option>
						</select>
					</fieldset>

				</fieldset>
				<fieldset>
					<label class="formheding"><strong>Address Details</strong></label>
					<fieldset>
						<label>HouseNumber<span class="required">*</span></label> <span
							id="housenumber" class="text-danger"></span> <input
							placeholder="A34" name="housenumber" type="text"
							class="form-control" value="${housenumber}" /><br>
					</fieldset>
					<fieldset>
						<label>Locality<span class="required">*</span></label> <span
							id="locality" class="text-danger"></span> <input
							placeholder="Milap Nagar" name="locality" type="text"
							class="form-control" value="${locality}" /><br>
					</fieldset>
					<fieldset>
						<label>State<span class="required">*</span></label> <span
							id="state" class="text-danger"></span> <input placeholder="Delhi"
							name="state" type="text" class="form-control" value="${state}" /><br>
					</fieldset>
					<fieldset>
						<label>Country<span class="required">*</span></label> <span
							id="country" class="text-danger"></span> <input
							placeholder="India" name="country" type="text"
							class="form-control" value="${country}" /><br>
					</fieldset>
					<fieldset>
						<label>Area Pincode<span class="required">*</span></label> <span
							id="pincode" class="text-danger"></span> <input
							placeholder="110059" name="pincode" type="text"
							class="form-control" value="${pincode}" /><br>
					</fieldset>
				</fieldset>

				<input type="submit" class="btn btn-success" value="Sign Up" />
			</form>

		</div>
	</div>





	<%@ include file="../footer.jspf"%>