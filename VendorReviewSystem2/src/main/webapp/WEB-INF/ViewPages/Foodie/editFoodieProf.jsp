<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Page Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <!--<script src='main.js'></script>-->
    <style >
        th{
            background-color: aqua;
        }
    </style>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body style="background-color:rgb(206, 203, 36); background-image:url(https://images.pexels.com/photos/82256/pexels-photo-82256.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2); background-size: cover;">
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    -->

    <div  class="container-fluid" >
        <div class="row" style="min-height: 20px;">
        </div>
        
    
          <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">FOODIE</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
              <div div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  
                  <li class="nav-item">
                    <a class="nav-link active"  href="fhome">Home</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;
                    <a class="nav-link active"  href="freview">Review</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
                 <li class="nav-item">
                    <a class="nav-link active"  href="viewfreview">View Reviews</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;
                  <li class="nav-item">
                    <a class="nav-link active"  href="viewfprofile">View Profile</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;
                  
                    <a class="btn btn-block btn-secondary mb-2"    href="ab">Logout</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
                </ul>
               </div>
            </div>
        </nav>
          
    </div>

    <div class="container-fluid">
        <div class="row" style="min-height: 40px;">
        </div>
    	<div class="row">
    		<div class="col-md-3">
		    </div>
	    	<div class="col-md-6" >
               
          
            	<form  name="f3" method="post" action="updatefprofile" >
                
               
                    <table width="100%" class="table table-striped caption-top" style="text-align: center; background-color:#f8f9fa;border-radius:5px;" border="1" >
                        
                        <h2 style="color: rgb(240, 93, 9); background-color: darkgray;text-align: center;">My Profile</h2>
                            <tr>
                                <th>Foodie ID</th>
                                <td>${f.foodieid }</td>
                            </tr>
                            <tr>
                                <th>Fisrt Name</th>
                                <td>
                                    
                                        <input type="text" class="form-control" name="firstname" id="firstname" value="${f.firstname }" >
                                    
                                </td>
                            </tr>
                            <tr>
                                <th>Last Name</th>
                                <td>
                                    <input type="text" class="form-control" name="lastname" id="lastname" value="${f.lastname }" >
                                </td>
                            </tr>
                            <tr>
                                <th>Gender</th>
                                <td>
                                    <input type="text" class="form-control" name="gender" id="gender" value="${f.gender }" >
                                </td>
                            </tr>
                            <tr>
                                <th>Date of Birth</th>
                                <td>
                                    <input type="text" class="form-control" name="dob" id="dob" value="${f.dob }" >
                                </td>
                            </tr>
                            <tr>
                                <th>Password</th>
                                <td>
                                    <input type="text" class="form-control" name="pass" id="pass" value="${f.password }" >
                                </td>
                            </tr>
                            <tr>
                                <th>Email</th>
                                <td>
                                    <input type="text" class="form-control" name="email" id="email" value="${f.emailid }" >
                                </td>
                            </tr>
                            <tr>
                                <th>Mobile</th>
                                <td>
                                    <input type="text" class="form-control" name="mobile" id="mobile" value="${f.mobile }" >
                                </td>
                            </tr>
                            <tr>
                                <th>Address</th>
                                <td>
                                    <input type="text" class="form-control" name="address" id="address" value="${f.address }" >
                                </td>
                            </tr>
                            
                
                            
                        </table>
                        <div class="row">
                            
                            <div class="col-md-12" style="text-align: center;">
                                <button type="submit" name="submitprofile" id="submitprofile"  class="btn btn-success">SAVE</button>
                            </div>
                            <div>
                                <h6 style="color:green;text-align: center;">${msg }</h>
                            </div>
                        </div>
                </form>
            <div class="col-md-3">
            </div>
    	</div>
        
    </div>
</body>
</html>