//chartdiv1
let porcentajeMujerMasTreinta = 0;
let porcentajeMujerMenosTreinta = 0;
let porcentajeHombreMasTreinta = 0;
let porcentajeHombreMenosTreinta = 0;
//chartdiv2
let porcentajeMujer = 0;
let porcentajeHombre = 0;
let peloStraightMujer = 0;
let peloCurlyMujer = 0;
let peloWavyMujer = 0;
			
let peloCurlyHombre = 0;
let peloWavyHombre = 0;
let peloStraightHombre = 0;
let peloKinkyMujer = 0;
//chartdiv3
let abplus = 0;
let abless = 0;
let aplus = 0;
let aless = 0;
let bplus = 0;
let bless = 0;
let oplus = 0;
let oless = 0;

let data1 = [];
let data2 = [];
let data3 = [];
let data4 = [];
let data5 = [];
let data6 = [];
let data7 = [];
let data8 = [];

$(document).ready(function(){
	$.ajax({
		type:'GET',
		dataType:'json',
		url:'https://dummyjson.com/users',
		success:function(data){
			let users = data.users;
			//START CHARTDIV1----------------------------------------------------------------------------------------------
			
			am5.ready(function() {

			// Create root element
			// https://www.amcharts.com/docs/v5/getting-started/#Root_element
			var root = am5.Root.new("chartdiv1");
			
			// Disable amCharts logo
			root._logo.dispose();  // Esta línea elimina el logotipo

			// Set themes
			// https://www.amcharts.com/docs/v5/concepts/themes/
			root.setThemes([
			  am5themes_Animated.new(root)
			]);

			// Create chart
			// https://www.amcharts.com/docs/v5/charts/xy-chart/
			var chart = root.container.children.push(am5xy.XYChart.new(root, {
			  panX: true,
			  panY: false,
			  wheelX: "panX",
			  wheelY: "zoomX",
			  paddingLeft: 0,
			  layout: root.verticalLayout
			}));
			
			//calculo de los datos
			asignarValoresChartdiv1(users);

			var data = [{
			  "country": "Mayores de 30",
			  "year2004": porcentajeMujerMasTreinta,
			  "year2005": porcentajeHombreMasTreinta
			}, {
			  "country": "Menores de 30",
			  "year2004": porcentajeMujerMenosTreinta,
			  "year2005": porcentajeHombreMenosTreinta
			}];

			// Create axes
			// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
			var xRenderer = am5xy.AxisRendererX.new(root, {
			  minGridDistance: 70,
			  minorGridEnabled: true
			});

			var xAxis = chart.xAxes.push(am5xy.CategoryAxis.new(root, {
			  categoryField: "country",
			  renderer: xRenderer,
			  tooltip: am5.Tooltip.new(root, {
			    themeTags: ["axis"],
			    animationDuration: 200
			  })
			}));

			xRenderer.grid.template.setAll({
			  location: 1
			})

			xAxis.data.setAll(data);

			var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
			  min: 0,
			  renderer: am5xy.AxisRendererY.new(root, {
			    strokeOpacity: 0.1
			  }),
			  numberFormat: "#%"
			}));

			// Add series
			// https://www.amcharts.com/docs/v5/charts/xy-chart/series/

			var series0 = chart.series.push(am5xy.ColumnSeries.new(root, {
			  name: "Mujer",
			  xAxis: xAxis,
			  yAxis: yAxis,
			  valueYField: "year2004",
			  categoryXField: "country",
			  clustered: false,
			  tooltip: am5.Tooltip.new(root, {
			    labelText: "Mujer: {valueY.formatNumber('#.0%')}"
			  })
			}));

			series0.columns.template.setAll({
			  width: am5.percent(80),
			  tooltipY: 0,
			  strokeOpacity: 0,
			  fill: am5.color(0xFF5DA8),
			  fillOpacity: 0.7//reducción de opacidad
			});


			series0.data.setAll(data);


			var series1 = chart.series.push(am5xy.ColumnSeries.new(root, {
			  name: "Hombre",
			  xAxis: xAxis,
			  yAxis: yAxis,
			  valueYField: "year2005",
			  categoryXField: "country",
			  clustered: false,
			  tooltip: am5.Tooltip.new(root, {
			    labelText: "Hombre: {valueY.formatNumber('#.0%')}"
			  })
			}));

			series1.columns.template.setAll({
			  width: am5.percent(50),
			  tooltipY: 0,
			  strokeOpacity: 0,
			  fill: am5.color(0x0D6EFD),
			  fillOpacity: 0.7 //reduccion de opacidad
			});

			series1.data.setAll(data);

			var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {}));

			// Make stuff animate on load
			// https://www.amcharts.com/docs/v5/concepts/animations/
			chart.appear(1000, 100);
			series0.appear();
			series1.appear();

			}); // end am5.ready()
			
			//END CHARTDIV1----------------------------------------------------------------------------------------------------
			//START CHARTDIV2---------------------------------------------------------------------------------------------------
			
			am5.ready(function() {

			// Create root and chart
			var root = am5.Root.new("chartdiv2");

			// Disable amCharts logo
			root._logo.dispose();  // Esta línea elimina el logotipo

			root.setThemes([
			  am5themes_Animated.new(root)
			]);

			var chart = root.container.children.push( 
			  am5percent.PieChart.new(root, {
			    layout: root.verticalLayout
			  }) 
			);

			// Create series
			var series = chart.series.push(
			  am5percent.PieSeries.new(root, {
			    valueField: "percent",
			    categoryField: "type",
			    fillField: "color",
			    alignLabels: false
			  })
			);
			
			// Desactivar las etiquetas
			series.labels.template.set("visible", false);
			series.ticks.template.set("visible", false);  // Quitar las líneas

			series.slices.template.set("templateField", "sliceSettings");
			series.labels.template.set("radius", 30);

			// Set up click events
			series.slices.template.events.on("click", function(event) {
			  console.log(event.target.dataItem.dataContext)
			  if (event.target.dataItem.dataContext.id != undefined) {
			    selected = event.target.dataItem.dataContext.id;
			  } else {
			    selected = undefined;
			  }
			  series.data.setAll(generateChartData());
			});
			
			//cálculo de los datos			
			asignarValoresChartdiv2(users)
			
			// Define data
			var selected;
			var types = [{
			  type: "Mujer",
			  percent: porcentajeMujer,
			  color: series.get("colors").set("color", am5.color(0xFF5DA8)),
			  subs: [{
			    type: "Straight",
			    percent: peloStraightMujer
			  }, {
			    type: "Curly",
			    percent: peloCurlyMujer
			  }, {
			    type: "Wavy",
			    percent: peloWavyMujer
			  }, {
				type: "Kinky",
				percent: peloKinkyMujer
				 }]
			}, {
			  type: "Hombre",
			  percent: porcentajeHombre,
			  color: series.get("colors").set("color", am5.color(0x0D6EFD)),
			  subs: [{
			    type: "Curly",
			    percent: peloCurlyHombre
			  }, {
			    type: "Wavy",
			    percent: peloWavyHombre
			  }, {
			    type: "Straight",
			    percent: peloStraightHombre
			  }]
			}];
			series.data.setAll(generateChartData());


			function generateChartData() {
			  var chartData = [];
			  for (var i = 0; i < types.length; i++) {
			    if (i == selected) {
			      for (var x = 0; x < types[i].subs.length; x++) {
			        chartData.push({
			          type: types[i].subs[x].type,
			          percent: types[i].subs[x].percent,
			          color: types[i].color,
			          pulled: true,
			          sliceSettings: {
			            active: true
			          }
			        });
			      }
			    } else {
			      chartData.push({
			        type: types[i].type,
			        percent: types[i].percent,
			        color: types[i].color,
			        id: i
			      });
			    }
			  }
			  return chartData;
			}
			
			//leyenda
			var legend = chart.children.push(am5.Legend.new(root, {
			  nameField: "name",
			  fillField: "color",
			  strokeField: "color",
			  centerX: am5.percent(50),
			  x: am5.percent(50)
			}));

			legend.data.setAll([{
			  name: "Mujer",
			  color: am5.color(0xFF5DA8)
			}, {
			  name: "Hombre",
			  color: am5.color(0x0D6EFD)
			}]);

			}); // end am5.ready()
			
			//END CHARTDIV2----------------------------------------------------------------------------------------------------
			//START CHARTDIV3---------------------------------------------------------------------------------------------------
			
			am5.ready(function() {

			// Create root element
			// https://www.amcharts.com/docs/v5/getting-started/#Root_element
			var root = am5.Root.new("chartdiv3");
			
			// Disable amCharts logo
			root._logo.dispose();  // Esta línea elimina el logotipo


			// Set themes
			// https://www.amcharts.com/docs/v5/concepts/themes/
			root.setThemes([
			  am5themes_Animated.new(root)
			]);


			// Create chart
			// https://www.amcharts.com/docs/v5/charts/xy-chart/
			var chart = root.container.children.push(am5xy.XYChart.new(root, {
			  panX: false,
			  panY: false,
			  wheelX: "panX",
			  wheelY: "zoomX",
			  layout: root.verticalLayout,
			  paddingLeft:5,
			  paddingRight:5
			}));


			// Add legend
			// https://www.amcharts.com/docs/v5/charts/xy-chart/legend-xy-series/
			var legend = chart.children.push(
			  am5.Legend.new(root, {
			    centerX: am5.p50,
			    x: am5.p50
			  })
			);

			// Create axes
			// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
			var xRenderer = am5xy.AxisRendererX.new(root, {
			  strokeOpacity: 0.1,
			  minGridDistance: 40,
			  minorGridEnabled:true
			});
			var xAxis = chart.xAxes.push(am5xy.CategoryAxis.new(root, {
			  categoryField: "x",
			  renderer: xRenderer
			}));

			xRenderer.grid.template.setAll({
			  location: 1
			})

			xRenderer.labels.template.set("forceHidden", true);

			xAxis.data.setAll([{ x: "1" }, { x: "2" }, { x: "3" }, { x: "4" }, { x: "5" }, { x: "6" }, { x: "7" }, { x: "8" }, { x: "9" }, { x: "10" }]);

			var yRenderer = am5xy.AxisRendererY.new(root, {
			  strokeOpacity: 0.1,
			  minGridDistance: 20,
			  minorGridEnabled:true
			});

			var yAxis = chart.yAxes.push(am5xy.CategoryAxis.new(root, {
			  categoryField: "y",
			  renderer: yRenderer
			}));

			yRenderer.grid.template.setAll({
			  location: 1
			})

			yRenderer.labels.template.set("forceHidden", true);

			yAxis.data.setAll([{ y: "1" }, { y: "2" }, { y: "3" }, { y: "4" }, { y: "5" }, { y: "6" }, { y: "7" }, { y: "8" }, { y: "9" }, { y: "10" }]);


			// Add series
			// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
			function makeSeries(name) {
			  var series = chart.series.push(am5xy.ColumnSeries.new(root, {
			    name: name,
			    xAxis: xAxis,
			    yAxis: yAxis,
			    categoryYField: "y",
			    openCategoryYField: "y",
			    categoryXField: "x",
			    openCategoryXField: "x",
			    clustered: false
			  }));

			  series.columns.template.setAll({
			    width: am5.percent(100),
			    height: am5.percent(100),
			    stroke: am5.color(0xffffff),
			  });

			  series.appear();
			  legend.data.push(series);

			  return series;
			}
			
			//cálculo de los datos
			asignarValoresChartdiv3(users);
			
			var series1 = makeSeries("AB+");
			series1.data.setAll(data1);
						
			series1.columns.template.setAll({fill: am5.color(0xFF0000)})

			var series2 = makeSeries("AB-");
			series2.data.setAll(data2);
			
			series2.columns.template.setAll({fill: am5.color(0xDB0000)})

			var series3 = makeSeries("A+");
			series3.data.setAll(data3);
			
			series3.columns.template.setAll({fill: am5.color(0xB80000)})
			
			var series4 = makeSeries("A-");
			series4.data.setAll(data4);
			
			series4.columns.template.setAll({fill: am5.color(0x960000)})
			
			var series5 = makeSeries("B+");
			series5.data.setAll(data5);
			
			series5.columns.template.setAll({fill: am5.color(0x760000)})
						
			var series6 = makeSeries("B-");
			series6.data.setAll(data6);
			
			series6.columns.template.setAll({fill: am5.color(0x5E0000)})

			var series7 = makeSeries("O+");
			series7.data.setAll(data7);
			
			series7.columns.template.setAll({fill: am5.color(0x281713)})
						
			var series8 = makeSeries("O-");
			series8.data.setAll(data8);
			
			series8.columns.template.setAll({fill: am5.color(0x000000)})


			// Make stuff animate on load
			// https://www.amcharts.com/docs/v5/concepts/animations/
			chart.appear(1000, 100);

			}); // end am5.ready()
		}
	});
});

function asignarValoresChartdiv1(users){
	for(let user of users){
		if(user.gender==="female"&&user.age>=30){
			porcentajeMujerMasTreinta++;
		}else if(user.gender==="female"&&user.age<30){
			porcentajeMujerMenosTreinta++;
		}else if(user.gender==="male"&&user.age>=30){
			porcentajeHombreMasTreinta++;
		}else if(user.gender==="male"&&user.age<30){
			porcentajeHombreMenosTreinta++;
		}
	}
				
	porcentajeMujerMasTreinta /= users.length;
	porcentajeMujerMenosTreinta /= users.length;
	porcentajeHombreMasTreinta /= users.length;
	porcentajeHombreMenosTreinta /= users.length;
}

function asignarValoresChartdiv2(users){
	for(let user of users){
		if(user.gender==="female"){
			porcentajeMujer++;
		}
	}
	
	porcentajeMujer /= users.length;
	porcentajeHombre = 1-porcentajeMujer;
	
	for(let user of users){
		if(user.gender==="female"&&user.hair.type==="Straight"){
			peloStraightMujer++;
		}else if(user.gender==="female"&&user.hair.type==="Curly"){
			peloCurlyMujer++;
		}else if(user.gender==="female"&&user.hair.type==="Wavy"){
			peloWavyMujer++;
		}else if(user.gender==="female"&&user.hair.type==="Kinky"){
			peloKinkyMujer++;
		}else if(user.gender==="male"&&user.hair.type==="Curly"){
			peloCurlyHombre++;
		}else if(user.gender==="male"&&user.hair.type==="Wavy"){
			peloWavyHombre++;
		}else if(user.gender==="male"&&user.hair.type==="Straight"){
			peloStraightHombre++;
		}
	}
				
	peloStraightMujer /= users.length;
	peloCurlyMujer /= users.length;
	peloWavyMujer /= users.length;
	peloKinkyMujer /= users.length;
							
	peloCurlyHombre /= users.length;
	peloWavyHombre /= users.length;
	peloStraightHombre /= users.length;
				
}

function asignarValoresChartdiv3(users){
	for(let user of users){
		if(user.bloodGroup==="A+"){
			aplus++;
		}else if(user.bloodGroup==="A-"){
			aless++;
		}else if(user.bloodGroup==="AB+"){
			abplus++;
		}else if(user.bloodGroup==="AB-"){
			abless++;
		}else if(user.bloodGroup==="B+"){
			bplus++;
		}else if(user.bloodGroup==="B-"){
			bless++;
		}else if(user.bloodGroup==="O+"){
			oplus++;
		}else if(user.bloodGroup==="O-"){
			oless++;
		}
	}
			
	abless += abplus;
	aplus += abless;
	aless += aplus;
	bplus += aless;
	bless += bplus;
	oplus += bless;
	oless += oplus;
	let aux=0;
	for(let i=0;i<10;i++){
		for(let j=0;j<10;j++){
			if(aux<abplus){
				data1.push({x:String(i+1), y:String(j+1)});
			}else if(aux>=abplus&&aux<abless){
				data2.push({x:String(i+1), y:String(j+1)});
			}else if(aux<=aplus&&aux<aplus){
				data3.push({x:String(i+1), y:String(j+1)});
			}else if(aux<=aless&&aux<aless){
				data4.push({x:String(i+1), y:String(j+1)});
			}else if(aux<=bplus&&aux<bplus){
				data5.push({x:String(i+1), y:String(j+1)});
			}else if(aux<=bless&&aux<bless){
				data6.push({x:String(i+1), y:String(j+1)});
			}else if(aux<=oplus&&aux<oplus){
				data7.push({x:String(i+1), y:String(j+1)});
			}else if(aux<=oless&&aux<oless){
				data8.push({x:String(i+1), y:String(j+1)});
			}
			aux++;
		}
	}
}