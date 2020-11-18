<%@ include file="../header.jspf"%>
<script>
	
</script>


</head>

<body>
	<nav class="navbar navbar-default">





		<ul class="nav navbar-nav navbar-left">
			<li><a href="/logout.all"><i class="fa fa-fw fa-user"></i><font>Logout</font></a></li>
		</ul>
		<ul class="nav navbar-nav navbar-left">
			<li><a href="/cart.cu"><font>Back to cart</font></a></li>
		</ul>



	</nav>


	<div class="container form1">
		<div class="jumbotron">
			<h2>CheckOut</h2>

		</div>



		<form action="/checkout.cu" method="post">
			<fieldset>
				<label>Amount</label>
				<input name="amount" type="text" value="${amount }" readonly class="form-control" /><br>
			</fieldset>
			<fieldset>
				<label>PaymentType</label> <br>
				<input type="radio" id="dc" name="ptype" value="debitcard" checked> <label for="dc">Debit Card</label><br>
				<input type="radio" id="cc" name="ptype" value="creditcard"> <label for="cc">Credit Card</label><br>
				<input type="radio" id="nb" name="ptype" value="netbanking"> <label for="nb">Net Banking</label><br>
				<input type="radio" id="cod" name="ptype" value="cashondelivery"> <label for="cod">Cash On Delivery</label><br>
			</fieldset>
			<input type="submit" class="btn btn-success btn1" value="Confirm Payment" />
		</form>


	</div>


	<%@ include file="../footer.jspf"%>