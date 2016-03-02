(function (ng) {

    var mod = ng.module("mainApp", [
        "ui.router",
        "cityModule"
    ]);

    mod.config(['$logProvider', function ($logProvider) {
            $logProvider.debugEnabled(true);
        }]);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise("/city");
            $stateProvider
            //En esta sección deben ir los estados que tendrá su aplicación
            //Ejemplo
            //.state(......
                    .state('city', {
                        url: '/city',
                        controller: "cityCtrl",
                        controllerAs: "ctrl",
                        templateUrl: "src/modules/city/city.tpl.html"
                    });
                   
        }]);
})(window.angular);