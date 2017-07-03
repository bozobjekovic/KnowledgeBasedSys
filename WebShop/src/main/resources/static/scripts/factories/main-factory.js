angular.module('main').factory('MainFactory', MainFactory);

MainFactory.$inject = [ 'Restangular' ];

function MainFactory(Restangular) {

	var retVal = {};

	retVal.getProducts = function() {
		return Restangular.all('products').getList().then(function(entries) {
			return entries;
		});
	};

	retVal.getNewestProducts = function() {
		return Restangular.all('products/new').getList().then(
				function(entries) {
					return entries;
				});
	}

	retVal.getCategories = function() {
		return Restangular.all('productCategory').getList().then(
				function(entries) {
					return entries;
				});
	};

	return retVal;

}