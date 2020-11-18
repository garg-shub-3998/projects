<%@ include file="../header.jspf" %>
<script> 
          
            function validate(form) { 
                var name = form.name.value; 
                var password = form.password.value; 
                
               
                if(name == ''){
                	alert ("\n username/email/phonenumber  empty ") 
                	
                    return false;
                }
                if (password == '') { 
                    alert ("\n Password not given") 
                    
                    return false; 
                } 
                
                
  
            } 
        </script> 


</head>

<body>
	<nav class="navbar navbar-default">

		

		
		<a href="/home.all" class="navbar-brand">Home</a>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/signup.all"><font>SignUp</font></a></li>
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
		
		<form action="/login.all" method="post" onSubmit="return validate(this)">
			<fieldset>
		      <label>UserName/Email/Phonenumber:</label>
		      <input placeholder="shubham/shubham@gmail.com/234" name="name" type="text" class="form-control"/><br>
		    </fieldset>
			<fieldset>
		      <label>Password:</label>
		      <input placeholder="123456" name="password" type="password" class="form-control"/><br>
		    </fieldset> 
			<input type="submit" class="btn btn-success btn1" value="Login" />
		</form>


	</div>


<%@ include file="../footer.jspf" %>









