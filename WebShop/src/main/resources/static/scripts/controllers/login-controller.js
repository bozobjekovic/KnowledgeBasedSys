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
		
		vm.show = function() {
			var logged = $localStorage.user;
			if(logged == null)
				return true;
			else
				return false;
		}
		
		vm.loggedUser = ($localStorage.user) ? $localStorage.user : null;
		
		vm.login = function(type){
			LoginFactory.login(vm.loginUser).then(function(item){
				if(item.status){
					vm.loggedUser = item.data;
					$localStorage.user = item.data;
					if (type != 'stay') {
						$location.path('/');
					}
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