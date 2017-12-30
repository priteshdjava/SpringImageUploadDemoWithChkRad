<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-1.10.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"
	 />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/customer.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery-form-validator/2.1.47/jquery.form-validator.min.js"></script>
</head>
<body>
			<form:form modelAttribute="form" id="myform">
					<table>
						<tr>
							<td><form:label path="bId"></form:label></td>
							<td><form:input path="bId" readonly="true" type="hidden"></form:input></td>
						</tr>
						<tr>
							<td><form:label path="bName">Cutomer Name</form:label></td>
							<td><form:input path="bName" /></td>
						</tr>
						<tr>
							<td><form:label  path="bGender" >Cutomer Gender</form:label></td>
							<td><form:radiobutton path="bGender" value="Male" label="Male" />
									<form:radiobutton path="bGender" value="Female" label="Female"  /></td>
						</tr>
						<tr>
							<td><form:label path="bDocument">Cutomer Document</form:label></td>
							<td>		<form:checkbox path="bDocument" value="Aadhar Card"  label="Aadhar Card"></form:checkbox>
											<form:checkbox path="bDocument" value="PAN Card" label="PAN Card" ></form:checkbox>
											<form:checkbox path="bDocument" value="Election Card"  label="Election Card"></form:checkbox></td>
						</tr>
						<tr>
							<td><form:label path="bAdd">Comment</form:label></td>
							<td><form:textarea path="bAdd" rows="5" cols="40"></form:textarea></td>
						</tr>
						<tr>
									<td align="center" colspan="2"><input type="button" id="button" value="save" onclick="customerinfo.save()"></td>
						</tr>
					</table>
			</form:form>

</body>
</html>