(function(angular) {
	'use strict';

	angular.module('cinvoice', []).controller('CInvoiceController',
			CInvoiceController);

	CInvoiceController.$inject = [ '$scope', '$localStorage', 'CInvoiceFactory' ];

	function CInvoiceController($scope, $localStorage, CInvoiceFactory) {

		var vm = this;
		vm.loggedUser = ($localStorage.user) ? $localStorage.user : null;

		CInvoiceFactory.getInvoices().then(function(items) {
			vm.invoices = items;
		});

		vm.accept = function(id) {
			CInvoiceFactory.accept(id).then(function(items) {
				for (var i = 0; i < vm.invoices.length; i++) {
					var obj = vm.invoices[i];
					if (obj.id === id) {
						vm.invoices.splice(i, 1);
					}
				}
			});
		}

		vm.cancel = function(id) {
			CInvoiceFactory.cancel(id).then(function() {
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