//$(document).ready(function (){
//});
//$("#login").click(function (){
//   $("#myModal").modal('show');
//});
//$("#validar").click(function (){
//    var x = $("#user").val();
//    var y = $("#pass").val();
//    $.post("main",{"user":x,"pass":y,"op":1});
//    /*
//    ,function (data) {
//        alert(data);
//       if(data>0){
//           $(location).attr('href', 'http://localhost:9191/v2018/bienvenido');
//       }else{           
//           $(location).attr('href', 'http://localhost:9191/v2018/home');
//       }
//    });*/
//    alert("a");
//   $("#myModal").modal('hide');
//});

angular.module('app',[])
.controller('appController',['$scope','$http',function($scope ,$http){
    $(document).ready(function (){
        listarola();
    });
    $scope.login=function(){
        $("#myModal").modal('show');        
    };
    $scope.validar=function(){
        var x = $("#user").val();
        var y = $("#pass").val();
        $http({
            method:'POST',
            url: 'main',
            data: 'opc=1',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        });
        $("#myModal").modal('hide');
    };
}]);