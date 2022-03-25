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
<body style="background-color:rgb(206, 203, 36); background-image:url(https://images.unsplash.com/photo-1497864149936-d3163f0c0f4b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1469&q=80);background-size: 100%;">
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
              <a class="navbar-brand" href="#">VENDOR</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;
              <div class="navbar navbar-dark bg-primary" id="navbarNavAltMarkup">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  
                 
                  <li class="nav-item">
                    <a class="nav-link active"  href="vhome">Home</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;
                    <a class="nav-link active"  href="vreview">View Review</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
                
                  <li class="nav-item">
                    <a class="nav-link active"  href="viewvprofile">View Profile</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;
                  
                    <a class="btn btn-block btn-dark mb-2"    href="ab">Logout</a>
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
               
     
                    <table width="100%" class="table table-striped caption-top" style="text-align: center; background-color:#f8f9fa;border-radius:5px;" border="1" >
                        
                        <h2 style="color: rgb(240, 93, 9); b;text-align: center;">My Profile</h2>
                            <tr>
                                <th>Vendor Id</th>
                                <td>${v.vendorid }</td>
                            </tr>
                            <tr>
                                <th>Vendor Name</th>
                                <td>${v.vendorname }</td>
                            </tr>
                            <tr>
                                <th>email</th>
                                <td>${v.email}</td>
                            </tr>
                            <tr>
                                <th>Location</th>
                                <td>${v.location}</td>
                            </tr>
                            <tr>
                                <th>Website Id</th>
                                <td>${v.websiteid}</td>
                            </tr>
                            <tr>
                                <th>Password</th>
                                <td>${v.password }</td>
                            </tr>
                            <tr>
                                <th>Vendor Type</th>
                                <td>${v.vendortype }</td>
                            </tr>
                            <tr>
                                <th>Cusine Type</th>
                                <td>${v.cusinetype}</td>
                            </tr>
                            <tr>
                                <th>Menu Card</th>
                                <td><img src="getMenuPhoto/${v.vendorid}" width="100" height="100"/></td>
                            </tr>
                             <tr>
                                <th>Photo</th>
                                <td><img src="getVendorPhoto/${v.vendorid}" width="100" height="100"/></td>
                            </tr>
                            
                
                            
                        </table>
                
            <div class="col-md-3">
              
		    </div>
    	</div>
        <div class="row">
            <div class="col-md-9"></div>
            <div class="col-md-3">
                <a class="btn btn-block btn-info mb-1"    href="editvprofile">EDIT PROFILE</a>
            </div>
        </div>
    </div>
</body>
</html>
