<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TABERNA 12</title>
    <!-- iconos -->
    <script src="https://kit.fontawesome.com/f7fb471b65.js" crossorigin="anonymous"></script>
    <!-- fuentes -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito:ital,wght@0,200;0,300;0,400;0,500;0,600;0,700;0,800;1,300&amp;display=swap" rel="stylesheet">
    <!-- favicon -->
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
    <!-- hoja de estilos -->
    <link rel="stylesheet" href="../css/estiloreg.css">



</head>
 
<body class="bodyRegistrarse">
    <header class="headerRegistrarse">
        <a class="anclaLogo" href="../index.html">
            <i class="fa fa-beer" aria-hidden="true"></i>
                <span>TABERNA 12</span>
        </a>
    </header>
    <main id="main" class="main">
        <section data-aos="zoom-in" data-aos-duration="1000" class="seccionRegistrarse">
            <form action="../SvRegistrarse" method="POST">
                <h2 class="tituloRegistrarse">Registro:</h2>
                <div>
                    <input type="text" placeholder="Nombre"  id="nombre" name="nombre">
                    <div class="error-text"></div>
                </div>
                <div>
                    <input type="text" placeholder="Apellido"  id="apellido" name="apellido">
                    <div class="error-text"></div>
                </div>
                <div>
                    <input type="email" placeholder="Email"  id="email" name="email">
                    <div class="error-text"></div>
                </div>
                <div>
                    <input type="password" placeholder="Contraseña"  id="password" name="password">
                    <div class="error-text"></div>
                </div>
                <div>
                    <select name="pais" id="pais">
                        <option value="">País</option>
                        <option value="AR">Argentina</option>
                        <option value="BO">Bolivia</option>
                        <option value="BR">Brasil</option>
                        <option value="CH">Chile</option>
                        <option value="CO">Colombia</option>
                        <option value="EC">Ecuador</option>
                        <option value="PY">Paraguay</option>
                        <option value="PE">Perú</option>
                        <option value="UY">Uruguay</option>
                        <option value="VE">Venezuela</option>
                    </select>
                    <div class="error-text"></div>
                </div>
                <div class="terminos">
                    <input class="check" type="checkbox" id="terminos">
                    <label class="textoCheck" for="terminos">Acepto términos y condiciones</label>
                    <div class="error-text"></div>
                </div>
                <div>
                    <input class="boton" type="submit" value="Registrarse">
                </div>
                <div>
                    <a class="ayuda" href="#">Necesitas ayuda?</a>
                </div>
            </form>
        </section>
    </main>
    <script src="https://unpkg.com/aos@next/dist/aos.js"></script>
    <script>
        AOS.init();
    </script>
   <script src="../pages/validareg.js"></script>
</body>
</html>
