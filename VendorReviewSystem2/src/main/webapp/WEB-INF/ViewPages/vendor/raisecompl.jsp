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
    <link rel='stylesheet' type='text/css' media='screen' >
    <!--<script src='main.js'></script>-->
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body style="background-color:rgb(206, 203, 36);background-image:url(https://images.unsplash.com/photo-1497864149936-d3163f0c0f4b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1469&q=80);background-size: 100%;">
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
                 <h2 style="color: rgb(240, 93, 9);">GIVE COMPLAINT</h2>
            </div>
        </div>
    
          
    </div>

    <div class="container-fluid">
        <div class="row" style="min-height: 40px;">
        </div>
    	<div class="row">
    		<div class="col-md-2">
		    </div>
	    	<div class="col-md-8" >
            	 <form  name="f3" method="post" action="submitcompl/${fid }" >
               
                <table width="100%" class="table table-striped" border="1" style="text-align:center; background-color:wheat; border-spacing:12px;">
                    <tr>
                        
                        <th>Vendor ID</th>
                        <th>Foodie ID</th>
                      
                        <th>Complaint</th>
                        <th></th>
                    </tr>
                    
                    <tr>
                        <td id="vid">${vid }</td>
                        <td>${fid }</td>
                    
                        
                        <td>
                            <input type="text" class="form-control" id="submitcomp" name="submitcomp">
                            
                        </td>
                        
                        <td>
                          <div class="col-12" style="text-align: center;">
                            <button type="submit" name="submitcomp" id="submitcomp"  class="btn btn-success">SUBMIT</button>
                          </div>
                        </td>
                        
                        
                    </tr>

                    
                </table>
                <div>
                    <h6 style="color:green;text-align: center;">${msg }</h>
                </div>
                
                </form>
            </div>
            <div class="col-md-2">
                
		        </div>
    	</div>
        <div>
            <div class="col-12" style="text-align: center;" >
                <a class="btn btn-block btn-info mb-1" href="vreview">Back to Review Page</a>
            </div>
        </div>
    </div>
</body>
</html>

