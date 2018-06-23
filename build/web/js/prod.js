//$(document).ready(function (){
//    listarProducto();
//});
//function listarProducto(){
//    var nom = $("#caja").val();
//    $.get("hc",{"opc":6},function (data) {
//        var x = JSON.parse(data);
//          $("#tabla tbody tr").remove(); 
//        for(var i = 0;i<x.length;i++){
//            $("#tabla").append("<tr><td>"+(i+1)+"</td><td>"+x[i].idprod+"</td><td>"+x[i].nomprod+"</td><td>"+x[i].precio+"</td><td>"+x[i].stock+"</td><td>"+x[i].cod+"</td><td><a href='#' onclick='editarPro("+x[i].idprod+")'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='eliminarPro("+x[i].idprod+")'><i class='fas fa-trash-alt'></i></a></td></tr>");
//        }
//    });
//}
//function editarPro(x){
//    $("#myModal2").modal('show');
//    $.get("hc",{"opc":7,"idprod":x},function (data) {
//       var x = JSON.parse(data);
//        $("#edit_nompro").val(x.nomprod);
//        $("#edit_preciopro").val(x.precio);
//        $("#edit_stockpro").val(x.stock);
//        $("#edit_idPro").val(x.idprod);
//        $("#edit_codigopro").val(x.cod);
//    });
//}
//function eliminarPro(x){
//    
//    $.get("hc",{"idprod":x,"opc":10},function () {
//        listarProducto();
//    });
//}
//
///*function listarRolId(){
//    $.get("hc",{"opc":7},function (data) {
//        alert(data);
//    });
//}*/
//
//$("#crearProducto").click(function (){
//    $("#myModal").modal('show');
//    $("#nompro").val("");
//    $("#precio").val("");
//    $("#stock").val("");
//    $("#codigo").val("");
//    //document.getElementById("nompro").focus();
//    //document.getElementById("precio").focus();
//    //document.getElementById("stock").focus();
//});
//
//$("#savepro").click(function (){
//    //alert("si funciona");
//    var nomp = $("#nompro").val();
//    var pre = $("#precio").val();
//    var stock = $("#stock").val();
//    var codigo = $("#codigo").val();
//    $.post("hc",{"nomprod":nomp, "precio":pre,"stock":stock,"cod":codigo,"opc":8},function () {
//        listarProducto();
//    });
//    $("#myModal").modal('hide');
//    
//});
//$("#editpro").click(function (){
//    var idp = $("#edit_idPro").val();
//    var nomp = $("#edit_nompro").val();
//    var precio = $("#edit_preciopro").val();
//    var stock = $("#edit_stockpro").val();
//    var codigo = $("#edit_codigopro").val();
//    $.post("hc",{"idprod":idp,"nomprod":nomp, "precio":precio,"stock":stock,"cod":codigo,"opc":9}, function () {
//        listarProducto();
//    });
//    $("#myModal2").modal('hide');
//});
//

angular.module('app',[])
.controller('appController',['$scope','$http',function($scope ,$http){
    $(document).ready(function (){
        listarProd();
    });
    $scope.add=function(){
        $("#nompro").val("");
        $("#precio").val("");
        $("#stock").val("");
        $("#codigo").val("");
        $("#myModal").modal('show');        
    };
function listarProd(){
        $http({
            method:'POST',
            url: 'hc',
            data: 'opc=6',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
        .then(function(data) {
            str = JSON.stringify(data);
            xa=JSON.parse(str);
            $scope.produc=xa.data;
        });
    };
    $scope.guardar=function(){
        var nom = $("#nompro").val();
        var pre = $("#precio").val();
        var sto = $("#stock").val();
        var cod = $("#codigo").val();
        $("#myModal").modal('hide');
        $http({
            method:'POST',
            url: 'hc',
            data: 'nomprod='+nom+'&precio='+pre+'&stock='+sto+'&cod='+cod+'&opc=8',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        });
        listarProd();
    };
    $scope.eliminar=function (x){
        $http({
            method:'POST',
            url: 'hc',
            data: 'idprod='+x+'&opc=10',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
        .then(function(data) {
            listarProd();
        }); 
    };
    $scope.editar=function(x){
        $http({     
            method:'POST',
            url: 'hc',
            data: 'idprod='+x+'&opc=7',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
        .then(function(data) {
            str = JSON.stringify(data);
            console.log(str);
            x=JSON.parse(str).data;

            $("#myModal2").modal('show');
            $("#edit_idPro").val(x.idprod);
            $("#edit_nompro").val(x.nomprod);
            $("#edit_preciopro").val(x.precio);
            $("#edit_stockpro").val(x.stock);
            $("#edit_codigopro").val(x.cod);
        }); 
    };
    
        $scope.update=function (){
        var idp = $("#edit_idPro").val();
        var nom = $("#edit_nompro").val();
        var prec = $("#edit_preciopro").val();
        var stk = $("#edit_stockpro").val();
        var cod = $("#edit_codigopro").val();
        $("#myModal2").modal('hide');
        $http({
            method:'POST',
            url: 'hc',
            data: 'idprod='+idp+'&nomprod='+nom+'&precio='+prec+'&stock='+stk+'&cod='+cod+'&opc=9',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        }).then(function (data) {
            listarProd();
        });
    };
    
}]);
