(function(angular) {
	'use strict';

	angular.module('login', []).controller('LoginController', LoginController);
	
	LoginController.$inject = ['$scope', '$location', '$localStorage', 'LoginFactory'];

	function LoginController($scope, $location, $localStorage, LoginFactory) {

		var vm = this;
		
		vm.wrongInput = false;
		
		vm.loginUser = {
			username: '',
			password: ''
		};
		
		vm.loggedUser = ($localStorage.user) ? $localStorage.user : null;
		
		vm.login = function(){
			LoginFactory.login(vm.loginUser).then(function(item){
				if(item.status){
					vm.loggedUser = item.data;
					$localStorage.user = item.data;
					$location.path('/');
				}
				else{
					vm.wrongInput = true;
				}
			});
		}
		
		vm.logout = function(){
			vm.loggedUser = null;
			$localStorage.$reset();
			$location.path('/');
		}

	}

})(angular);