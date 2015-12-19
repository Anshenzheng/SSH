<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<body>
<h2>Login page</h2>
<s:form name="loginForm" action="login.action">
	<s:textfield name="username" label="username"/>
	<s:textfield name="password" label="password"/>
	<s:submit label="submit"></s:submit>
</s:form>
<s:actionerror/>
</body>
</html>
