(function(angular) {
	'use strict';

	angular.module('product', []).controller('ProductController', ProductController);

	ProductController.$inject = ['$scope', '$routeParams', '$localStorage', '$location', 'ProductFactory'];

	function ProductController($scope, $routeParams, $localStorage, $location, ProductFactory) {

		var vm = this;
		var param = $routeParams.param;

		ProductFactory.getProduct(param).then(function(item) {
			 vm.product = item;
	 	});
		
	}

})(angular);
