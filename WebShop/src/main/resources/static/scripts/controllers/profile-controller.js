(function(angular) {
	'use strict';

	angular.module('profile', []).controller('ProfileController', ProfileController);
	
	ProfileController.$inject = ['$scope', '$localStorage', 'ProfileFactory'];
	
	function ProfileController($scope, $localStorage, ProfileFactory) {
		
		var vm = this;
		vm.user = $localStorage.user;
		
		/*
		ProfileFactory.getUserInvoices(vm.user.id).then(function(items) {
			vm.invoices = items;
		})*/
	
	}
	
})(angular);