// Servicio del módulo City
(function (ng) {

    var mod = ng.module("cityModule");

    // define el servicio cityService
    // - usa $http para invocar un servicio REST
    // - usa cityContext para obtener el URL del recurso
    mod.service("cityService", ["$http", "cityContext", function ($http, context) {

            // estos métodos retornan una promesa
            this.fetchRecords = function () {
                return $http.get(context);
            };

            this.fetchRecord = function (id) {
                return $http.get(context + "/" + id);
            };

            this.saveRecord = function (currentRecord) {
                if (currentRecord.id) {
                    return $http.put(context + "/" + currentRecord.id, currentRecord);
                } else {
                    return $http.post(context, currentRecord);
                }
            };

            this.deleteRecord = function (id) {
                return $http.delete(context + "/" + id);
            };
        }]);
})(window.angular);