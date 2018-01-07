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
    <div id="root"></div>
    <script src="https://vk.com/js/api/openapi.js" type="text/javascript"></script>
    <script type="text/javascript">
      <#if user??>
        window.primaryUserData = {
          vkToken: '${accessToken}',
          vkUserId: '${user.vkId}',
          name: '${user.name}',
          id: '${user.id}'
        }
        window.localStorage.setItem('vkToken', primaryUserData.vkToken)
      </#if>
      window.onload = function () {
        VK.init({ apiId: ${vkAppId} })
      }
    </script>
    <#--<#if devMode??>
        <script type="text/javascript" src="http://localhost:3000/static/js/bundle.js"></script>
    <#else>-->
        <script type="text/javascript" src="/static/js/main.4500d526.js"></script>
    <#--</#if>-->

</body>
</html>