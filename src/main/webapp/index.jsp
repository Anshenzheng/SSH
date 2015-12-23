<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>"> 
<style>
table{
	margin-top:20px;
	border-collapse: collapse;
    border: 1px solid #888;
}
td{
	padding:5px;
	border: 1px solid #888;
}
th{
	padding:5px;
	border: 1px solid #888;
}

a{
	border: 1px solid #888;
	padding:2px;
	background:#F77406;
	color:#fff;
	text-decoration:none;
	cursor:pointer;
}
a:hover{
	background:#BB5601;
	color:#fff;
	text-decoration:none;
	cursor:pointer;
}
</style>
</head>
<body>
<h2>Hello World!</h2>
<s:property value="message"/>
<table >
	<tr>
		<th>ID</th>
		<th>User Name</th>
		<th>Action</th>
	</tr>
<s:iterator value="users" var="currentUser">
	<tr>
		<td>${currentUser.id} </td>
		<td>${currentUser.userName} </td>
		<td>
			<a  onClick="setValueToForm(${currentUser.id},'${currentUser.userName}','${currentUser.password}')">Update</a>
			<a href="./user/delete.action?id=${currentUser.id}">Delete</a>
		</td>
	</tr>
</s:iterator>
<s:form action="/user/add.action">
	<s:hidden name="user.id"  id="id"/>
	<s:textfield name="user.userName" label="user name" value="" id="userName"/>
	<s:password name="user.password" label="password" value="" id="password"/>
	<s:submit value="Save"/>
</s:form>
</table>

<script>

function setValueToForm(id,userName,password){
	var idElement = document.getElementById("id");
	idElement.value = id;
	
	var userNameElement = document.getElementById("userName");
	userNameElement.value = userName;
	
	var passwordElement = document.getElementById("password");
	passwordElement.value = password;
	
}
</script>
</body>
</html>
