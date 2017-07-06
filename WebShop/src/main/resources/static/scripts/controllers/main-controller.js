(function(angular) {
	'use strict';

	angular.module('main', ['login', 'profile', 'products', 'product', 'cart', 'invoice', 'sinvoice', 'cinvoice', 'management', 'search']).controller('MainController', MainController);
	
	MainController.$inject = ['$scope', '$location', '$localStorage', 'MainFactory'];
	
	function MainController($scope, $location, $localStorage, MainFactory) {
		
		var vm = this;
		
		vm.search = '';
		vm.priceFrom = '';
		vm.priceTo = '';
		vm.wrongSearchInput = false;
		
		MainFactory.getCategories().then(function(items) {
			vm.categories = items;
			setChangeActions();
	 	});
		
		
		MainFactory.getNewestProducts().then(function(items) {
			 vm.newest = items;
	 	});
		
		vm.searchProducts = function() {
			vm.wrongSearchInput = false;
			if (!vm.search && !vm.priceFrom && !vm.priceTo) {
				vm.wrongSearchInput = true;
			} else {
				if (vm.search.trim() == "" || isNaN(vm.search)) {
					if (parseFloat(vm.priceFrom) < 0 || parseFloat(vm.priceTo) < 0 || parseFloat(vm.priceFrom) > parseFloat(vm.priceTo)) {
						vm.wrongSearchInput = true;
					} else {
						$location.path('/search/' + vm.search + '#' + vm.priceFrom + '#' + vm.priceTo);
					}
				} else {
					$location.path('/search/' + vm.search);
				}
			}
		}	
		
	}
	
	function setChangeActions() {
		$('.subMenu > a').click(function(e)
		{
			e.preventDefault();
			var subMenu = $(this).siblings('ul');
			var li = $(this).parents('li');
			var subMenus = $('#sidebar li.subMenu ul');
			var subMenus_parents = $('#sidebar li.subMenu');
			if(li.hasClass('open'))
			{
				if(($(window).width() > 768) || ($(window).width() < 479)) {
					subMenu.slideUp();
				} else {
					subMenu.fadeOut(250);
				}
				li.removeClass('open');
			} else 
			{
				if(($(window).width() > 768) || ($(window).width() < 479)) {
					subMenus.slideUp();			
					subMenu.slideDown();
				} else {
					subMenus.fadeOut(250);			
					subMenu.fadeIn(250);
				}
				subMenus_parents.removeClass('open');		
				li.addClass('open');	
			}
		});
	}
	
})(angular);