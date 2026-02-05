<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Estadisticas</title>
    <!-- amcharts -->

    <!-- chartdiv1 -->
    <script src="https://cdn.amcharts.com/lib/5/index.js"></script>
    <script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
    <script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
    <!-- chartdiv2 -->
    <script src="https://cdn.amcharts.com/lib/5/percent.js"></script>
    <link rel="stylesheet" type="text/css" href="../css/page.css">
    <link rel="stylesheet" type="text/css" href="../css/amcharts-styles.css">
    <script src="../js/amcharts-script.js" defer></script>
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
            <div class="row justify-content-evently bg-white mt-3 ms-2">
                <div class="col-4 chartdiv me-auto" id="chartdiv1"></div>
                <div class="col-4 chartdiv ms-auto me-auto" id="chartdiv2"></div>
                <div class="col-4 chartdiv ms-auto me-4" id="chartdiv3"></div>
            </div>
            <!--Footer-->
            <footer><s:include value="/User/components/footer.jsp"/></footer>
        </div>
    </div>
</div>
<s:include value="/includes/scripts.jsp"/>
</body>
</html>