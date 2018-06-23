<%-- 
    Document   : prod
    Created on : 14/05/2018, 02:56:14 PM
    Author     : alum.fial1
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
        <!--Incluir codigo aqui-->
        <div class="container" style="margin-top: 50px;max-width: 500px;">
            <h2>REGISTRO DE PRODUCTOS</h2>
            <hr>
            <button class="btn btn-info" id="crearProducto" style="width: 100px;" ng-click="add()"><i class="fas fa-plus"></i></button>
            <hr>
            <table class="table" id="tabla" >
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">ID</th>
                        <th scope="col">PRODUCTO</th>
                        <th scope="col">PRECIO</th>
                        <th scope="col">STOCK</th>
                        <th scope="col">CODIGO</th>
                        <th scope="col">ACCION</th>
                    </tr>
                </thead>
                <tbody ng-repeat="x in produc">     
                    <tr>
                        <td>{{$index + 1}}</td>
                        <td>{{x.idprod}}</td>
                        <td>{{x.nomprod}}</td>
                        <td>{{x.precio}}</td>
                        <td>{{x.stock}}</td>
                        <td>{{x.cod}}</td>
                        <td ng-click="editar(x.idprod)"><i class="far fa-edit"></i></td>
                        <td ng-click="eliminar(x.idprod)"><i class="far fa-trash-alt"></i></td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!-- Modal PARA REGISTRAR-->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="exampleModalLabel">REGISTRAR PRODUCTO</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Nombre :</label>
                            <input type="text" id="nompro" class="form-control">
                            <br>
                            <label>Precio :</label>
                            <input type="text" id="precio" class="form-control">
                            <br>
                            <label>Stock :</label>
                            <input type="text" id="stock" class="form-control">
                            <label>Codigo :</label>
                            <input type="text" id="codigo" class="form-control">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary" id="savepro" ng-click="guardar()">Guardar Producto</button>
                    </div>
                </div>
            </div>
        </div>
        <!--MODAL PARA EDITAR-->
        <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-sm" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title" id="exampleModalLabel">Editar Producto</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <div class="form-group">
                            <label>Nombre :</label>
                            <input type="text" id="edit_nompro" class="form-control">
                            <input type="hidden" id="edit_idPro" class="form-control">
                            <br>
                            <label>Precio :</label>
                            <input type="text" id="edit_preciopro" class="form-control">
                            <br>
                            <label>Stock :</label>
                            <input type="text" id="edit_stockpro" class="form-control">
                            <label>Codigo :</label>
                            <input type="text" id="edit_codigopro" class="form-control">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
                        <button type="button" class="btn btn-primary" id="editpro" ng-click="update()">Modifiar Producto</button>
                    </div>
                </div>
            </div>
        </div>
        <!--Fin de código aqui-->
        <%@include file="../WEB-INF/template/footerMain.jspf" %>
        <script src="./js/prod.js"></script>
    </body>
</html>
