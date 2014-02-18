$(document).ready(function () {

    var article = $($('article')[0]);
    article.column = 10;
    article.columns = {10: "ten", 13: "thirteen", 16: "sixteen"};

    function reAlignCenter(shrinkOrStrech) {
        var removeClass = article.columns[article.column];
        article.removeClass(removeClass);
        if (shrinkOrStrech === true) {
            article.column = article.column - 3;
        } else {
            article.column = article.column + 3;
        }
        var addClass = article.columns[article.column];
        article.addClass(addClass);
    }
    
    $('.variation .button')
        .on('click', function () {
            $(this)
                .toggleClass('active')
                .siblings()
                .removeClass('active')
            ;
            $('.sidebar').sidebar('toggle')
            ;
        })
    ;
    $('.styled.sidebar').first()
        .sidebar('attach events', '.styled.example .button')
    ;

    $('.floating.sidebar').first()
        .sidebar('attach events', '.floating.example .button')
    ;

    $('#hideLeftMenuButton').click(function () {
        $('#showLeftMenuButton').css('display', 'inline');
        $('nav')[0].style.display = 'none';
        reAlignCenter(false);
    });

    $('#hideRightMenuButton').click(function () {
        $('#showRightMenuButton').css('display', 'inline');
        $('aside')[0].style.display = 'none';
        reAlignCenter(false);
    });

    $('#showLeftMenuButton').click(function () {
        $('nav')[0].style.display = 'inline-block';
        $('#showLeftMenuButton').css('display', 'none');
        reAlignCenter(true);
    });

    $('#showRightMenuButton').click(function () {
        $('aside')[0].style.display = 'inline-block';
        $('#showRightMenuButton').css('display', 'none');
        reAlignCenter(true);
    });

    $('#validate').click(function () {
        var baseController = 'function BaseController() {this.init = function () {console.log("base init");};this.loadView = function (view) {console.log("load view: " + view);};}';
        var currentCode = document.editor.getValue();
        var evalCode = baseController + currentCode;
        var validateButton = $('#validate');
        var validationMessage = $('#validationMessage');
        try {
            eval(evalCode);
            validateButton.addClass("green");
            var validateButtonInterval = setInterval(function () {
                validateButton.removeClass("green");
                clearInterval(validateButtonInterval);
            }, 500);


            validationMessage.css("display", "block");
            validationMessage.addClass("green");
            validationMessage.html("Successful");
            var validationErrorInterval = setInterval(function () {
	        validationMessage.removeClass("green");
	        clearInterval(validationErrorInterval);
	    }, 3000);

        } catch (e) {
            validateButton.addClass("red");
            var validateButtonInterval = setInterval(function () {
                validateButton.removeClass("red");
                clearInterval(validateButtonInterval);
            }, 500);

            validationMessage.css("display", "block");
            validationMessage.addClass("red");
            validationMessage.html("Error: " + e);
            var validationErrorInterval = setInterval(function () {
                validationMessage.removeClass("red");
                clearInterval(validationErrorInterval);
            }, 3000);

        }
    });

    $(function () {
        $(".draggable").each(function () {
            $(this).draggable({
                containment: 'parent'
            });
        });
    });
});
