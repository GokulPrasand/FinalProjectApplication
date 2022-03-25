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

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body style="background-color:rgb(206, 203, 36); background-image:url(https://images.pexels.com/photos/1097930/pexels-photo-1097930.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2); background-size:cover; background-repeat: no-repeat;background-position: center;"> 
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
                 <h3 style="color: rgb(240, 93, 9);font-style: italic">ADMIN HOME</h3>
            </div>
        </div>
    
          <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
              <a class="navbar-brand" href="#">ADMIN</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="navbar navbar-dark bg-primary" id="navbarNavAltMarkup">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  
                   <li class="nav-item">
                    <a class="nav-link active"  href="adminhome">Home</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;
                  <li class="nav-item">
                    <a class="nav-link active"  href="vendrs">Vendor Requests</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;
                  <li class="nav-item">
                    <a class="nav-link active"  href="showv">Vendor Details</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;
                 <li class="nav-item">
                    <a class="nav-link active"  href="showf">Foodie Details</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;
                  <li class="nav-item">
                    <a class="nav-link active"  href="showreviews">View Review</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;
                  <li class="nav-item">
                    <a class="nav-link active"  href="showcomplaints">View Complaint</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;
                  <li class="nav-item">
                    <a class="nav-link active"  href="greport">Generate Report</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;
                  <li class="nav-item">
                    <a class="btn btn-block btn-dark mb-2"    href="ab">Logout</a>
                  </li>&nbsp; &nbsp; &nbsp; &nbsp;
                </ul>
               </div>
            </div>
        </nav>
          
    </div>
    <div class="container">
        <div class="row" style="min-height: 100px;">
        </div>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-lg-4 text-center">
            </div>
            <div class="col-lg-4 text-center">
                <h1 style="font-style:italic; color: maroon;">WELCOME ADMIN</h1>  
            </div>
            <div class="col-lg-4 text-center">
            </div>
        </div>
    </div>

    
</body>
</html>