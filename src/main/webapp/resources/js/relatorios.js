$(document).ready(function () {
	$.ajax({
		// have to use synchronous here, else the function 
		// will return before the data is fetched
		url: "graficoPizza",
		dataType:"json",
		success: function(data) {
			montaGraficoPizza(data);
		}
	});


});


function montaGraficoPizza(data) {
	$.jqplot.sprintf.thousandsSeparator = '.';
	$.jqplot.sprintf.decimalMark = ',';
	var valor = [];
	var categorias = [];
	for (var i=0; i < data.length; i++){ 
		valor.push([i + 1, data[i].valorTotal]);
		categorias.push([data[i].categoria]);
	} 

	plot2 = $.jqplot('gastosPorCategoria',[valor],{
		seriesDefaults:{
			renderer:$.jqplot.BarRenderer,
			pointLabels: { show: true, formatString: "R$ %'.2f"  },
			formatter: function(format, value){
	            return FormatTick(format, value);
	        }
		},
		
		rendererOptions: {
			barMargin: 30
		},
		axes:{
			xaxis:{
				renderer: $.jqplot.CategoryAxisRenderer,
				ticks: categorias
			}
		}
	})
}