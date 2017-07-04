(function(angular) {
	'use strict';

	angular.module(
			'webShopApp',
			[ 'ngRoute', 'restangular', 'ui.bootstrap', 'ngStorage', 'lodash', 'main']).config(configure).run(runBlock);

	configure.$inject = [ '$routeProvider', 'RestangularProvider' ];
	runBlock.$inject = [ 'Restangular', '$log' ];

	function configure($routeProvider, RestangularProvider) {
		$routeProvider.when('/', {
			templateUrl : 'views/main.html',
			controller  : 'MainController',
			controllerAs: 'mainCtrl'
		}).when('/profile', {
			templateUrl : 'views/profile.html',
			controller  : 'ProfileController',
			controllerAs: 'profileCtrl'
		}).when('/products/:param', {
			templateUrl : 'views/products.html',
			controller  : 'ProductsController',
			controllerAs: 'productsCtrl'
		}).when('/product_details/:param', {
			templateUrl : 'views/product-details.html',
			controller  : 'ProductController',
			controllerAs: 'productCtrl'
		}).when('/cart', {
			templateUrl : 'views/cart.html',
			controller  : 'CartController',
			controllerAs: 'cartCtrl'
		}).when('/login', {
			templateUrl : 'views/login.html',
			controller  : 'LoginController',
			controllerAs: 'loginCtrl'
		}).otherwise({
			redirectTo : '/'
		});
	}

	function runBlock(Restangular, $log) {
		Restangular.setBaseUrl('webShop');
		Restangular.setErrorInterceptor(function(response) {
			if (response.status === 500) {
				$log.info("internal server error");
				return true;
			}
			return true;
		});
	}

})(angular);
