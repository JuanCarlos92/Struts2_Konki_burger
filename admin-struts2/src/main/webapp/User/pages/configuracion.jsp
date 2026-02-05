<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Configuracion</title>
    <!-- Funcionalidad y estilos personalizados -->
    <link rel="stylesheet" type="text/css" href="../css/page.css">
</head>
<body class="bg-primary-subtle">
<div class="container-fluid">
    <div class="row">
        <!--Menu lateral-->
        <s:include value="/User/components/menu-lateral.jsp"/>
        <!--Contenido-->
        <div class="col-8 col-md-9 col-lg-10 contenido">
            <!--Header-->
            <s:include value="/User/components/header.jsp"/>
            <!--Main-->
            <div class="row bg-white mt-3 ms-2">
                <div class="col-12">
                    <h1 class="h1">In the next version, this section will be available...</h1>
                </div>
            </div>
            <!--Footer-->
            <footer><s:include value="/User/components/footer.jsp"/></footer>
        </div>
    </div>
</div>
<s:include value="/includes/scripts.jsp"/>
</body>
</html>