var plot = null;
$(document).ready(function () {
	chamadaAjax();
	
	$("#reload").click(function() {
		chamadaAjax();
	})


});

function chamadaAjax() {
	var inicioSplit =  $("#inicio").val().split("/");
	var dateInicio = new Date(inicioSplit[2], inicioSplit[1] - 1, inicioSplit[0]);
	
	var fimSplit =  $("#fim").val().split("/");
	var dateFim = new Date(fimSplit[2], fimSplit[1] - 1, fimSplit[0]);
	
	$.ajax({
		//Precisa ser sincrono, senão ele tenta montar o gráfico com resultado vazio
		url: "graficoPizza",
		data: {inicio: dateInicio, fim: dateFim },
		dataType:"json",
		success: function(data) {
			if (data.length == 0 ) {
				alert("Nenhum resultado encontrado para o per\u00edodo informado");
				plot.destroy();
			} else {
				if (plot) {
					plot.destroy();
				}
				montaGraficoPizza(data);
			}
		}
	});
}


function montaGraficoPizza(data) {
	$.jqplot.sprintf.thousandsSeparator = '.';
	$.jqplot.sprintf.decimalMark = ',';
	var valor = [];
	var categorias = [];
	for (var i=0; i < data.length; i++){ 
		valor.push([i + 1, data[i].valorTotal]);
		categorias.push([data[i].categoria]);
	} 

	plot = $.jqplot('gastosPorCategoria',[valor],{
		seriesDefaults:{
			renderer:$.jqplot.BarRenderer,
			pointLabels: { show: true, formatString: "R$ %'.2f"  },
			formatter: function(format, value){
	            return FormatTick(format, value);
	        }
		},
		
		axesDefaults: {
	        tickRenderer: $.jqplot.CanvasAxisTickRenderer
	        
	    },
		
		rendererOptions: {
			barMargin: 30
		},
		
		axes:{
			xaxis:{
				renderer: $.jqplot.CategoryAxisRenderer,
				ticks: categorias,
				tickOptions: {
			          angle: -40,
			          fontFamily: 'Georgia'
			        }
			}
		}
	})
}