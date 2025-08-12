$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	var codigoTitulo = button.data('codigo');
	var modal = $(this);
    var form = modal.find('form');
    var action = form.attr('data-url_base');

    if (!action.endsWith('/')) {
		action += '/';
	}

    form.attr('action', action + codigoTitulo);
});

$(function() {
	$('[rel="tooltip"]').tooltip();
});

$(function() {
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true});
});

$(document).ready(function () {
      window.setTimeout(function() {
          $(".alert").fadeTo(1000, 0).slideUp(1000, function(){
                 $(this).remove();
          });
      }, 2000);
 });