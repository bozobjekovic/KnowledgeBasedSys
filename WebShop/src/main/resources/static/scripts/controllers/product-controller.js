(function(angular) {
	'use strict';

	angular.module('product', []).controller('ProductController', ProductController);

	ProductController.$inject = ['$scope', '$routeParams', '$localStorage', '$location', 'ProductFactory'];

	function ProductController($scope, $routeParams, $localStorage, $location, ProductFactory) {

		var vm = this;
		var param = $routeParams.param;
		
		if (!$localStorage.cart) { $localStorage.cart = []; } 

		ProductFactory.getProduct(param).then(function(item) {
			 vm.product = item;
	 	});
		
		var product_exist = function (id) {
			for (var i = 0; i < $localStorage.cart.length; i++) {
				if ($localStorage.cart[i].product.id == id) {
					$localStorage.cart[i].quantity += 1;
					return true;
				}
			}
			return false;
		};

		vm.addToCart = function(quantity) {
			if (!product_exist(vm.product.id)) {
				$localStorage.cart.push({ 
					product: vm.product,
					quantity: quantity});
			} 
			$location.path('/cart');
		};
	}

})(angular);
