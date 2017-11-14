/**
 * Утилита для обёртки записей в HTML
 * @type {{wrap}}
 */
var EntryWrapper = (function ($) {
    return {

        wrapObject : function (entry) {
            return $('<div class="board-entry demo-cards mdl-cell mdl-cell--12-col mdl-grid mdl-grid--no-spacing">')
                .append(
                    $('<div class="mdl-card mdl-color--white mdl-shadow--2dp mdl-cell mdl-cell--12-col">')
                        .append(
                            $('<div class="mdl-card__supporting-text">')
                                .append($('<div class="entry-author mdl-textfield mdl-js-textfield">')
                                    .html(entry.author && entry.author.name ? entry.author.name : 'anonymous')
                                )
                                .append('<div class="whatever">' + entry.content + '</div>')
                        /*.append(
                            $('<div class="mdl-card__actions mdl-card--border">').html('// some actions here')
                        )*/

                    )
                );
        }
    }
}(jQuery));