var mesParam = null;
var anoParam = null;

var graficoPizza = null;
var comprasParceladas = null;
var gastosPorMetodoPagamento = null;
var gastosVariaveis = null;
var gastosFixos = null;
var rendimentosGastos = null;

$(document).ready(function () {
	carregaDatas();
	chamadaAjax("graficoPizza", montaGraficoPizza);
	chamadaAjax("comprasParceladas", montraGraficoComprasParceladas);
	chamadaAjax("gastosPorMetodoPagamento", montaGraficoGastosPorMetodoPagamento);
	chamadaAjax("gastosVariaveis", montaGraficoGastosVariaveis);
	chamadaAjax("resumo", montaResumo);
	chamadaAjaxSemData("gastosFixos", montaGraficoGastosFixos);
	
	$("#mes").click(function() {
		reload();
	});
	
	$("#ano").click(function() {
		reload();
	});
	
	$("#resumoMes").click(function() {
        $('#resumo').slideToggle("fast");
    });
	
});

function reload() {
	carregaDatas();
	chamadaAjax("graficoPizza", montaGraficoPizza);
	chamadaAjax("comprasParceladas", montraGraficoComprasParceladas);
	chamadaAjax("gastosPorMetodoPagamento", montaGraficoGastosPorMetodoPagamento);
	chamadaAjax("gastosVariaveis", montaGraficoGastosVariaveis);
	chamadaAjax("gastosFixos", montaGraficoGastosFixos);
	chamadaAjax("resumo", montaResumo);
}

function carregaDatas() {
	mesParam = $("#mes").val();
	anoParam = $("#ano").val();
}

function chamadaAjax(url, callback) {
	$.ajax({
		//Precisa ser sincrono, senão ele tenta montar o gráfico com resultado vazio
		url: url,
		data: {mes: mesParam, ano: anoParam },
		dataType:"json",
		success: function(data) {
			callback(data);
		}
	});
}

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


function montaGraficoPizza(data) {
	if (data.length == 0) {
		$("#gastosPorCategoria").html("Nenhum resultado encontrado para o per\u00edodo informado");
		return;
	}
	if (graficoPizza) {
		graficoPizza.destroy();
	}
	
	$.jqplot.sprintf.thousandsSeparator = '.';
	$.jqplot.sprintf.decimalMark = ',';
	var valor = [];
	var categorias = [];
	for (var i=0; i < data.length; i++){ 
		valor.push([i + 1, data[i].valorTotal]);
		categorias.push([data[i].categoria]);
	} 

	graficoPizza = $.jqplot('gastosPorCategoria',[valor],{
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

function montraGraficoComprasParceladas(data) {
	if (data.length == 0) {
		$("#comprasParceladas").html("Nenhum resultado encontrado para o per\u00edodo informado");
		return;
	}
	if (comprasParceladas) {
		comprasParceladas.destroy();
	}
	
	$.jqplot.sprintf.thousandsSeparator = '.';
	$.jqplot.sprintf.decimalMark = ',';
	var valor = [];
	var categorias = [];
	for (var i=0; i < data.length; i++){ 
		valor.push([i + 1, data[i].valor]);
		categorias.push([data[i].descricaoDespesa]);
	} 

	comprasParceladas = $.jqplot('comprasParceladas',[valor],{
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


function montaGraficoGastosPorMetodoPagamento(data) {
	if (data.length == 0) {
		$("#gastosPorMetodoPagamento").html("Nenhum resultado encontrado para o per\u00edodo informado");
		return;
	}
	if (gastosPorMetodoPagamento) {
		gastosPorMetodoPagamento.destroy();
	}
	
	$.jqplot.sprintf.thousandsSeparator = '.';
	$.jqplot.sprintf.decimalMark = ',';
	var valor = [];
	var metodoPagamento = [];
	for (var i=0; i < data.length; i++){ 
		valor.push([i + 1, data[i].valor]);
		metodoPagamento.push([data[i].metodoPagamento]);
	} 

	gastosPorMetodoPagamento = $.jqplot('gastosPorMetodoPagamento',[valor],{
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
				ticks: metodoPagamento,
				tickOptions: {
			          angle: -40,
			          fontFamily: 'Georgia'
			        }
			}
		}
	})
}

function montaGraficoGastosVariaveis(data) {
	if (data.length == 0) {
		$("#gastosVariaveis").html("Nenhum resultado encontrado para o per\u00edodo informado");
		return;
	}
	if (gastosVariaveis) {
		gastosVariaveis.destroy();
	}
	
	$.jqplot.sprintf.thousandsSeparator = '.';
	$.jqplot.sprintf.decimalMark = ',';
	var valor = [];
	var descricao = [];
	for (var i=0; i < data.length; i++){ 
		valor.push([i + 1, data[i].valor]);
		descricao.push([data[i].descricao]);
	} 

	gastosVariaveis = $.jqplot('gastosVariaveis',[valor],{
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
				ticks: descricao,
				tickOptions: {
			          angle: -40,
			          fontFamily: 'Georgia'
			        }
			}
		}
	})
}


function montaGraficoGastosFixos(data) {
	if (data.length == 0) {
		$("#gastosFixos").html("Nenhum resultado encontrado");
		return;
	}
	if (gastosFixos) {
		gastosFixos.destroy();
	}
	
	$.jqplot.sprintf.thousandsSeparator = '.';
	$.jqplot.sprintf.decimalMark = ',';
	var valor = [];
	var descricao = [];
	for (var i=0; i < data.length; i++){ 
		valor.push([i + 1, data[i].valor]);
		descricao.push([data[i].descricao]);
	} 

	gastosFixos = $.jqplot('gastosFixos',[valor],{
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
				ticks: descricao,
				tickOptions: {
			          angle: -40,
			          fontFamily: 'Georgia'
			        }
			}
		}
	})
}

function montaGraficoRendimentosGastos(data) {
	if (data.length == 0) {
		$("#rendimentoGastos").html("Nenhum resultado encontrado para o per\u00edodo informado");
		return;
	}
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