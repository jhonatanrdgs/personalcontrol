var simulacaoRendimentosGastos = null;

$(document).ready(function () {
	
	$.validator.methods.date = function(value, element) {
		try {
			$.datepicker.parseDate("dd/mm/yy", value);
			return true;
		}
		catch(err) {
		    return false;
		}
    };
	
	$(".form-horizontal").validate({

		rules: {
			descricao: {
				required: true
			},
			"categoria.id": {
				required:true
			},
			"metodoPagamento.id": {
				required:true
			},
			valorTotal: {
				required:true
			},
			totalParcelas: {
				required:true
			},
			data: {
				required:true,
				date: true
			}

		},
		messages: {
			descricao: {
				required: "Nome &eacute; de preenchimento Obrigat&oacute;rio"
			},
			"categoria.id": {
				required: "Categoria &eacute; de preenchimento Obrigat&oacute;rio"
			},
			"metodoPagamento.id": {
				required: "M&eacute;todo de Pagamento &eacute; de preenchimento Obrigat&oacute;rio"
			},
			valorTotal: {
				required: "Valor Total &eacute; de preenchimento Obrigat&oacute;rio"
			},
			totalParcelas: {
				required: "Total de parcelas &eacute; de preenchimento Obrigat&oacute;rio"
			},
			data: {
				required:"Data &eacute; de preenchimento Obrigat&oacute;rio",
				date: "Data inv&aacute;lida"
			}
		},
		errorClass: "control-label",
		errorElement: "span",
		errorPlacement: function (error, element) {
			error.insertAfter(element);
		},
		highlight: function (element) { // hightlight error inputs
			$(element).closest('.form-group').addClass('has-error'); // set error class to the control group
		},
		success: function (span) {
			span.closest('.form-group').removeClass('has-error');
			span.remove();
		}
	})
	
	$.ajax({
		//Precisa ser sincrono, senão ele tenta montar o gráfico com resultado vazio
		url: "getDados",
		dataType:"json",
		success: function(data) {
			montaSimulacaoRendimentosGastos(data);
		}
	})
	
	
	
});

function montaSimulacaoRendimentosGastos(data) {
	
	if (simulacaoRendimentosGastos) {
		simulacaoRendimentosGastos.destroy();
	}
	
	$.jqplot.sprintf.thousandsSeparator = '.';
	$.jqplot.sprintf.decimalMark = ',';
	var rendimento = [];
	var gastosNaoSimulados = [];
	var gastosSimulados = [];
	var periodo = [];
	for (var i=0; i < data.length; i++){ 
		rendimento.push([i + 1, data[i].rendimentos]);
		gastosNaoSimulados.push([i + 1, data[i].despesasNaoSimuladas]);
		gastosSimulados.push([i + 1, data[i].despesasSimuladas]);
		periodo.push([data[i].mes + "/" + data[i].ano]);
	} 

	simulacaoRendimentosGastos = $.jqplot('simulacaoRendimentosGastos', [rendimento, gastosNaoSimulados, gastosSimulados],{
		seriesDefaults:{
			renderer: $.jqplot.CanvasAxisLabelRenderer,
			pointLabels: { show: true, formatString: "R$ %'.2f"  },
			formatter: function(format, value){
	            return FormatTick(format, value);
	        }
		},
		series: [ {label: 'Rendimentos'}, {label: 'Gastos Sem Simula\u00e7\u00e3o' }, {label: 'Gastos Simulados'}],
		
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