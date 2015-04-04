var gastosPorMes = null;
var rendimentosGastos = null;

$(document).ready(function () {
	chamadaAjaxSemData("relatorios/gastosPorMes", montaGraficoGastosPorMes);
	chamadaAjaxSemData("relatorios/rendimentosGastos", montaGraficoRendimentosGastos);
	chamadaAjax("relatorios/resumo", montaResumo);
});


function chamadaAjaxSemData(url, callback) {
	$.ajax({
		//Precisa ser sincrono, senão ele tenta montar o gráfico com resultado vazio
		url: url,
		dataType:"json",
		success: function(data) {
			callback(data);
		}
	});
}

function chamadaAjax(url, callback) {
	var today = new Date();
	var firstOfMonth = today.getFullYear() + "/" + (today.getMonth() + 1) + "/" + 1;
	var last = new Date(today.getFullYear(),today.getMonth()+1, 0);
	var lastOfMonth = last.getFullYear() + "/" + (today.getMonth() + 1) + "/" + last.getDate();
	$.ajax({
		//Precisa ser sincrono, senão ele tenta montar o gráfico com resultado vazio
		url: url,
		data: {inicio: firstOfMonth, fim: lastOfMonth },
		dataType:"json",
		success: function(data) {
			callback(data);
		}
	});
}

function montaGraficoGastosPorMes(data) {
	
	if (gastosPorMes) {
		gastosPorMes.destroy();
	}
	
	$.jqplot.sprintf.thousandsSeparator = '.';
	$.jqplot.sprintf.decimalMark = ',';
	var valor = [];
	var periodo = [];
	for (var i=0; i < data.length; i++){ 
		valor.push([i + 1, data[i].valorTotal]);
		periodo.push([data[i].mes + "/" + data[i].ano]);
	} 

	gastosPorMes = $.jqplot('gastosPorMes',[valor],{
		seriesDefaults:{
			renderer: $.jqplot.CanvasAxisLabelRenderer,
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
				ticks: periodo,
				tickOptions: {
			          angle: -40,
			          fontFamily: 'Georgia'
			        }
			}
		}
	})
}

function montaGraficoRendimentosGastos(data) {
	
	if (rendimentosGastos) {
		rendimentosGastos.destroy();
	}
	
	$.jqplot.sprintf.thousandsSeparator = '.';
	$.jqplot.sprintf.decimalMark = ',';
	var rendimento = [];
	var gastos = [];
	var periodo = [];
	for (var i=0; i < data.length; i++){ 
		rendimento.push([i + 1, data[i].rendimentos]);
		gastos.push([i + 1, data[i].despesas]);
		periodo.push([data[i].mes + "/" + data[i].ano]);
	} 

	rendimentosGastos = $.jqplot('rendimentosGastos',[rendimento, gastos],{
		seriesDefaults:{
			renderer: $.jqplot.CanvasAxisLabelRenderer,
			pointLabels: { show: true, formatString: "R$ %'.2f"  },
			formatter: function(format, value){
	            return FormatTick(format, value);
	        }
		},
		series: [ {label: 'Rendimentos'}, {label: 'Gastos' }],
		
		axesDefaults: {
	        tickRenderer: $.jqplot.CanvasAxisTickRenderer
	        
	    },
	    
	    legend: {
            show: true,
            placement: 'outsideGrid'
        },
		
		rendererOptions: {
			barMargin: 30
		},
		
		axes:{
			xaxis:{
				renderer: $.jqplot.CategoryAxisRenderer,
				ticks: periodo,
				tickOptions: {
			          angle: -40,
			          fontFamily: 'Georgia'
			        }
			}
		}
	})
}

function montaResumo(data) {
	$("#totalGastosPeriodo").html(data[0]);
	$("#totalGastosVariaveisPeriodo").html(data[1]);
	$("#totalGastosFixos").html(data[2]);
	$("#rendaComprometida").html(data[3] + " %");
}