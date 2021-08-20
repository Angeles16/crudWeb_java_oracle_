<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="https://bootswatch.com/5/sketchy/bootstrap.min.css">
    <link rel="stylesheet" href="css/Style.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <nav class="navbar navbar-light bg-light">
        <div class="container-fluid pt-3">
            <a class="navbar-brand">CRUD</a>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </nav>
    
    <div class="container">
        <div class="row justify-content-center">
           <div class="col-6" >
               <h3 class="text-center pt-5">Formulario Editar Producto</h3><br><br>
               <form action="controller" method="post">
                   ID: <p class="input-group-text">  ${data.getId()} </p>
                   <input type="hidden" name="id" value="${data.getId()}">
                   NOMBRE: <input type="text" class="form-control" name="nombre" value="${data.getNombre()}"><br>
                   PRECIO: <input type="text" class="form-control" name="precio" value="${data.getPrecio()}"><br>
                   CATEGORIA: <input type="text" class="form-control" name="categoria" value="${data.getCategoria()}"><br>
                   FECHA EXPIRACION: <input type="date" class="form-control" name="fechaExp" value="${data.getFechaExp()}"><br>
                   <div class="text-center">
                        <input type="submit" class="btn btn-success px-4" name="accion" value="Update"><br>
                   </div>
                   
               </form>
           </div>
        </div>
    </div>
</body>
</html>