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
<script src="https://vk.com/js/api/openapi.js?150" type="text/javascript"></script>
<script src="/static/js/vendor/axios.js"></script>
<script type="text/javascript">
    window.onload = function () {
        VK.init({ apiId: ${vkAppId} })
        var parts = window.location.hash.split("&")
        var token = ( parts.find(function (part) {
            return /access_token/.test(part)
        }) || '' ).split("=")[1]
        var userId = ( parts.find(function (part) {
            return /user_id/.test(part)
        }) || '' ).split("=")[1]
        VK.Auth.login(function (response) {
            var user = response.session.user
            axios({
                url: '/api/user/auth',
                method: 'PUT',
                data: JSON.stringify({
                    token: token,
                    vkId: userId,
                    name: user.first_name + ' ' + user.last_name
                }),
                headers: { 'Content-Type': 'application/json' }
            })
            .then(function () {
                window.location.replace('/?accessToken=' + token + '&vkUserId=' + userId)
            })
        }, 2)
    }
</script>
</body>
</html>