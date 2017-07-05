(function(angular) {
	'use strict';

	angular.module('invoice', []).controller('InvoiceController',
			InvoiceController);

	InvoiceController.$inject = [ '$scope', '$localStorage', 'InvoiceFactory' ];

	function InvoiceController($scope, $localStorage, InvoiceFactory) {

		var vm = this;
		vm.loggedUser = ($localStorage.user) ? $localStorage.user : null;

		InvoiceFactory.getInvoices().then(function(items) {
			vm.invoices = items;
		});

		vm.accept = function(id) {
			InvoiceFactory.accept(id).then(function(items) {
				for (var i = 0; i < vm.invoices.length; i++) {
					var obj = vm.invoices[i];
					if (obj.id === id) {
						vm.invoices.splice(i, 1);
					}
				}
			});
		}

		vm.cancel = function(id) {
			InvoiceFactory.cancel(id).then(function() {
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