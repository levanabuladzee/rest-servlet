<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSON</title>
  <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
  <div class="box">
    <form id="get-form">
      <input type="submit" value="GET" class="button">
    </form>
  </div>

  <div class="box">
    <form id="post-form">
      <label for="post-username"></label><input type="text" id="post-username" name="username" placeholder="Username" required>
      <label for="post-password"></label><input type="password" id="post-password" name="password" placeholder="Password" required>
      <input type="submit" value="POST" class="button">
    </form>
  </div>

  <div class="box">
    <form id="put-form">
      <label for="put-id"></label><input type="number" id="put-id" name="id" placeholder="ID">
      <label for="put-username"></label><input type="text" id="put-username" name="username" placeholder="Username" required>
      <label for="put-password"></label><input type="password" id="put-password" name="password" placeholder="Password" required>
      <input type="submit" value="PUT" class="button">
    </form>
  </div>

  <div class="box">
    <form id="delete-form">
      <label for="delete-id"></label><input type="number" id="delete-id" name="id" placeholder="ID" required>
      <input type="submit" value="DELETE" class="button">
    </form>
  </div>

  <script src="script/script.js"></script>
</body>
</html>

