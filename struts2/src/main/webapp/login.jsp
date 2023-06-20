<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Login</title>
  </head>
  <body>
    <h3>Loginnnnnnnnnnnnnn<> :D</h3>

    <s:form action="login">
      <s:textfield name="username" label="username" />
      <s:password name="password" label="password" />
      <s:submit/>
       <p style="color:red;"> <s:property value="msg" />  </p>
    </s:form>
  </body>
</html>