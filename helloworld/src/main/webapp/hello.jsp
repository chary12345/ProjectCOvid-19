<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-image:
		url("https://images.unsplash.com/photo-1483985988355-763728e1935b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1400&q=60");
	background-color:;
}
  background-color: ;
}

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}

/* Add a blue text color to links */
a {
  color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
  background-color: #f1f1f1;
  text-align: center;
}
</style>
</head>

<body>
<div style="float: left; margin: 2em">
		<h1>Register</h1>
		<p>Please fill in this form to create an account.</p>
<form action="register" method="get" onSubmit="return validate_form(this);">
		<table>
		
			<tr>
				<td><label for="email"><b>Email</b></label></td>
				<td><input type="text" name="email" ></td>
			</tr>
			<tr>
				<td><label for="psw"><b>Password</b></label></td>
				<td><input type="password" name="psw"></td>
			</tr>
			<tr>
				<td><label for="psw_repeat"><b>Repeat-Password</b></label></td>
				<td><input type="password" name="psw_repeat"></td>
			</tr>
			<tr>
				<td><label for="dob"><b>Date Of Birth</b></label></td>
				<td><input type="text" name="dob" ></td>
			</tr>
			
			<tr>
				<td><label for="mobile"><b>Phone No</b></label></td>
				<td><input type="text" name="mobile" ></td>
			</tr>
			<tr>
				<td><input type="reset" value="Clear"></td>
			</tr>
			<!-- <tr>
				<td><button type="submit" class="registerbtn"
						onclick="registervalidate()">Register</button></td>
			</tr> -->
		</table>

		<button type="submit" class="registerbtn" onclick="registervalidate()">Register</button>
		<br>
		
		
		

		
	
 <!-- 
<form action="register">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" id="psw" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw_repeat" id="psw-repeat" required>
    <hr>
    <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn">Register</button>
  </div>
  
  <div class="container signin">
    <p>Already have an account? <a href="login.jsp">Sign in</a>.</p>
  </div> --> 
</form>
</div>

</body>
</html>
