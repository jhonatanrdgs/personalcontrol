$(document).ready(function () {
	
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
	errorPlacement: function (error, element) {
        error.insertAfter(element.closest('.input-icon'));
    },
    highlight: function (element) { // hightlight error inputs
        $(element).closest('.form-group').addClass('has-error'); // set error class to the control group
    }
})
});