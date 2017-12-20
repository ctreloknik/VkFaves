<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <meta name="theme-color" content="#000000">
    <title>VK Favorites</title>
    <link href="/static/css/main.80249939.css" rel="stylesheet">
</head>
<body>
<h2>Пожалуйста, подождите</h2>
<script src="/static/js/vendor/axios.js"></script>
<script type="text/javascript">
  var parts = window.location.hash.split("&")
  var token = ( parts.find(function (part) {
      return /access_token/.test(part)
  }) || '' ).split("=")[1]
  var userId = ( parts.find(function (part) {
    return /user_id/.test(part)
  }) || '' ).split("=")[1]
  axios({
    url: '/api/auth',
    params: { accessToken: token, userId: userId }
  }).then(() => window.location.replace('/'))
</script>
</body>
</html>