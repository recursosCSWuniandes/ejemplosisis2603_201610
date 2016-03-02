
(function(ng){
    
    var mod = ng.module("cityModule", ["ui.bootstrap"]);
    
    mod.constant("cityContext", "http://localhost:8080/Servidor-JAXRS/api/cities/");
    
})(window.angular);

