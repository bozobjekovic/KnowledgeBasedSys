angular.module('search').factory('SearchFactory', SearchFactory);

SearchFactory.$inject = [ 'Restangular' ];

function SearchFactory(Restangular) {

	var retVal = {};

	retVal.getProductsByNameOrCode = function(search) {
		return Restangular.one('products/search').customGET('', {
			search : search
		}).then(function(entry) {
			return entry;
		});
	};

	return retVal;

}