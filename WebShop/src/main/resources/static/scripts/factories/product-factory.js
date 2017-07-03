angular.module('product').factory('ProductFactory', ProductFactory);

ProductFactory.$inject = [ 'Restangular' ];

function ProductFactory(Restangular) {

	var retVal = {};

	retVal.getProduct = function(id) {
		return Restangular.one('products', id).get().then(function(entry) {
			return entry;
		});
	};

	return retVal;

}