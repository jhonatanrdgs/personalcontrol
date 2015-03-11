$(document).ready(function () {
	var inicioSplit =  $("#inicio").val().split("/");
	var dateInicio = new Date(inicioSplit[2], inicioSplit[1] - 1, inicioSplit[0]);
	
	var fimSplit =  $("#fim").val().split("/");
	var dateFim = new Date(fimSplit[2], fimSplit[1] - 1, fimSplit[0]);
	
	$.ajax({
		// have to use synchronous here, else the function 
		// will return before the data is fetched
		url: "graficoPizza",
		data: {inicio: dateInicio, fim: dateFim },
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