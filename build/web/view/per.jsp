<%-- 
    Document   : ja
    Created on : 14/05/2018, 02:06:56 PM
    Author     : SamuelMauricio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="../WEB-INF/template/headerMain.jspf" %>
    </head>
    <body ng-app="app" ng-controller="appController">
        <%@include file="../WEB-INF/template/headerMainBody.jspf" %>
        <h3>REGISTRO DE PERSONAS</h3>
        <hr>
        <button class="btn btn-success" id="crearPer" ng-click="add()"><i class="fas fa-plus"></i></button>
        <hr>
        <table class="table" id="tablita">
            <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">ID</th>
                    <th scope="col">NOMBRE</th>
                    <th scope="col">APELLIDOS</th>
                    <th scope="col">DNI</th>
                    <th scope="col">TELEFONO</th>
                    <th scope="col" colspan="2">ACCION</th>
                </tr>
            </thead>
            <tbody ng-repeat="x in personas">
                <tr>
                    <td>{{$index + 1}}</td>
                    <td>{{x.idpersona}}</td>
                    <td>{{x.nombres}}</td>
                    <td>{{x.apellidos}}</td>
                    <td>{{x.dni}}</td>
                    <td>{{x.telefono}}</td>
                    <td ng-click="editar(x.idpersona)"><i class="far fa-edit"></i></td>
                    <td ng-click="eliminar(x.idpersona)"><i class="far fa-trash-alt"></i></td>
                </tr>
            </tbody>
        </table>
    </div>
    <!-- Modal PARA REGISTRAR-->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">REGISTRAR PERSONA</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Nombre:</label>
                        <input type="text" id="nomper" class="form-control">
                        <label>Apellidos:</label>
                        <input type="text" id="apeper" class="form-control">
                        <label>DNI:</label>
                        <input type="text" id="dniper" class="form-control">
                        <label>Telefono:</label>
                        <input type="text" id="telper" class="form-control">
                        <span>Llenar todos los campos</span>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="savePer" ng-click="guardar()">Save Persona</button>
                </div>
            </div>
        </div>
    </div>
    <!--MODAL PARA EDITAR-->
    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel"dal title>Editar Persona</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Nombre:</label>
                        <input type="text" id="edit_nomper" class="form-control">
                        <label>Apellido:</label>
                        <input type="text" id="edit_apeper" class="form-control">
                        <label>DNI:</label>
                        <input type="text" id="edit_dniper" class="form-control">
                        <label>Telefono:</label>
                        <input type="text" id="edit_telper" class="form-control">
                        <input type="hidden" id="edit_idper" class="form-control">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="editPer" ng-click="update()">Modificar Persona</button>
                </div>
            </div>
        </div>
        <%@include file="../WEB-INF/template/footerMain.jspf" %>
        <script src="./js/per.js"></script>
    </body>
</html>
