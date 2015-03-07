$(document).ready(function () {
	
	$('input[name=parcelada]').click(function() {
		if (this.checked) {
			$('#totalParcelas').attr('value','');
			$('#totalParcelas').removeAttr('readonly');
		} else {
			$('#totalParcelas').attr('value', 1);
			$('#totalParcelas').attr('readonly', true);
		}
		
	});
	
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
				required:true
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
				required:"Data &eacute; de preenchimento Obrigat&oacute;rio"
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