(function(angular) {
	'use strict';

	angular.module('sinvoice', []).controller('SInvoiceController',
			SInvoiceController);

	SInvoiceController.$inject = [ '$scope', '$localStorage', 'SInvoiceFactory' ];

	function SInvoiceController($scope, $localStorage, SInvoiceFactory) {

		var vm = this;
		vm.loggedUser = ($localStorage.user) ? $localStorage.user : null;

		SInvoiceFactory.getInvoices().then(function(items) {
			vm.invoices = items;
		});

		vm.accept = function(id) {
			SInvoiceFactory.accept(id).then(function(items) {
				for (var i = 0; i < vm.invoices.length; i++) {
					var obj = vm.invoices[i];
					if (obj.id === id) {
						vm.invoices.splice(i, 1);
					}
				}
			});
		}

		vm.cancel = function(id) {
			SInvoiceFactory.cancel(id).then(function() {
				for (var i = 0; i < vm.invoices.length; i++) {
					var obj = vm.invoices[i];
					if (obj.id === id) {
						vm.invoices.splice(i, 1);
					}
				}
			});
		}

	}

})(angular);