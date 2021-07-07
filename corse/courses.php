<DOCTYOE html!>

<html>
	<head>
		<title>
					information Technology Department
		</title>
		
		<<link rel="stylesheet" href="s.css">
	</head>
	
		<body>
		
		<header>
			  <div class="header" > 
			<h1> IT Department </h1>
			<br>
			</div>
			<?php
				include "header.php";
				include "connection.php";

				if(isset($_GET['did']))
				{
					mysqli_query($conn, "DELETE FROM `courses` WHERE id = ". $_GET['did']);
					header("location: courses.php");
				}
			?>
			
			
			
			</header>
		<div style="padding-top: 2%; padding-right: 2%; text-align: right">
			<p id="p1"></p>
			<p id="p2"></p>
			<script src="DateTime.js"></script>
		</div>
			<div class="container">
			<pre class="tab">
			  <h2>&nbsp;&nbsp;&nbsp;&nbsp;Courses</h2>
			<p id="greetings">
			<table style="margin-left: 20px; width: 90%; border-collapse:collapse " border="3px">
				<tr>
					<th>No</th>
					<th>Code</th>
					<th>Name</th>
					<th>Level</th>
					<th>Action</th>
				</tr>
				<?php
				$sno = 0;
				$courses = mysqli_query($conn, "SELECT * FROM `courses`");
				while($co = mysqli_fetch_assoc($courses))
				{
					$sno++;
					?>
				<tr>
					<td><?php echo $sno ?></td>
					<td><?php echo $co['code'] ?></td>
					<td><?php echo $co['name'] ?></td>
					<td><?php echo $co['level'] ?></td>
					<td><a href="add_course.php?eid=<?php echo $co['id'] ?>">Edit</a> | <a href="?did=<?php echo $co['id'] ?>">Delete</a></td>
				</tr>
				<?php
				}
				?>
			</table>
			</p>
			
	</pre>
	</div>
	
	
	<div class="footer">
	<p>	@copyright 2018 </p>
	</div>
	
	

			
		</body>





</html>