var BaseController = {
    init: function () {
        console.log('base init');
    },
    loadView: function (view) {
        console.log('load view: ' + view);
    }
};

var mainController = {
    init: function () {
        console.log('main init');
    },
    doSomething: function () {
        console.log('do something');
    }
};
mainController.__proto__ = BaseController;
mainController.init();


// start from here
function BaseController() {
    this.init = function () {
        console.log('base init');
    };
    this.loadView = function (view) {
        console.log('load view: ' + view);
    };
}
function MainController() {
    this.init = function () {
        console.log('main init');
    };
    this.doSomething = function (view) {
        console.log('do something');
    };
}
MainController.prototype = new BaseController();
// to here, predefined

// this is added by the click function
MainController.prototype.doLogin = function () {
    console.log('login!');
};

var mainController = new MainController();



