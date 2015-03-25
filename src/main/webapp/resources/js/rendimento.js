$(document).ready(function () {
	
	$(".form-horizontal").validate({
	
	rules: {
		nomePessoa: {
			required: true
		},
		valor: {
			required: true
		}
	},
	messages: {
		descricao: {
			required: "Nome &eacute; de preenchimento Obrigat&oacute;rio"
		},
		valor: {
			required: "Valor &eacute; de preenchimento Obrigat&oacute;rio"
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