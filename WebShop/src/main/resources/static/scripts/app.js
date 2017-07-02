(function(angular) {
	'use strict';

	angular.module(
			'webShopApp',
			[ 'ngRoute', 'restangular', 'ui.bootstrap', 'ngStorage', 'lodash', 'login']).config(configure).run(runBlock);

	configure.$inject = [ '$routeProvider', 'RestangularProvider' ];
	runBlock.$inject = [ 'Restangular', '$log' ];

	function configure($routeProvider, RestangularProvider) {
		$routeProvider.when('/', {
			templateUrl : 'views/main.html'
			//controller  : 'MainController',
			//controllerAs: 'mainCtrl'
		}).when('/profile', {
			templateUrl : 'views/profile.html',
			controller  : 'ProfileController',
			controllerAs: 'profileCtrl'
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
