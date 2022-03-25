<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    <%@ page isELIgnored="false" %>
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
<body style="background-color:rgb(206, 203, 36); background-image:url('https://images.pexels.com/photos/317356/pexels-photo-317356.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500'); background-size: cover;">
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
            <div class="col-md-4">

            </div>
            <div class="col-md-4">
                <div class="text-center">
                    <h2 style="color: rgb(240, 93, 9);">REVIEWS</h2>
               </div>
            </div>
            <div class="col-md-2"></div>
            <div class="col-md-2">
                <div>
                    <a class="btn btn-block btn-info mb-1" href="search">SEARCH</a>
                </div>
            </div> 
        </div>
    
          
          
    </div>
   

    <div class="container-fluid">
        <div class="row" style="min-height: 40px;">
        </div>
    	<div class="row">
            <div class="col-md-1">

            </div>
	    	<div class="col-md-10" >
            	 

               
                <table class="table table-striped caption-top" style="background-color:#f8f9fa;border-radius:5px;">
                    <caption style="color:#9708e9;font-weight:bold;text-align: center;"><h4>Reviews for Vendors</h4></caption>
                    <thead>
                    <tr>
                        <th scope="col">Vendor Id</th>
                        <th scope="col">Vendor Name</th>
                        
                        <th scope="col">Location</th>
    					<th scope="col">Foodie ID</th>
                        <th scope="col">Reviews</th>
                        <th scope="col">Ratings</th>
                        
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="r" items="${rlist }">
                    <tr>
                        <td>${r.vendorid }</td>
                        <td>${r.vendorname }</td>
                        <td>${r.location }</td>
                        <td>${r.foodieid }</td>
                        <td>${r.review }</td>
                        <td>${r.ratings }</td>
                        
                    </tr>
                    </c:forEach>
                    </tbody>
                    </table>
               
            </div>
            <div class="col-md-1">

            </div>
            
    	</div>
        
    </div>
</body>
</html>