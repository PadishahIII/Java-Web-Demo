<html>
<body>
<h2>Hello :
<% String username = (String) request.getAttribute("username"); %>
<% if (username != null) { %>
<p style="color:green;"> <%= username %> </p>
<% } %>
</h2>
</body>
</html>
