(function(angular) {
	'use strict';

	angular.module('management', ['angularjs-dropdown-multiselect']).controller(
			'ManagementController', ManagementController);

	ManagementController.$inject = [ '$scope', '$location', '$routeParams',
			'ManagementFactory' ];

	function ManagementController($scope, $location, $routeParams,
			ManagementFactory) {

		var vm = this;
		vm.category = {};
		vm.product = {};
		vm.regularLimit = {};
		vm.silverLimit = {};
		vm.goldLimit = {};
		vm.event = {};
		var param = $routeParams.id;
		var type = $routeParams.type;
		vm.wrongInputProduct = false;
		vm.wrongInputEvent = false;
		vm.subCatForSelect = [];
		vm.selectedCategories = [];

		if (param) {
			if (type == 'category') {
				ManagementFactory.getProductCategory(param).then(
						function(item) {
							vm.selectedCategory = item;
						});
			} else if (type == 'event') {
				ManagementFactory.getActionEvent(param).then(function(item) {
					vm.selectedEvent = item;
				});
			}
		}
		
		ManagementFactory.getUserCategory(1).then(function(item) {
			vm.regularUserCat = item;
		});
		
		ManagementFactory.getUserCategory(2).then(function(item) {
			vm.silverUserCat = item;
		});
		
		ManagementFactory.getUserCategory(3).then(function(item) {
			vm.goldUserCat = item;
		});

		ManagementFactory.getSupercategories().then(function(items) {
			vm.supercategories = items;
		});

		ManagementFactory.getSubcategories().then(function(items) {
			vm.subcategories = items;
			for (var i = 0; i < items.length; i++) {
				vm.subCatForSelect.push({
					id: items[i].id,
					label: items[i].name
				});
			}
		});
		
		ManagementFactory.getCategories().then(function(items) {
			vm.categories = items;
		});

		/*
		ManagementFactory.getActionEvents().then(function(items) {
			vm.events = items;
		});

		ManagementFactory.getUserCategories().then(function(items) {
			vm.user_categories = items;
		});*/

		vm.addCategory = function(type) {
			ManagementFactory.saveCategory(vm.category).then(function(item) {
				vm.categories.push(item);
				if (type != 'stay') {
					$location.path('/');
				}
			});
		};

		vm.addProduct = function(type) {
			vm.product.dateCreated = new Date();
			vm.product.image = 'image';
			ManagementFactory.saveProduct(vm.product).then(function(item) {
				if(item.status){
					if (type != 'stay') {
						$location.path('/');
					}
				} else {
					vm.wrongInputProduct = true;
				}
			});
		};

		vm.updateCategory = function() {
			ManagementFactory.saveCategory(vm.selectedCategory).then(function(item) {
				$location.path('/management');
			});
		};
		
		vm.addLimit = function(type) {
			if (type == 'regular') {
				ManagementFactory.addToUserCategory(vm.regularLimit, 1).then(function(item) {
					vm.regularUserCat.consumptionLimit.push(vm.regularLimit);
					vm.regularLimit = {};
				});
			} else if (type == 'silver') {
				ManagementFactory.addToUserCategory(vm.silverLimit, 2).then(function(item) {
					vm.silverUserCat.consumptionLimit.push(vm.silverLimit);
					vm.silverLimit = {};
				});
			} else if (type == 'gold') {
				ManagementFactory.addToUserCategory(vm.goldLimit, 3).then(function(item) {
					vm.goldUserCat.consumptionLimit.push(vm.goldLimit);
					vm.goldLimit = {};
				});
			}
		};
		
		vm.updateUserCategory = function(limit) {
			ManagementFactory.saveUserCategory(limit);
		};
		
		vm.addEvent = function() {
			vm.event.productCategories = vm.selectedCategories;
			ManagementFactory.saveEvent(vm.event).then(function(item) {
				if(item.status){
					vm.events.push(item);
				} else {
					vm.wrongInputEvent = true;
				}
			});
		};

		/*
		vm.showEvent = function(id) {
			$location.path('/action_event/' + id + '/event');
		};

		vm.updateEvent = function() {
			ManagementFactory.saveEvent(vm.selectedEvent);
			$location.path('/action_events');
		};

		vm.dateOptions = {
			formatYear : 'yy',
			maxDate : new Date(2020, 5, 22),
			minDate : new Date(),
			startingDay : 1
		};

		vm.open1 = function() {
			vm.popup1.opened = true;
		};

		vm.open2 = function() {
			vm.popup2.opened = true;
		};

		vm.format = 'dd-MMMM-yyyy';

		vm.popup1 = {
			opened : false
		};

		vm.popup2 = {
			opened : false
		};*/

	}

})(angular);