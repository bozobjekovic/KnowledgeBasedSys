angular.module('login').factory('LoginFactory', LoginFactory);

LoginFactory.$inject = [ 'Restangular' ];

function LoginFactory(Restangular) {

	var retVal = {};

	retVal.login = function(loginUser) {
		return Restangular.one('login').customPOST(loginUser).then(
			function(entry){
				return {
					status: true,
					data: entry
				}
			},
			function() {
				return {
					status: false,
					data: null
				}
			}
		);
	};

	return retVal;
}