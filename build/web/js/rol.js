//$(document).ready(function (){
//    listarRol();
//});
//function listarRol(){
//    var nom = $("#caja").val();
//    $.get("hc",{"opc":1},function (data) {
//        var x = JSON.parse(data);
//          $("#tablita tbody tr").remove(); 
//        for(var i = 0;i<x.length;i++){
//            $("#tablita").append("<tr><td>"+(i+1)+"</td><td>"+x[i].idr+"</td><td>"+x[i].nomrol+"</td><td><a href='#' onclick='editar("+x[i].idr+")'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='eliminar("+x[i].idr+")'><i class='fas fa-trash-alt'></i></a></td></tr>");
//        }
//    });
//
//}
//function editar(x){
//    $.get("hc",{"opc":2,"id":x},function (data) {
//       var x = JSON.parse(data);
//        $("#edit_nomrol").val(x.nomrol);
//        $("#edit_idrol").val(x.idr);
//    });
//    $("#myModal2").modal('show');
//}
//function eliminar(x){
//    
//    $.get("hc",{"id":x,"opc":5},function () {
//        listarRol();
//    });
//}
//function listarRolId(){
//    $.get("hc",{"opc":2},function (data) {
//        alert(data);
//    });
//}
//$("#crearRol").click(function (){
//    $("#nomrol").val("");
//    document.getElementById("nomrol").focus();
//    $("#myModal").modal('show');
//    
//});
//
//$("#saverol").click(function (){
//    var nr = $("#nomrol").val();
//    $.post("hc",{"nombrerol":nr,"opc":3},function () {
//        listarRol();
//    });
//    $("#myModal").modal('hide');
//    
//});
//$("#editrol").click(function (){
//    var id = $("#edit_idrol").val();
//    var nomrol = $("#edit_nomrol").val();
//    $.post("hc",{"id":id,"nomrol":nomrol,"opc":4}, function () {
//        listarRol();
//    });
//    $("#myModal2").modal('hide');
//});

angular.module('app',[])
.controller('appController',['$scope','$http',function($scope ,$http){
    $(document).ready(function (){
        listarola();
    });
    $scope.add=function(){
        $("#nomrol").val("");
        $("#myModal").modal('show');        
    };
function listarola(){
        $http({
            method:'POST',
            url: 'hc',
            data: 'opc=1',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
        .then(function(data) {
            str = JSON.stringify(data);
            xa=JSON.parse(str);
            $scope.rol=xa.data;
        });
    };
    $scope.guardar=function(){

        var r = $("#nomrol").val();
        $("#myModal").modal('hide');
        $http({
            method:'POST',
            url: 'hc',
            data: 'nombrerol='+r+'&opc=3',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        });
        listarola();
    };
    $scope.eliminar=function (x){
        $http({
            method:'POST',
            url: 'hc',
            data: 'id='+x+'&opc=5',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
        .then(function(data) {
            listarola();
        }); 
    };
    $scope.editar=function(x){
        $http({     
            method:'POST',
            url: 'hc',
            data: 'id='+x+'&opc=2',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
        .then(function(data) {

            str = JSON.stringify(data);
            console.log(str);
            x=JSON.parse(str).data;

       
            
            $("#myModal2").modal('show');
            $("#edit_idrol").val(x.idr);
            $("#edit_nomrol").val(x.nomrol);

        }); 
    };
        $scope.update=function (){

        $("#myModal2").modal('hide');

        var a=$("#edit_idrol").val();
        var b=$("#edit_nomrol").val();

        $http({
            method:'POST',
                url: 'hc',
                data: 'id='+a+'&nomrol='+b+'&opc=4',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}

        }).then(function (data) {

            listarola();

        });

    };
    
    
    }]);
