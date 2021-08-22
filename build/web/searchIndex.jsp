<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://bootswatch.com/5/sketchy/bootstrap.min.css">
        <link rel="stylesheet" href="css/Style.css">
        <title>Document</title>
    </head>

    <body>
        
        <nav class="navbar navbar-light bg-light">
        <div class="container-fluid pt-3">
            <a class="navbar-brand">CRUD</a>
            <form action="controller" method="post" class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="search">
                <button class="btn btn-outline-success" type="submit" name="accion" value="Search">Search</button>
            </form>
        </div>
        </nav>
        
        <div class="container">
            <div class="row justify-content-around pt-5">
                <div class="col-8">
                    <div class="text-center m-4">
                        <h3>Productos</h3>
                        <br>
                        <form action="controller" method="post">
                            <div class="row justify-content-center">
                                <div class="col-3 row justify-content-center">
                                    <input type="submit" name="accion" value="Listar" class="btn btn-dark">
                                </div>
                                <div class="col-1">
                                </div>
                                <div class="col-3 row justify-content-center">
                                    <input type="submit" name="accion" value="Nuevo" class="btn btn-primary ">
                                </div>
                            </div>
                        </form>
                    </div>
                    <div>
                        <table class="table">
                            <thead class="table-dark">
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">NOMBRE</th>
                                    <th scope="col">PRECIO</th>
                                    <th scope="col">CATEGORIA</th>
                                    <th scope="col">FECHA EXPIRACION</th>
                                    <th scope="col">ACCION</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="dato" items="${data}">
                                    <tr>
                                        <th scope="row">${dato.id}</th>
                                        <td>${dato.nombre}</td>
                                        <td>${dato.precio}</td>
                                        <td>${dato.categoria}</td>
                                        <td>${dato.fechaExp}</td>
                                        <td>
                                            <form action="controller" method="post">       
                                                <input type="hidden" name="id" value="${dato.getId()}">
                                                <input type="submit" name="accion" value="Edit" class="btn btn-success ">
                                                <input type="submit" name="accion" value="Delete" class="btn btn-danger">                                          
                                            </form> 
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </body>

</html>