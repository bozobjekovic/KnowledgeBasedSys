(function(angular) {
	'use strict';

	angular.module('products', []).controller('ProductsController',
			ProductsController);

	ProductsController.$inject = [ '$scope', '$routeParams', 'ProductsFactory' ];

	function ProductsController($scope, $routeParams, ProductsFactory) {

		var vm = this;
		var param = $routeParams.param;

		ProductsFactory.getProductsByCategory(param).then(function(item) {
			vm.products = item;
		});

		/*
		ProductsFactory.searchByName(name).then(function(items) {
			vm.products = items;
		});*/

	}

})(angular);