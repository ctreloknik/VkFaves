<#include "head.ftl">

<title>${appName}</title>
</head>
<body>
<div class="demo-layout mdl-layout mdl-js-layout mdl-layout--fixed-drawer mdl-layout--fixed-header">
    <header class="demo-header mdl-layout__header mdl-color--grey-100 mdl-color-text--grey-600">
        <div class="mdl-layout__header-row">
            <span id="board-title" class="mdl-layout-title">Home</span>
            <div class="mdl-layout-spacer"></div>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--expandable">
                <label class="mdl-button mdl-js-button mdl-button--icon" for="search">
                    <i class="material-icons">search</i>
                </label>
                <div class="mdl-textfield__expandable-holder">
                    <input class="mdl-textfield__input" type="text" id="search">
                    <label class="mdl-textfield__label" for="search">Enter your query...</label>
                </div>
            </div>
            <button class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon" id="hdrbtn">
                <i class="material-icons">more_vert</i>
            </button>
            <ul class="mdl-menu mdl-js-menu mdl-js-ripple-effect mdl-menu--bottom-right" for="hdrbtn">
                <li class="mdl-menu__item">About</li>
                <li class="mdl-menu__item">Contact</li>
                <li class="mdl-menu__item">Legal information</li>
            </ul>
        </div>
    </header>
    <div class="demo-drawer mdl-layout__drawer mdl-color--blue-grey-900 mdl-color-text--blue-grey-50">
        <header class="demo-drawer-header">
            <div class="demo-avatar-dropdown">
            <#--<span>%username%</span>-->
                <form action="#">
                    <div class="mdl-textfield mdl-js-textfield">
                        <input class="mdl-textfield__input" type="text" id="username-input">
                        <label class="mdl-textfield__label username-field" for="sample1">%username%</label>
                    </div>
                </form>
                <div class="mdl-layout-spacer"></div>
                <button id="accbtn" class="mdl-button mdl-js-button mdl-js-ripple-effect mdl-button--icon">
                    <i class="material-icons">mode_edit</i>
                    <span class="visuallyhidden">Accounts</span>
                </button>
                <ul class="mdl-menu mdl-menu--bottom-right mdl-js-menu mdl-js-ripple-effect" for="accbtn">
                    <li class="mdl-menu__item">hello@example.com</li>
                    <li class="mdl-menu__item">info@example.com</li>
                    <li class="mdl-menu__item"><i class="material-icons">add</i>Add another account...</li>
                </ul>
            </div>
        </header>
        <nav class="demo-navigation mdl-navigation mdl-color--blue-grey-800">
        <#list boards as board>
            <a class="mdl-navigation__link board-link" data-id="${board.id}" href="#">
                <i class="mdl-color-text--blue-grey-400 material-icons" role="presentation">forum</i>
                <span class="board-name">${board.name}</span>
            </a>
        </#list>
        </nav>
    </div>
    <main class="mdl-layout__content mdl-color--grey-100">
        <div class="mdl-grid">
            <div id="new-entry" class="demo-cards mdl-cell mdl-cell--12-col mdl-grid mdl-grid--no-spacing">
            <#--<div class="demo-separator mdl-cell--8-col"></div>-->
                <div class="demo-options mdl-card mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col">
                    <div class="mdl-card__supporting-text mdl-color-text--blue-grey-50">
                        <div class="mdl-textfield mdl-js-textfield">
                            <textarea class="mdl-textfield__input" type="text" rows= "3" id="new-entry-form" ></textarea>
                            <label class="mdl-textfield__label new-post-text" for="new-entry-form">Текст поста</label>
                        </div>
                    </div>
                    <div class="mdl-card__actions mdl-card--border">
                        <div class="mdl-layout-spacer"></div>
                        <a href="#" id="send-entry" class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored mdl-js-ripple-effect mdl-color--light-green-700 mdl-color-text--white">Отправить</a>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>

<#include "tail.ftl">