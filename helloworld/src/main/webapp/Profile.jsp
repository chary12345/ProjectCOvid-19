<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
  font-family: Arial;
}

* {
  box-sizing: border-box;
}

form.example input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 80%;
  background: #f1f1f1;
}

form.example button {
  float: left;
  width: 20%;
  padding: 10px;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.example button:hover {
  background: #0b7dda;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
<h3>${user}  Search Whoome details you want by Username only.....</h3>

<form  action="searchByEmail" style="margin:auto;max-width:300px" method="post">
  <input type="text" placeholder="Search.." name="email">
  <button type="submit"><i class="fa fa-search"></i></button>
</form><br><br>
<h4>${noRecord}</h4>

<table style="width:50%">
  <tr>
    <th>Email</th>
    <th>Date-Of-Birth</th> 
    <th>Phone Number</th>
  </tr>
  <tr>
    <td>${users.get(0).getEmail()}</td>
    <td>${users.get(0).getDob()}</td>
    <td>${users.get(0).getPhno()}</td>
  </tr>
  
</table>

</body>
</html> 

