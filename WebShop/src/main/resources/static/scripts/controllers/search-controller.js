(function(angular) {
	'use strict';

	angular.module('search', []).controller('SearchController',
			SearchController);

	SearchController.$inject = [ '$scope', '$routeParams', 'SearchFactory' ];

	function SearchController($scope, $routeParams, SearchFactory) {

		var vm = this;
		var param = $routeParams.param;
		
		SearchFactory.getProductsByNameOrCode(param).then(function(item) {
			vm.products = item;
		});

	}

})(angular);