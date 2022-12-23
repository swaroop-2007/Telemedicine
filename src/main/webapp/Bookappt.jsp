<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Telemedicine App</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
 
<link href="css/index-styles.css" rel="stylesheet" />

</head>
<body>
<!-- Masthead-->
	<header class="masthead bg-primary text-black text-center">
		
		<div class="container d-flex align-items-center flex-column">  
			<!-- Masthead Avatar Image-->
<a class="nav-link py-3 px-0 px-lg-3 rounded" href="logout">Logout</a>
	<h3>Select Services</h3>
	
	<form method="post" action="BookAppointment" class=register-form>
	  <input type="checkbox" name="service1" value="general_checkup">
	  <label for="vehicle1"> OPD</label><br>
	  <input type="checkbox" name="service2" value="bloodwork">
	  <label for="vehicle2"> Consulting</label><br>
	  <input type="checkbox" name="service3" value="vaccination">
	  <label for="vehicle3"> Blood Tests</label><br><br>
	  
	  <label for="date">Appointment date</label>
	  <input type="text" id="date" name="date"><br><br>
	  <label for="time">Appointment time:</label>
	  <input type="text" id="time" name="time"><br><br>
	  
	  <input type="submit" value="Submit">
	</form>
<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>