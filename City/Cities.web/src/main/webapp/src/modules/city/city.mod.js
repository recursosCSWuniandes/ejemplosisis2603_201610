// Definición del módulo
(function(ng){
    
    var mod = ng.module("cityModule", ["ui.bootstrap"]);

    // especifica el URL del recurso REST
    mod.constant("cityContext", "http://localhost:8080/Cities.logic/api/cities");

})(window.angular);

