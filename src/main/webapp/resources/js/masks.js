$(document).ready(function(){
  $('.date').mask('99/99/9999');
  $('.money').maskMoney({prefix:'R$ ', allowNegative: true, thousands:'', decimal:'.', affixesStay: false});
  
});