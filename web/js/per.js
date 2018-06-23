//$(document).ready(function (){
//    listarPersona();
//});
//function listarPersona(){
//
//    $.get("hc",{"opc":11},function (data) {
//        var x = JSON.parse(data);
//          $("#tablita tbody tr").remove(); 
//        for(var i = 0;i<x.length;i++){
//            $("#tablita").append("<tr><td>"+(i+1)+"</td><td>"+x[i].idpersona+"</td><td>"+x[i].nombres+"</td><td>"+x[i].apellidos+"</td><td>"+x[i].dni+"</td><td>"+x[i].telefono+"</td><td><a href='#' onclick='editar("+x[i].idpersona+");'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='eliminar("+x[i].idpersona+");'><i class='fas fa-trash-alt'></i></a></td></tr>");
//        }
//    });
//
//}
//function editar(x){
//    $("#myModal2").modal('show');
//    //alert("llego editar");
//    $.get("hc",{"opc":14,"idpersona":x},function (data) {
//       var x = JSON.parse(data);
//        $("#edit_idper").val(x.idpersona);
//        $("#edit_nomper").val(x.nombres);
//        $("#edit_apeper").val(x.apellidos);
//        $("#edit_dniper").val(x.dni);
//        $("#edit_telper").val(x.telefono);
//    });
//}
//
//function eliminar(x){
//    //alert("llego eliminar");
//    $.get("hc",{"idpersona":x,"opc":13},function () {
//        listarPersona();
//    });
//}
//
///*function listarRolId(){
//    $.get("hc",{"opc":14},function (data) {
//        alert("ella no te quiere");
//    });
//}*/
//
//$("#crearPer").click(function (){
//    $("#myModal").modal('show');
//    $("#nomper").val("");
//    $("#apeper").val("");
//    $("#dniper").val("");
//    $("#telper").val("");
//    $("#nomper").focus(function(){
//        //if ($("#nomrol").val() != '') {
//            $("span").css("display", "inline").fadeOut(2000);
//        //}
//    });
//});
//
//$("#savePer").click(function (){
//    var nr = $("#nomper").val();
//    var ap = $("#apeper").val();
//    var dni = $("#dniper").val();
//    var tel = $("#telper").val();
//    $.post("hc",{"nombres":nr, "apellidos":ap, "dni":dni, "telefono":tel,"opc":15},function () {
//        listarPersona();
//    });
//    $("#myModal").modal('hide');
//    
//});
//$("#editPer").click(function (){
//    var id = $("#edit_idper").val();
//    var nom = $("#edit_nomper").val();
//    var apell = $("#edit_apeper").val();
//    var dni = $("#edit_dniper").val();
//    var tel = $("#edit_telper").val();
//    $.post("hc",{"idpersona":id,"nombres":nom, "apellidos":apell, "dni":dni, "telefono":tel,"opc":12}, function () {
//        listarPersona();
//    });
//    $("#myModal2").modal('hide');
//});

angular.module('app',[])
.controller('appController',['$scope','$http',function($scope ,$http){
    $(document).ready(function (){
        listarPersona();
    });
    $scope.add=function(){
        $("#nomper").val("");
        $("#apeper").val("");
        $("#dniper").val("");
        $("#telper").val("");
        
        $("#myModal").modal('show');        
    };
    function listarPersona(){
        $http({
            method:'POST',
            url: 'hc',
            data: 'opc=11',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
        .then(function(data) {
            str = JSON.stringify(data);
            xa=JSON.parse(str);
            $scope.personas=xa.data;
        });
    };
    $scope.guardar=function(){
        var nom = $("#nomper").val();
        var ape = $("#apeper").val();
        var dni = $("#dniper").val();
        var tel = $("#telper").val();
        
        $("#myModal").modal('hide');
        $http({
            method:'POST',
            url: 'hc',
            data: 'nombres='+nom+'&apellidos='+ape+'&dni='+dni+'&telefono='+tel+'&opc=15',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        });
        listarPersona();
    };
    $scope.eliminar=function (x){
        $http({
            method:'POST',
            url: 'hc',
            data: 'idpersona='+x+'&opc=13',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
        .then(function(data) {
            listarPersona();
        }); 
    };
    $scope.editar=function(x){
        $http({     
            method:'POST',
            url: 'hc',
            data: 'idpersona='+x+'&opc=14',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
        .then(function(data) {
            str = JSON.stringify(data);
            console.log(str);
            x=JSON.parse(str).data;

            $("#myModal2").modal('show');
            $("#edit_idper").val(x.idpersona);
            $("#edit_nomper").val(x.nombres);
            $("#edit_apeper").val(x.apellidos);
            $("#edit_dniper").val(x.dni);
            $("#edit_telper").val(x.telefono);
        }); 
    };
    $scope.update=function (){
        var idp = $("#edit_idper").val();
        var nom = $("#edit_nomper").val();
        var ape = $("#edit_apeper").val();
        var dni = $("#edit_dniper").val();
        var tel = $("#edit_telper").val();
        $("#myModal2").modal('hide');
        $http({
            method:'POST',
            url: 'hc',
            data: 'idpersona='+idp+'&nombres='+nom+'&apellidos='+ape+'&dni='+dni+'&telefono='+tel+'&opc=12',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (data) {
            listarPersona();
        });
    };
}]);