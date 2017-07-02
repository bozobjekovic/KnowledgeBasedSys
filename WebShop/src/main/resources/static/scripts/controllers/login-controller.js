(function(angular) {
	'use strict';

	angular.module('login', []).controller('LoginController', LoginController);
	
	LoginController.$inject = ['$scope', '$location', '$localStorage', 'LoginFactory'];

	function LoginController($scope, $location, $localStorage, LoginFactory) {

		var vm = this;
		
		vm.loginUser = {
			username: '',
			password: ''
		};
		
		vm.loggedUser = ($localStorage.user) ? $localStorage.user : null;
		
		vm.login = function(){
			LoginFactory.login(vm.loginUser);
			/*.then(function(item){
				if(item.uid === ''){
					alert('INVALID');
				}
				else{
					vm.loggedUser = item;
					$localStorage.user = item;
					$location.path('/');
				}
			});*/
		}
		
		vm.logout = function(){
			LoginFactory.logout();
			vm.loggedUser = null;
			$localStorage.$reset();
			$location.path('/');
		}

	}

})(angular);