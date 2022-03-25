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
    <script src='main.js'></script>
    <script src='main.js'></script>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body style="background-color:rgb(206, 203, 36); background-image:url('https://images.pexels.com/photos/317356/pexels-photo-317356.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500'); background-size: cover;">
    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
    <div  class="container-fluid" >
      <div class="row" style="min-height: 40px;">
      </div>
        <!--<div class="row">
            <div class="text-center">
                <h4>WELCOME</h4>
            </div>-->
        </div>
       
    </div>
    <div class="container-fluid" >
        <div class="row">
            <div class="col-md-2">

            </div>
            <div class="col-md-8" >
                <div class="row">
                    <h3 style=" text-align: center;font-style: italic; color: maroon;">REGISTER NEW FOODIE</h3>
                </div>
                <div class="row" style="min-height: 20px;">
                </div>
                <form class="row g-15" name="f1" method="post" action="addfoodie">
                      <div class="row" style="min-height: 20px;">
                      </div>
                     
                      <div class="col-md-4">
                        <label for="firstname" class="form-label" style= "font-weight:bold">Fisrt Name</label>
                        <input type="text" class="form-control" name="firstname" id="firstname" placeholder="Enter Fisrt Name" required>
                      </div>
                      <div class="col-md-4">
                        <label for="lastname" class="form-label" style= "font-weight:bold">Last Name</label>
                        <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Enter Last Name" required>
                      </div>
                      
                      <div class="col-4">
                        <label for="password" class="form-label" style= "font-weight:bold">Password</label>
                        <input type="text" class="form-control" name="password" id="password" placeholder="Enter Password" required>
                     </div>
                     <div class="row" style="min-height: 20px;">
                    </div>
                    <div class="col-4">
                        <label for="confirmpassword" class="form-label" style= "font-weight:bold">Confirm Password</label>
                        <input type="text" class="form-control" name="confirmpassword" id="confirmpassword" placeholder="Enter Password" required>
                    </div>
                   
                     <div class="col-md-4">
                        <label for="emailid" class="form-label" style= "font-weight:bold">Email</label>
                        <input type="text" class="form-control" name="emailid" id="emailid" placeholder="Enter Foodie Email" required>
                      </div>
                      <div class="col-md-4">
                        <label for="dob" class="form-label" style= "font-weight:bold">DOB</label>
                        <input type="date" class="form-control" name="dob" id="dob" placeholder="Enter Date of Birth" v><br>
                      </div>
                     
                      <div class="col-md-4">
                        <label for="gender" class="form-label" style= "font-weight:bold">Gender</label>
                        <select name="gender" id="gender" class="form-select">
                                <option value="-1" >Select</option>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                        </select>
                    </div>
                    
                      <div class="col-4">
                        <label for="address" class="form-label" style= "font-weight:bold">Address</label>
                        <input type="text" class="form-control" name="address" id="address" placeholder="Enter Address">
                      </div>
                      <div class="col-4">
                        <label for="mobile" class="form-label" style= "font-weight:bold">Mobile Number</label>
                        <input type="text" class="form-control" name="mobile" id="mobile" placeholder="Enter Phone" required>
                      </div>
                      
                      <div class="row" style="min-height: 20px;">
                      </div>
                      <div class="col-12" style="text-align: center;">
                        <button type="submit" name="submitfoodie" id="submitfoodie"  class="btn btn-success">Add Foodie</button>
                      </div>
                      <div class="row" style="min-height: 10px;">
                      </div>
                </form> 
                <div class="row" style="min-height: 15px;">
                </div>
                <div>
                    <h5 style="color:red">${msg }</h5>
                </div>
            </div>
            <div class="col-md-2">
                
            </div>
            
        </div>

    </div>

    
</body>
</html>