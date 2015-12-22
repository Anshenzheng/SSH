<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
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
<s:iterator value="users" var="user">
	<tr>
		<td>${user.id} </td>
		<td>${user.userName} </td>
		<td>
			<a href="/user/update.action?id=${user.id}">Update</a>
			<a href="/user/delete.action?id=${user.id}">Delete</a>
		</td>
	</tr>
</s:iterator>
<s:form action="/user/add.action">
	<s:textfield name="user.userName" label="user name"/>
	<s:password name="user.password" label="password" />
	<s:submit value="Add"/>
</s:form>
</table>
</body>
</html>
