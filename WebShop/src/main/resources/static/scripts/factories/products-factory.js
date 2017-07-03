angular.module('products').factory('ProductsFactory', ProductsFactory);

ProductsFactory.$inject = [ 'Restangular' ];

function ProductsFactory(Restangular) {

	var retVal = {};

	retVal.getProductsByCategory = function(id) {
		return Restangular.one('products/category', id).getList().then(
				function(entries) {
					return entries;
				});
	}

	/*retVal.searchByName = function(filterStr) {
		return Restangular.all('products/filter').customGET('', {
			filter : filterStr
		}).then(function(entries) {
			return entries;
		});
	}*/

	return retVal;

}