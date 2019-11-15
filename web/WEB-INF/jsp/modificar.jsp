<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-4 col-lg-4">
            <div class="card border-info">
                <div class="card-header bg-info">
                    <h4>Modificar Nuevo Registro</h4>
                </div>
                <div class="card-body">
                    <form method="post">
                        <label>Nombres</label>
                        <input type="text" name="nombre" class="form-control" value="${lista[0].nombre}">
                        <label>Correo</label>
                        <input type="text" name="correo" class="form-control" value="${lista[0].correo}">
                        <label>Nacionalidad</label>
                        <input type="text" name="nacionalidad" class="form-control" value="${lista[0].nacionalidad}">
                        
                        <input type="submit" name="modificar" class="btn btn-success" value="GUARDAR">
                        <a href="index.htm">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
