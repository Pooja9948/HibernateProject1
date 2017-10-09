<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/home.css">
</head>
<body>
	<%
		HttpSession session1 = request.getSession();
		String sting = (String) session1.getAttribute("uname");
		if (sting == "") {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		} else {
	%>


	<div class="well">
		<div style="background-color: cyan; font-size: 40px" align="center">
			Welcome to Banking Application</div>
		<div style="background-color: cyan; font-size: 40px" align="right">
			<form action="Logout">
				<input type="submit" value="Logout" class="btn btn-primary">
			</form>
		</div>
	</div>

	<div class="container">
		<div class="x">
			<button type="button" data-toggle="modal" data-target="#cityModal"
				onclick="cityData('bangalore')" class="btn btn-primary btn-lg">Bangalore</button>
			<button type="button" data-toggle="modal" data-target="#cityModal"
				onclick="cityData('mumbai')" class="btn btn-primary btn-lg">Mumbai</button>
			<button type="button" data-toggle="modal" data-target="#cityModal"
				onclick="cityData('delhi')" class="btn btn-primary btn-lg">Delhi</button>

		</div>
		<h1><%=session.getAttribute("uname")%></h1>
		<!-- Modal -->
		<div class="modal fade" id="editModal" role="dialog"
			style="z-index: 1060">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Update Details</h4>
					</div>

					<div class="modal-body"><h1 id="id"></h1>
						<form name="myform" class="form" action="UpdateCustomerData" method="post" onsubmit="return validateform()"
							style="z-index: 1050">
							<!-- put if condition for id  -->
							<div class="container">
								<div class="row">
									<div class="control-group">
										<input id="id1" type="hidden" name="id1" value="">
										<div class="controls">
											<label class="col-sm-3">Name</label> <input id="name"
												name="name" value="" type="text" placeholder="" class="input-xlarge"
												required="">
										</div>
										<div class="controls">
											<label class="col-sm-3">EmailId</label> <input id="email"
												name="email" value="" type="email" placeholder=""
												class="input-xlarge" required="">
										</div>
										<div class="controls">
											<label class="col-sm-3">Account No</label> <input
												id="accountno" name="accountno" value="" type="text" placeholder=""
												class="input-xlarge" required="">
										</div>
										<div class="controls">
											<label class="col-sm-3">City</label> <select id="city"
												name="city" class="col-sm-2">
												<option value="bangalore">Bangalore</option>
												<option value="mumbai">Mumbai</option>
												<option value="delhi">Delhi</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<input type="submit" name="submit" id="submit"  class="btn btn-info data-dismiss="modal">
								<button type="close" name="close" id="close" value="Close"
									class="btn btn-info data-dismiss="modal">Close</button>
							</div>
						</form>


					</div>
				</div>
			</div>
		</div>
		<!--Modal for edit  -->
		<div class="modal fade" id="myModal" role="dialog"
			style="z-index: 1060">
			<div class="modal-dialog">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Add Details</h4>
					</div>

					<div class="modal-body">
						<!-- <h1 id="id"></h1> -->
						<form name="myform" class="form" action="Home" method="Post" onsubmit="return validateform()"
							style="z-index: 1050">
							<!-- put if condition for id  -->
							<div class="container">
								<div class="row">
									<div class="control-group">
										<div class="controls">
											<label class="col-sm-3">Name</label> <input id="name"
												name="name" type="text" placeholder="" class="input-xlarge"
												required="">
										</div>
										<div class="controls">
											<label class="col-sm-3">EmailId</label> <input id="email"
												name="email" type="email" placeholder=""
												class="input-xlarge" required="">
										</div>
										<div class="controls">
											<label class="col-sm-3">Account No</label> <input
												id="accountno" name="accountno" type="text" placeholder=""
												class="input-xlarge" required="">
										</div>
										<div class="controls">
											<label class="col-sm-3">City</label> <select id="city"
												name="city" class="col-sm-2">
												<option value="bangalore">Bangalore</option>
												<option value="mumbai">Mumbai</option>
												<option value="delhi">Delhi</option>
											</select>
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<input type="submit" name="submit" id="submit"
									class="btn btn-info data-dismiss="modal">
								<button type="close" name="close" id="close" value="Close"
									class="btn btn-info data-dismiss="modal">Close</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>


		<div class="modal fade" id="cityModal" role="dialog"
			style="z-index: 1050">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header" id="city-title">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Customer Details</h4>
					</div>

					<div class="modal-body" id="details-table"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%
		}
	%>
</body>
<footer>
<button type="button" id="div1" class="btn btn-success"
	style="margin-top: 200px; float: right" data-toggle="modal"
	data-target="#myModal">Add</button>
</footer>




<script type="text/javascript">
	$(document).ready(function() {
		alert("inside function");
		var city = "";
		var id = "";
		var currentId="";
		console.log("Starting javascript");
	});

	function cityData(city) {
		console.log("inside javascript");
		$.ajax({
			type : 'POST',
			url : 'AccountView',
			data : {
				city : city
			},
			success : function(result) {
				console.log("ajax success");
				console.log();
				$('#details-table').html(result);
				$('#body-of-modal').html(result);
				$('#cityModal').modal('show');
			}
		});
	}
	function updateAccount(id) {
		console.log("inside javascript");
		$.ajax({
			type : 'POST',
			url : 'Home',
			dataType : 'JSON',
			data : {
				id : id
			},
			success : function(result) {
				alert('inside update account success')
				console.log("ajax success1");
				console.log(result.name);
				$('#name').val(result.name);
				$('#email').val(result.email);
				$('#accountno').val(result.accountno);
				$('#city').val(result.city);
				$('#id1').val(id);

				$('#editModal').modal('show');
			},
			error : function(result) {
				console.log("Woah");
				console.log(result);
			}
		});
	}

	function addData() {
		alert('inside adddata');
		console.log($('#name').val());
		console.log("id : "+$('#id1').val()+
				"name : "+$('#name').val()+
				"email : "+$('#email').val()+
				"city : "+$('#city').val()+
				"accountno :"+$('#accountno').val());
		$.ajax({
			url : 'UpdateCustomerData',
			type : 'POST',
			data : 
			{
				id : $('#id1').val(),
				name : $('#name').val(),
				email : $('#email').val(),
				city : $('#city').val(),
				accountno : $('#accountno').val(),
				//id : currentId
			},
			success : function() 
			{
				alert('data edited');
				console.log("Added");
				/* $('#name').val(" "), 
				$('#email').val(" "), 
				$('#city').val(" "),
				$('#accountno').val(" "),
				
				$('#editModal').modal('hide');
				if (edited == 1) {
					cityData(currentCity);
					edited = 0;
				}
				currentId = 0; */
			}
		});
	}
	function deleteAccount(id){
		alert('inside deleteaccount');
		console.log("inside javascript");
		$.ajax({
			type : 'POST',
			url : 'DeleteCustomer',
			//dataType : 'JSON',
			data : {
				id : id
			},
			success : function(result) {
				alert('inside delete account success')
				console.log("ajax success1");
				console.log(result.name);
			}
		});
	}
	function validateform(){  
		var name=document.myform.name.value;  
		var email=document.myform.email.value;
		var accountno=document.myform.accountno.value;
		var city=document.myform.city.value;
		  
		if (name==null || name==""){  
		  alert("Name can't be blank");  
		  return false;  
		}
		if (email==null || email==""){  
			  alert("email can't be blank");  
			  return false;  
		}
		if (accountno==null || accountno==""){  
			  alert("accountno can't be blank");  
			  return false;  
		}
		if (city==null || city==""){  
			  alert("city can't be blank");  
			  return false;  
		}
		/* else if(password.length<6){  
		  alert("Password must be at least 6 characters long.");  
		  return false;  
		} */  
	}
</script>
</html>