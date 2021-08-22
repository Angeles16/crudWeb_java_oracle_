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
            <a href="#" >CRUD</a>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </nav>
    
    <div class="container">
        <div class="row justify-content-center">
           <div class="col-6" >
               <h3 class="text-center pt-5">Formulario ingreso de productos</h3><br><br>
               <form action="controller" method="post">
                   NOMBRE: <input type="text" class="form-control" name="nombre"><br>
                   PRECIO: <input type="text" class="form-control" name="precio"><br>
                   CATEGORIA: <input type="text" class="form-control" name="categoria"><br>
                   FECHA EXPIRACION: <input type="date" class="form-control" name="fechaExp"><br>
                   <div class="text-center">
                        <input type="submit" class="btn btn-success px-4" name="accion" value="Guardar"><br>
                   </div>
                   
               </form>
           </div>
        </div>
    </div>
</body>
</html>