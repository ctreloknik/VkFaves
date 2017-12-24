<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
    <meta name="theme-color" content="#000000">
    <link rel="manifest" href="/manifest.json">
    <link rel="shortcut icon" href="/favicon.ico">
    <title>VK Favorites</title>
    <link href="/static/css/main.80249939.css" rel="stylesheet">
</head>
<body>
    <noscript>You need to enable JavaScript to run this app.</noscript>
    <div id="root"></div>
    <script src="https://vk.com/js/api/openapi.js" type="text/javascript"></script>
    <script type="text/javascript">
      <#if user??>
        window.primaryUserData = {
          vkToken:  '${user.token}',
          vkUserId: '${user.vkId}',
          name: '${user.name}'
          id: '${user.id}'
        }
      </#if>
      window.onload = function () {
        VK.init({ apiId: ${vkAppId} })
      }
    </script>
    <script type="text/javascript" src="/static/js/main.8efcb4ce.js"></script>
</body>
</html>