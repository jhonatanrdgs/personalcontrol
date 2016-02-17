var rendimentosGastos = null;
var graficoPercentual12Meses = null;

$(document).ready(function () {
	chamadaAjaxSemData("relatorios/rendimentosGastos", montaGraficoRendimentosGastos);
	chamadaAjaxSemData("relatorios/percentual12Meses", montaGraficoPercentual12Meses)
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
	var mesParam = $("#mes").val();
	var anoParam = $("#ano").val();
	$.ajax({
		//Precisa ser sincrono, senão ele tenta montar o gráfico com resultado vazio
		url: url,
		data: {mes: mesParam, ano: anoParam},
		dataType:"json",
		success: function(data) {
			callback(data);
		}
	});
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
	$("#totalGastosPeriodo").html(data.totalGastos);
	$("#totalGastosVariaveisPeriodo").html(data.totalGastosVariaveisPeriodo);
	$("#totalGastosFixos").html(data.totalGastosFixos);
	$("#rendaComprometida").html(data.percentualComprometido + " %");
	$("#rendaComprometida").css("font-weight", "700");
	if (data.percentualComprometido <= 60) {
		$("#rendaComprometida").css("color", "green");
	} else if (data.percentualComprometido > 60 && data.percentualComprometido < 75) {
		$("#rendaComprometida").css("color", "#FFCC00");
	} else {
		$("#rendaComprometida").css("color", "red");
	}
	$("#rendimentoPeriodo").html(data.rendimentos);
	$("#sobra").html(data.sobra);
	if (data.sobra < 0) {
		$("#sobra").css("font-weight", "700");
		$("#sobra").css("color", "red");
	} else {
		$("#sobra").css("font-weight", "normal");
		$("#sobra").css("color", "#333;");
	}
}

function montaGraficoPercentual12Meses(data) {
	if (graficoPercentual12Meses) {
		graficoPercentual12Meses.destroy();
	}
	
	var original = [];
	var periodo = [];
	for (var i=0; i < data.length; i++){ 
		original.push(data[i].percentual);
		periodo.push([data[i].mes + "/" + data[i].ano]);
	} 

	graficoPercentual12Meses = $.jqplot('graficoPercentual12Meses',[original],{
		stackSeries: true,
        captureRightClick: true,
        seriesDefaults:{
            renderer:$.jqplot.BarRenderer,
            rendererOptions: {
                highlightMouseDown: true   
            },
            pointLabels: {show: true}
        },
        axes:{
			xaxis:{
				renderer: $.jqplot.CategoryAxisRenderer,
				ticks: periodo,
				tickOptions: {
			          angle: -40,
			          fontFamily: 'Georgia'
			        }
			},
			yaxis: {
                tickOptions:{
                  formatString: "%#.2f %"
                }
              }
		},
	})
}
