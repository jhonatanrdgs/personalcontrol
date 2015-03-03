$(document).ready(function () {
	
	$(".form-horizontal").validate({
	
	rules: {
		descricao: {
			required: true
		}
	},
	messages: {
		descricao: {
			required: "Nome &eacute; de preenchimento Obrigat&oacute;rio"
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