<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Health Portal</title>
</head>


<body>
<p>
Doctor
</p>

<form method="get" action="DoctorPage" class=register-form>

<table>
		
        <tr>
        	<th>Appointment ID</th>
        	<th>Date</th>
     		<th>Patient MRN</th>
     	</tr>
     	<tr><td>145414</td>
        	<td>05/22/2022</td>
        	<td>14519</td>
        </tr>
        <tr><td>145417</td>
        	<td>06/02/2022</td>
        	<td>14513</td>
        </tr>
        	
        	<tr><td>145413</td>
        	<td>05/21/2022</td>
        	<td>14518</td>
        </tr>
        	
            <!-- Appointment ID: ${item.apt_id}</td>
            <td>Date: ${item.date}</td>  
            <td>Patient MRN: ${item.patient_mrn}/></td> --><td>
        
</table>
</form>
<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="logout">Logout</a></li>
				
							

</body>
</html>
