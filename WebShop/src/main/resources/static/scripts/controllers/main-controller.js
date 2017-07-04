(function(angular) {
	'use strict';

	angular.module('main', ['login', 'profile', 'products', 'product', 'cart']).controller('MainController', MainController);
	
	MainController.$inject = ['$scope', '$localStorage', 'MainFactory'];
	
	function MainController($scope, $localStorage, MainFactory) {
		
		var vm = this;
		
		MainFactory.getCategories().then(function(items) {
			vm.categories = items;
			setChangeActions();
	 	});
		
		
		MainFactory.getNewestProducts().then(function(items) {
			 vm.newest = items;
	 	});
		
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