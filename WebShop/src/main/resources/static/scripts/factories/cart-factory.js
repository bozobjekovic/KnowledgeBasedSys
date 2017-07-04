angular.module('cart').factory('CartFactory', CartFactory);

CartFactory.$inject = [ 'Restangular' ];

function CartFactory(Restangular) {

	var retVal = {};

	retVal.saveInvoice = function(invoice) {
		return Restangular.one('invoices').customPOST(invoice).then(
				function(entry) {
					return entry;
				});
	};
	
	retVal.getProduct = function(id) {
		return Restangular.one('products', id).get().then(function(entry) {
			return entry;
		});
	};

	return retVal;

}