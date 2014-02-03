$(document).ready(function () {

    // selector cache
    var toggle = $('.ui.toggle.button');
    // alias
    var handler = {

        activate: function () {
            if ($(this).hasClass('active')) {
                $(this).removeClass('active');
            } else {
                $(this).addClass('active');
            }
        }

    };

    toggle.on('click', handler.activate);


});