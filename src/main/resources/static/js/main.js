$(function () {
    "use strict";
    var userName,
        boardName,
        boardId;

    userName = localStorage.getItem("username");
    $('.username-field').html(userName);
    var username = localStorage.getItem("username");
    if (username) {
        $('.username-field').html(username);
    }

    $('#username-input').change(function () {
        localStorage.setItem("username", $(this).val());
    })

    boardId = localStorage.getItem("boardId");
    boardName = localStorage.getItem("boardName");
    if (boardName) {
        $('#board-title').html(boardName);
    }
    $('.board-link').click(function () {
        boardName = $(this).find('.board-name').html();
        localStorage.setItem("boardId", $(this).data('id'));
        localStorage.setItem("boardName", boardName);
        $('#board-title').html(boardName);
        $.get("/board/" + boardId + '/0', function (response) {
            if (!response.errorMessage && response.data && response.data.length) {

            } else {
                // TODO: должна быть какая-то обработка сообщений об ошибке, возможно через ajaxPrefilter
            }
        })
    });

    $('#send-entry').click(function () {
        var newEntry = {
            authorId: localStorage.getItem("aId"),
            author: localStorage.getItem("username"),
            boardId: 2,
            content: $('#new-entry-form').val(),
            date: moment().unix()
        }
        var successCallback = function () {
            console.debug('YEAAH');
        }
        RestClient.postNewEntry(newEntry, successCallback)
    });
})