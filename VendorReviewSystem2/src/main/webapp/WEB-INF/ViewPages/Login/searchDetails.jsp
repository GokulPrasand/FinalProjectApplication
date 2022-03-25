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
        <div class="row">
            <div class="text-center">
                 <h2 style="color: rgb(240, 93, 9);">SEARCH</h2>
            </div>
        </div>
    
          
    </div>

    <div class="container-fluid">
        <div class="row" style="min-height: 40px;">
        </div>
    	<div class="row">
    		<div class="col-md-4">
		    </div>
	    	<div class="col-md-4" >
            	 
                <div class="row"  >
                    <div class="col-md-3"></div>
                    <div class="col-md-6" style="text-align: center;background-color:rgb(172, 199, 110)">
                        <h5 style="color: maroon;text-decoration: underline; ">Seach Here</h5>
                    </div>
                    <div class="col-md-3"></div>
                </div>
                <div class="row" style="min-height: 20px;">
                </div>
                <form  name="f3" method="post" action="searchd" >
                    <div class="row">
                        <label class="form-label" style="font-weight: bold;">Seach Based On</label>
                    </div>
                    
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="search" id="name" value="name">
                        <label class="form-check-label" for="name">
                           Vendor Name
                        </label>
                    </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="search" id="location" value="location">
                        <label class="form-check-label" for="location">
                          Location
                        </label>
                    </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                     <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="search" id="rating" value="rating">
                        <label class="form-check-label" for="rating">
                          Rating
                        </label>
                     </div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                     <div class="form-outline">
                        <label class="form-label" for="type" style="font-weight: bold;">Enter Input</label>
                        <input type="text" id="type" name="parameter" class="form-control" placeholder="Enter the parameter"/>
                      </div>
                      <div class="row" style="min-height: 20px;">
                    </div>
                      <div class="col-12" style="text-align: center;">
                        <button type="submit" name="submit" id="submit"  class="btn  btn-info">Seach</button>
                      </div>
        
            </form>
            <div>
                <h5 style="color:green">${msg }</h5>
            </div>
         
            </div>
            <div class="col-md-4">
              
		    </div>
    	</div>
    </div>
    
</body>
</html>