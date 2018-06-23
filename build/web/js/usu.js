var app = angular.module('tablaus', []);
app.controller('user', ['$scope', '$http', function ($scope, $http) {
        $scope.nombre = "hola";
        
        $(document).ready(function () {
            listarUsuario();

        });
        function listarUsuario() {
            var opcion = 'opc=1';
            $http({
                method: 'POST',
                url: 'usc',
                data: opcion,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).then(function (scope) {

                var x = JSON.stringify(scope);
                var y = JSON.parse(x);
                $scope.usuario = y.data;

            });
        }
        $scope.editar = function (x) {
            $("#myModaleditar").modal('show');
            var opcion = 'opc=2' + '&id=' + x;
            $http({
                method: 'POST',
                url: 'usc',
                data: opcion,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).then(function (data) {
                var x = JSON.stringify(data);
                var y = JSON.parse(x);
                console.log(y);
                $scope.usu = y.data.nom_user;
                $scope.contr = y.data.clave;
                $scope.idroles = y.data.idrol;
                $scope.idper = y.data.idpersona;

                var percontrol = 'opc=4' + '&id=' + y.data.idpersona;
                $http({
                    method: 'POST',
                    url: 'persona',
                    data: percontrol,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).then(function (data) {
                    var x = JSON.stringify(data);
                    var y = JSON.parse(x);
                    console.log(y);
                    $scope.nom = y.data.nombres;
                    $scope.apell = y.data.apellidos;
                    $scope.dni = y.data.dni;
                    $scope.telefono = y.data.telefono;
                });
                var rolcontrol = "opc=6" + "&idrol=" + y.data.idrol;
                $http({
                    method: 'POST',
                    url: 'persona',
                    data: rolcontrol,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).then(function (data) {
                    var x = JSON.stringify(data);
                    var y = JSON.parse(x);
                    $scope.rol = y.data.nomrol;
                });

            });
            $scope.modificar = function () {
                //"opc":4,"erol":idrole,"eidper":idper,"enom":n,"eappe":a,"edni":d,"etel":t,"eusu":u,"econtra":c
                var opcion = 'opc=4' + '&erol=' + $scope.idroles + '&eidper=' + $scope.idper + '&enom=' + $scope.nom + '&eappe=' + $scope.apell
                        + '&edni=' + $scope.dni + '&etel=' + $scope.telefono + '&eusu=' + $scope.usu + '&econtra=' + $scope.contr;


                $http({
                    method: 'POST',
                    url: 'usc',
                    data: opcion,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).then(function () {
                    listarUsuario();
                    $("#myModaleditar").modal('hide');
                });
            };

        };
        $scope.eliminar = function (x) {


            var opcion = 'opc=5' + "&idusu=" + x;
            $http({
                method: 'POST',
                url: 'usc',
                data: opcion,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).then(function () {
                alert("borrado exitoso");
                listarUsuario();

            });

        };
        $scope.agregar = function () {
            $("#myModalcrear").modal('show');
            var opcion = 'opc=1';

            $scope.crearusers = "";
            $scope.crearcontras = "";
            $http({
                method: 'POST',
                url: 'hc',
                data: opcion,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).then(function (data) {

                var x = JSON.stringify(data);
                var y = JSON.parse(x);
                $scope.roles = y.data;

            });
        };
        $scope.saveusuario = function () {
            var opcion = 'opc=2' + "&nomPer=" + $scope.crearnom + "&apePer=" + $scope.crearapell + "&dniPer=" + $scope.creardni + "&telPer=" + $scope.creartelefono;
            alert(opcion);
            $http({
                method: 'POST',
                url: 'persona',
                data: opcion,
                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
            }).then(function (data) {
                var opcion = 'opc=1';
                $http({//htttp para rol
                    method: 'POST',
                    url: 'hc',
                    data: opcion,
                    headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                }).then(function (data) {
                    var x = JSON.stringify(data);
                    var y = JSON.parse(x);
                    console.log("rolesss:");
                    console.log(y);
                    console.log(y.data.length);
                    console.log("crearrol:" + $scope.crearrol);

                    for (var i = 0; i < y.data.length; i++) {

                        if ($scope.crearrol === y.data[i].nomrol) {
                            console.log("idrol rol:" + y.data[i].idr);
                            var iddelrol = y.data[i].idr;
                            var opc = 'opc=1';
                            $http({//http para persona
                                method: 'POST',
                                url: 'persona',
                                data: opc,
                                headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                            }).then(function (data) {
                                var t = JSON.stringify(data);
                                var z = JSON.parse(t);
                                console.log("personas:");
                                console.log(z);
                                console.log("tamaño personas" + z.data.length);
                                for (var j = 0; j < z.data.length; j++) {
                                    if ($scope.crearnom === z.data[j].nombres && $scope.crearapell === z.data[j].apellidos) {

                                        opcion = 'opc=3' + '&crol=' + iddelrol + '&cper=' + z.data[j].idpersona + '&cusuario=' + $scope.crearusers + '&ccontrasena=' + $scope.crearcontras;

                                        alert(opcion);
                                        $http({
                                            method: 'POST',
                                            url: 'usc',
                                            data: opcion,
                                            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
                                        }).then(function (data) {

                                            listarUsuario();
                                            $("#myModalcrear").modal('hide');
                                        });
                                    }
                                }
                            });
                        }
                    }
                });
            });

        };
    }]); 