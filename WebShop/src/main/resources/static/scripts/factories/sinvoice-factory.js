angular.module('sinvoice').factory('SInvoiceFactory', SInvoiceFactory);

SInvoiceFactory.$inject = [ 'Restangular' ];

function SInvoiceFactory(Restangular) {

	var retVal = {};

	retVal.getInvoices = function() {
		return Restangular.one('invoices/status', 'SUCCESSFUL').getList().then(
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