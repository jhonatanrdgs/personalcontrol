$(document).ready(function(){
  $('.mask_date').mask('99/99/9999');
  $('.money').autoNumeric("init",{
      aSep: ',',
      aDec: '.', 
      aSign: ''}); 
  $('.numeric').numeric();
});