<DOCTYOE html!>

<?php
include "connection.php";
if(isset($_POST['save']))
{
	$course_id = $_POST['course_id'];
	$code = $_POST['code'];
	$name = $_POST['name'];
	$level = $_POST['level'];

	if($course_id)
	{
		mysqli_query($conn, "UPDATE `courses` SET `code`='$code',`name`='$name',`level`='$level' WHERE id='$course_id'");
		header("location: add_course.php");
	}
	else
	{
		mysqli_query($conn, "INSERT INTO `courses`(`code`, `name`, `level`) VALUES ('$code', '$name', '$level')");
	}

	echo "Saved successfully";
}
?>

<html>
	<head>
		<title>
					ADD course 
		</title>
		<<link rel="stylesheet" href="s.css">
	</head>
	
		<body>
			
			<header>
		 <div class="header" > 
			<h2> ADD course Form </h2>
			<br>
			</div>
<?php
include "header.php";

if(isset($_GET['eid']))
{
	$id = $_GET['eid'];
	$co = mysqli_query($conn, "SELECT * FROM `courses` where id='$id'");
	$co = mysqli_fetch_assoc($co);
}
?>
			
			
			
			</header>
		<div style="padding-top: 2%; padding-right: 2%; text-align: right">
			<p id="p1"></p>
			<p id="p2"></p>
			<script src="DateTime.js"></script>
		</div>
		
		<div class="containers">
	
		<form action="" method=post autocomplete="on">
			<input type=hidden name="course_id" value="<?php echo isset($co['id']) ? $co['id'] : "" ?>"> 
			<p><label>
			Course Name : <br>
			<input type=text required name="name"  placeholder="course name" value="<?php echo isset($co['name']) ? $co['name'] : "" ?>"> 
			</label></p> 
			<p><label>Course ID : <br>
			<input type=text required name="code"  placeholder="Course Code" value="<?php echo isset($co['code']) ? $co['code'] : "" ?>">
			</label></p>
			<br>
			level:
			
			<label>Your level:</label> <br>
			<select name="level">
			<?php
			$levels = array(1,2,3,4,5,6,7,8);
			foreach($levels as $lvl)
			{
				$sel = "";
				if(isset($co['level']))
				{
					if($co['level'] == $lvl)
						$sel = " selected ";
				}
				echo '<option value="'.$lvl.'" '.$sel.'>'.$lvl.'</option>';

			}
			?>
			</select>
			
			
			<p>
			<button type="submit" value="Submit" name="save">Submit</button>
			</button>
			<button type="reset" value="Reset">Reset</button>
			</button></p>
		</form>	
	</div>
	<div class="footer">
	<p>	@copyright 2018 </p>
	</div>
	
	
</body>


</html>