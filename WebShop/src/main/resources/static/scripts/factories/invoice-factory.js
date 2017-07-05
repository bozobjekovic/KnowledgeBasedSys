angular.module('invoice').factory('InvoiceFactory', InvoiceFactory);

InvoiceFactory.$inject = [ 'Restangular' ];

function InvoiceFactory(Restangular) {

	var retVal = {};

	retVal.getInvoices = function() {
		return Restangular.one('invoices/status', 'ORDERED').getList().then(
				function(entries) {
					return entries;
				});
	};

	retVal.getInvoiceItems = function(id) {
		return Restangular.one('invoiceItems/invoice', id).getList().then(
				function(entries) {
					return entries;
				});
	};

	retVal.accept = function(id) {
		return Restangular.one('invoices/accept', id).get().then(
				function(entry) {
					return entry;
				});
	};

	retVal.cancel = function(id) {
		return Restangular.one('invoices/cancel', id).get();
	};

	return retVal;

}