angular.module('management').factory('ManagementFactory', ManagementFactory);

ManagementFactory.$inject = [ 'Restangular' ];

function ManagementFactory(Restangular) {

	var retVal = {};

	retVal.getSupercategories = function() {
		return Restangular.all('productCategory/supercategories').getList()
				.then(function(entries) {
					return entries;
				});
	};
	
	retVal.getSubcategories = function() {
		return Restangular.all('productCategory/subcategories').getList()
				.then(function(entries) {
					return entries;
				});
	};

	retVal.getCategories = function() {
		return Restangular.all('productCategory').getList().then(
				function(entries) {
					return entries;
				});
	};

	retVal.saveCategory = function(category) {
		return Restangular.one('productCategory').customPOST(category).then(
				function(entry) {
					return entry;
				});
	};

	retVal.saveProduct = function(product) {
		return Restangular.one('products').customPOST(product).then(
				function(entry) {
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
	
	retVal.getProductCategory = function(id) {
		return Restangular.one('productCategory', id).get().then(function(entry) {
			return entry;
		});
	};
	
	retVal.getActionEvents = function() {
		return Restangular.all('actionEvents').getList().then(function(entries) {
			return entries;
		});
	};
	
	retVal.getActionEvent = function(id) {
		return Restangular.one('actionEvents', id).get().then(function(entry) {
			return entry;
		});
	};
	
	retVal.saveEvent = function(event) {
		return Restangular.one('actionEvents').customPOST(event).then(
				function(entry) {
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
	
	retVal.getUserCategories = function() {
		return Restangular.all('customerCategory').getList().then(function(entries) {
			return entries;
		});
	};
	
	retVal.getUserCategory = function(id) {
		return Restangular.one('customerCategory', id).get().then(function(entry) {
			return entry;
		});
	};
	
	retVal.saveUserCategory = function(category) {
		return Restangular.one('customerCategory').customPOST(category).then(
				function(entry) {
					return entry;
				});
	};
	
	retVal.addToUserCategory = function(limit, id) {
		return Restangular.one('customerCategory/add', id).customPOST(limit).then(
				function(entry) {
					return entry;
				});
	};

	return retVal;

}