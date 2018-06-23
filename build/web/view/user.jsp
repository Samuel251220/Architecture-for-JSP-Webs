<%-- 
    Document   : user
    Created on : 14/05/2018, 02:49:21 PM
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
    <body>
        <div ng-app="tablaus" ng-controller="user">
        <%@include file="../WEB-INF/template/headerMainBody.jspf" %>
        <input type="text" id="buscarusuario" class="form-control">
        <hr>
        <button class="btn btn-success"  ng-click="agregar()"><i class="fas fa-plus"></i></button>
        <hr>
        <div  >
            <table class="table" id="tablita" >
            <thead>
                
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Usuario</th>
                    <th scope="col">Nombre</th>
                    <th scope="col">Apellido</th>
                    <th scope="col">Rol</th>
                    <th scope="col" colspan="2">ACCION</th>
                </tr>
                
            </thead>
            <tbody> 
                <tr ng-repeat=" x in usuario">
                    <td>{{ $index + 1 }}</td>
                    <td>{{ x.nom }}</td>
                    <td>{{ x.apell }}</td>
                    <td>{{ x.rol }}</td>
                    <td><a   ng-click="editar(x.idu)"><i class="far fa-edit" ></i></a></td>
                    <td><a   ng-click="eliminar(x.idu)" ><i class="fas fa-trash-alt" ></i></a></td>
                </tr>
            </tbody>
            <h1>{{nombre}}</h1>
        </table>  
        </div>
       
        
   
    <!-- Modal PARA REGISTRAR-->
    <div class="modal fade" id="myModalcrear" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">REGISTRAR USUARIO</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label>Nombre</label>
                        <input type="text" id="rnombre" class="form-control" ng-model="crearnom">
                        <label>Apellido</label>
                        <input type="text" id="rapellido" class="form-control" ng-model="crearapell">
                        <label>DNI</label>
                        <input type="text" id="rdni" class="form-control" ng-model="creardni">
                        <label>Teléfono</label>
                        <input type="text" id="rtelefono" class="form-control" ng-model="creartelefono">
                        <label>Nombre de usuario</label>
                        <input type="text"  class="form-control" ng-model="crearusers" >
                        
                        <label>contraseña</label>
                        <input type="password"  class="form-control" ng-model="crearcontras">
                        <label>Rol</label>
                        <select class="form-control" ng-model="crearrol">
                            <option  ng-repeat=" x in roles">{{x.nomrol}}</option>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="saveusuario" ng-click="saveusuario()">Guardar Usuario</button>
                </div>
            </div>
        </div>
    </div>
    
    <!--MODAL PARA EDITAR-->
    <div class="modal fade" id="myModaleditar" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel"></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <input type="hidden" id="idrol" class="form-control" ng-model="idroles">
                        <input type="hidden" id="idper" class="form-control" ng-model="idper">
                        <label>Nombre</label>
                        <input type="text" id="nombre" class="form-control" ng-model="nom">
                        <label>Apellido</label>
                        <input type="text" id="apellido" class="form-control" ng-model="apell">
                        <label>DNI</label>
                        <input type="text" id="dni" class="form-control" ng-model="dni">
                        <label>Teléfono</label>
                        <input type="text" id="telefono" class="form-control" ng-model="telefono">
                        <label>Nombre de usuario</label>
                        <input type="text"  class="form-control" ng-model="usu">
                        <label>contraseña</label>
                        <input type="password"  class="form-control" ng-model="contr">
                        <label>Rol</label>
                        <input type="text" id="rol" class="form-control" ng-model="rol">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="editarusuario" ng-click="modificar()">Modificar </button>
                </div>
            </div>
        </div>
         </div>
     </div>
        
        
        <%@include file="../WEB-INF/template/footerMain.jspf" %>
        <script src="./js/usu.js"></script>
      
    </body>
</html>
