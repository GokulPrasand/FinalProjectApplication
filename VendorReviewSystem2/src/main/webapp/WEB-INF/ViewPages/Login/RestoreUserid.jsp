
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
       <!--- <div class="row">
            <div class="text-center">
                <h4>WELCOME</h4>
            </div>--->
        </div>
       
        
    </div>
    <div class="container-fluid" >
        <div class="row">
            <div class="col-md-4">

            </div>
            <div class="col-md-4" >
                <div class="row">
                    <h4 style=" text-align: center;font-style: italic; color: rgb(55, 13, 243);">RESTORE YOUR USERNAME</h4>
                </div>
                <div class="row" style="min-height: 7px;">
                </div>

                <form class="row g-15" name="f1" method="post" action="restoreusernamem" >
                      <div class="row" style="min-height: 10px;">
                      </div>
                      <div class="col-md-12">
                        <label for="forUserType" class="form-label">User Type</label>
                    
                        <select class="form-select" name="usertype" id="usertype"  aria-label="Default select example">
                            
                            <option value="-1">Select</option>
                            
                            <option value="Vendor">Vendor</option>
                            <option value="Foodie">Foodie</option>
                          </select>
                      </div>
                      
                      <div class="col-md-12">
                        <label for="txtvname" class="form-label">Name</label>
                        <input type="text" class="form-control" name="name" id="name" placeholder="Enter Name" required>
                      </div>
                      <div class="col-md-12">
                        <label for="txtvemail" class="form-label">Email</label>
                        <input type="text" class="form-control" name="email" id="email" placeholder="Enter Email" required>
                      </div>
                      <div class="col-md-12">
                        <label for="txtsq1" class="form-label">Enter answer of secret question1</label>
                        <input type="text" class="form-control" name="sq1" id="sq1" placeholder="Enter answer" required>
                      </div>
                      <div class="col-md-12">
                        <label for="txtsq1" class="form-label">Enter answer of secret question2</label>
                        <input type="text" class="form-control" name="sq2" id="sq2" placeholder="Enter answer" required>
                      </div>

                      <div class="row" style="min-height: 15px;">
                      </div>
                      <div class="col-12" style="text-align: center;">
                        <button type="submit" name="submitvend" id="submitvend"  class="btn btn-success">Click Here</button>
                      </div>
                      <div class="row" style="min-height: 20px;">
                      </div>
                </form> 
                <div>
                    <h5 style="color:green; text-align: center;">${msg }</h5>
                </div>
                
            </div>
            
            <div class="col-md-4">
                
            </div>
            
        </div>
        
    </div>
    
    
</body>
</html>