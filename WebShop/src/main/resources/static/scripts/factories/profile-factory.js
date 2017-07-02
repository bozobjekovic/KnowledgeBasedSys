angular.module('profile').factory('ProfileFactory', ProfileFactory);

ProfileFactory.$inject = [ 'Restangular' ];

function ProfileFactory(Restangular) {

	var retVal = {};

	retVal.getUserInvoices = function(id) {
		return Restangular.one('invoices/customer', id).getList().then(
				function(entries) {
					return entries;
				});
	};

	return retVal;

}