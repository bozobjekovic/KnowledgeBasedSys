angular.module('login').factory('LoginFactory', LoginFactory);

LoginFactory.$inject = [ 'Restangular' ];

function LoginFactory(Restangular) {

	var retVal = {};

	retVal.login = function(loginUser) {
		Restangular.one('login').customPOST(loginUser).then(
			function(entry){
				console.log(entry);
				//return entry;
			},
			function() {
				console.log("ERROR");
			}
		);
	};

	return retVal;
}