<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>  
<html lang="en">  
<head>  
  <title>Bootstrap Example</title>  
  <meta charset="utf-8">  
  <meta name="viewport" content="width=device-width, initial-scale=1">  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">  
    
</head>  
<body>  
  
    <div class="container-fluid" >
        <div class="row">
            <div class="col-md-2" ></div>
            <div class="col-md-8" >
                <div class="row" style="min-height: 50px;">
                </div>
                <form class="row g-15" name="f1" method="post" action="addfoodie" style="background-color: azure;">
                    <h4 style=" text-align: center;font-style: italic; color: rgb(14, 10, 240);">REGISTER NEW FOODIE</h4>
                    <div class="row" style="min-height: 20px;">
                    </div>
                   
                    <div class="col-md-4">
                      <label for="firstname" class="form-label">Fisrt Name</label>
                      <input type="text" class="form-control" name="firstname" id="firstname" placeholder="Enter Fisrt Name">
                    </div>
                    <div class="col-md-4">
                      <label for="lastname" class="form-label">Last Name</label>
                      <input type="text" class="form-control" name="lastname" id="lastname" placeholder="Enter Last Name">
                    </div>
                    
                    <div class="col-md-4">
                      <label for="password" class="form-label">Password</label>
                      <input type="text" class="form-control" name="password" id="password" placeholder="Enter Password">
                   </div>
                   <div class="row" style="min-height: 80px;">
                  </div>
                  <div class="col-md-4">
                      <label for="confirmpassword" class="form-label">Confirm Password</label>
                      <input type="text" class="form-control" name="confirmpassword" id="confirmpassword" placeholder="Enter Password">
                  </div>
                 
                   <div class="col-md-4">
                      <label for="emailid" class="form-label">Email</label>
                      <input type="text" class="form-control" name="emailid" id="emailid" placeholder="Enter Foodie Email">
                    </div>
                    <div class="col-md-4">
                      <label for="dob" class="form-label">DOB</label>
                      <input type="date" class="form-control" name="dob" id="dob" placeholder="Enter Date of Birth"><br>
                    </div>
                   
                    <div class="col-md-4">
                      <label for="gender" class="form-label">Gender</label><br>
                      <select name="gender" id="gender" class="form-select">
                              <option value="-1" >Select</option>
                              <option value="Male">Male</option>
                              <option value="Female">Female</option>
                      </select>
                  </div>
                  
                    <div class="col-md-4">
                      <label for="address" class="form-label">Address</label>
                      <input type="text" class="form-control" name="address" id="address" placeholder="Enter Address">
                    </div>
                    <div class="col-md-4">
                      <label for="mobile" class="form-label">Mobile Number</label>
                      <input type="text" class="form-control" name="mobile" id="mobile" placeholder="Enter Phone">
                    </div>
                    <div class="row" style="min-height: 20px;">
                    </div>
                    <div class="col-12" style="text-align: center;">
                		<button type="submit" name="addfoodie" id="addfoodie"  class="btn btn-success" >Register</button>
                        <button type="button" name="addfoodie" id="addfoodie"  class="btn btn-success" data-target="#mymodel" data-toggle="modal">Click Here</button>
                    </div>
                    <div class="row" style="min-height: 10px;">
                    </div>
                    
                    <div class="row" style="min-height: 20px;">
                    </div>
                    
                 </form>   
                    <div class="modal fade" role="dialog" id="mymodel">
                    	<div>
                    		
                    	</div>
                        <div class="modal-dialog">
                          <div class="model-content">
                              
                              <div class="model-header">
                                  <h3 class="text-danger" style="background-color: gainsboro;text-align: center;">Answer the secret questions</h3>
                                  <button type="button" class="close" data-dismiss="model">&times;</button>
                              </div>
                              
                              <div class="modal-body" style="background-color: white;">
	                              <form name="f1" method="post" action="addfoodieuser">
	                              	<div class="form-group">
			                            <label for="pet" class="form-label">First Name</label>
			                            <input type="text" class="form-control" name="firstname" id="firstname" required="true">
			                         </div>
			                         <div class="form-group">
			                            <label for="pet" class="form-label">Last Name</label>
			                            <input type="text" class="form-control" name="lastname" id="lastname" required="true">
			                         </div>
			                         <div class="form-group">
			                            <label for="pet" class="form-label">Email</label>
			                            <input type="text" class="form-control" name="email" id="email" required="true">
			                         </div>
			                         
			                         <div class="form-group">
			                            <label for="pet" class="form-label">1.What's your favourite pet</label>
			                            <input type="text" class="form-control" name="sq1" id="sq1" required="true">
			                         </div>
			                         <div class="form-group">
			                            <label for="fsport" class="form-label">2.What's your Favourite Sport</label>
			                            <input type="text" class="form-control" name="sq2" id="sq2"  required="true">
			                         </div>
			                         <div class="form-group">
			                            <label for="bcity" class="form-label">3.City ,where you Born</label>
			                            <input type="text" class="form-control" name="sq3" id="sq3"  required="true">
			                         </div>
	                              </form>
                      		</div>
                            
        
                              <div class="modal-footer" style="background-color: ghostwhite;">
                                <button type="submit" name="foodiedt" id="foodiedt" class="btn btn-secondary" data-dismiss="modal">SUBMIT</button>
                              </div>
        
                          </div>
                        </div>
                    </div>
                    
				
                    
                
            
            </div>
            <div class="col-md-2" ></div>
            
        </div>

        
    </div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>  
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  
</body>  
</html>  