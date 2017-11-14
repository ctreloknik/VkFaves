<#include "head.ftl">

<style>
    html, body {
        max-height: 100%;
    }
    .mdl-card {
        margin-top: 5%;
        background-color: #009688;
    }
    .demo-card-wide > .mdl-card__title {
        top: 10%;
        color: #fff;
        height: 132px;
        background: url('/static/img/error-page-pic.gif') repeat-x;
    }
    .mdl-card__title > h2 {
        font-weight: 500;
    }
    .mdl-layout-title {
        /*background-color: #009688;*/
        color: #fff;
        margin: 7px;
    }
    .mdl-card__supporting-text, .mdl-card__actions {
        width: 100%;
        background-color: #fff;
    }
</style>
</head>

<body>
<div class="mdl-cell--10-col mdl-cell--1-offset demo-card-wide mdl-card mdl-shadow--2dp">
    <span class="mdl-layout-title">April Board Engine</span>
    <div class="mdl-card__title">
        <h2 class="mdl-card__title-text"><#--${errorName}--></h2>
    </div>
    <div class="mdl-card__supporting-text">
        <p>О ужос! Похоже, что-то пошло не так!</p>
        <p><#--${errorMessage}--></p>
    </div>
    <div class="mdl-card__actions mdl-card--border">
        <a onclick="history.back()" class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">
            Вернуться назад
        </a>
    </div>
</div>

<#include "tail.ftl">