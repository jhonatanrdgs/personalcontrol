$(document).ready(function () {
	
	if ($("#id").val() != "") {
		$.ajax({
			url: "recuperarItens",
			contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
			dataType:"json",
			scriptCharset: "utf-8", 
			success: function(data) {
				montaTabelaHTML(data);
			}
		});
	}
		
	
	$.validator.methods.date = function(value, element) {
		try {
			$.datepicker.parseDate("dd/mm/yy", value);
			return true;
		}
		catch(err) {
		    return false;
		}
    };
	
	$("#add").click(function() {
		var desc = $("#desc").val();
		var value = $("#val").val();
		$.ajax({
			
			url: "add",
			data: {descricao: desc, valor: value },
			contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
			dataType:"json",
			scriptCharset: "utf-8", 
			success: function(data) {
				montaTabelaHTML(data);
			}
		});
		$("#desc").val("");
		$("#val").val("");
	})
	
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
			},
			km: {
				required: true
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
			},
			km: {
				required: "Km &eacute; de preenchimento Obrigat&oacute;rio"
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
});

function remover(element) {
	var id = $(element).attr('class').split(" ")[0];
	$("tr[id='"+id+"']").remove();
	$.ajax({
		url: "remover",
		data: {index: id},
		contentType: "application/x-www-form-urlencoded; charset=UTF-8", 
		dataType:"json",
		scriptCharset: "utf-8" 
		
	});
}

function montaTabelaHTML(data) {
	var html = "<table  class='table table-bordered'>";
	html += "<th class='info'>Descri\u00e7\u00e3o</th><th class='info'>Valor</th><th class='info'>A\u00e7\u00e3o</th>";
	for (var i = 0; i < data.length; i++) {
		html += "<tr id='" + i + "'><td>" + data[i].descricao + "</td><td>" + data[i].valorItem 
			+ "</td><td>" + "<input type='button' value='Excluir' class='" + i + " btn btn-primary' onclick='remover(this)'/>" + "</td></tr>";
	}
	html += "</table>";
	$("#tableItens").html(html);
}