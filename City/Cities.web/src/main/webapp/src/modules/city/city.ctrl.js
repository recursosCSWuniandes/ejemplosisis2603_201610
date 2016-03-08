// Controlador para el módulo City
(function (ng) {

    var mod = ng.module("cityModule");

    mod.controller("cityCtrl", ["$scope", "cityService", function ($scope, svc) {

            $scope.currentRecord = {};
            $scope.records = [];

            var self = this;

            $scope.today = function () {
                $scope.value = new Date();
            };

            $scope.clear = function () {
                $scope.value = null;
            };

            $scope.open = function ($event) {
                $event.preventDefault();
                $event.stopPropagation();

                $scope.opened = true;
            };

            //Alertas para mensajes que se deseen mostrar
            function responseError(response) {
                self.showError(response.data);
            }

            //Variables para el controlador
            this.readOnly = false;
            this.editMode = false;

            this.changeTab = function (tab) {
                $scope.tab = tab;
            };

            this.createRecord = function () {
                this.editMode = true;
                $scope.currentRecord = {};
            };

            // estos métodos utilizan promesas generadas con $http
            this.editRecord = function (record) {

                // la promesa se usa con la función then y pasando como
                // parámetros dos funciones: una cuando la función retorna
                // sin errores y la otra cuando ocurre una excepción
                //    promesa.then( cuando_OK, cuando_error );
                return svc.fetchRecord(record.id).then(function (response) {
                    $scope.currentRecord = response.data;
                    self.editMode = true;
                    return response;
                }, responseError);

            };

            this.fetchRecords = function () {
                return svc.fetchRecords().then(function (response) {
                    $scope.records = response.data;
                    $scope.currentRecord = {};
                    self.editMode = false;
                    return response;
                }, responseError);
            };

            this.saveRecord = function () {
                return svc.saveRecord($scope.currentRecord).then(function () {
                    self.fetchRecords();
                }, responseError);
            };

            this.deleteRecord = function (record) {
                return svc.deleteRecord(record.id).then(function () {
                    self.fetchRecords();
                }, responseError);
            };

            // al cargar la pantalla en el browser, carga los datos
            this.fetchRecords();

        }]);

})(window.angular);