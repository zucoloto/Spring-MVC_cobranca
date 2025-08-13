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

$(function() {
	$('.js-atualizar-status').on('click', function(event) {
        event.preventDefault();
    	var botaoReceber = $(event.currentTarget);
    	var urlReceber = botaoReceber.attr('href');

    	var response = $.ajax({
            url: urlReceber,
        	type: 'PUT'
        });

        response.done(function(e) {
           var codigoTitulo = botaoReceber.data('codigo');
           $('[data-role=' + codigoTitulo + ']').html('<span class="badge text-bg-success">' + e + '</span>');
        	botaoReceber.hide();
        });

        response.fail(function(e) {
            console.log(e);
        	alert('Erro recebendo cobrança');
       	});
    });
});

$(document).ready(function () {
      window.setTimeout(function() {
          $(".alert").fadeTo(1000, 0).slideUp(1000, function(){
                 $(this).remove();
          });
      }, 2000);
 });