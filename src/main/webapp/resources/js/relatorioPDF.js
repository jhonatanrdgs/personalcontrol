$(document).ready(function () {
	
	$(".form-horizontal").validate({
	
	rules: {
		mes: {
			required: true
		},
		ano: {
			required: true
		}
	},
	messages: {
		mes: {
			required: "M&ecirc;s &eacute; de preenchimento Obrigat&oacute;rio"
		},
		ano: {
			required: "Ano &eacute; de preenchimento Obrigat&oacute;rio"
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