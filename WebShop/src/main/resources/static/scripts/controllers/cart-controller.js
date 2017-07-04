(function(angular) {
	'use strict';

	angular.module('cart', []).controller('CartController', CartController);
	
	CartController.$inject = ['$scope', 'CartFactory', '$location', '$localStorage'];
	
	function CartController($scope, CartFactory, $location, $localStorage) {
		
		var vm = this;
		
		if (!$localStorage.cart) { $localStorage.cart = []; } 
		
		vm.totalPrice = getTotalPrice();
		vm.itemsInCart = $localStorage.cart;
		
		function getTotalPrice() {
			var total = 0;
			var cartTotal = 0;
			var end = $localStorage.cart.length-1;
			for ( var i in $localStorage.cart) {
				total += $localStorage.cart[i].product.price * $localStorage.cart[i].quantity;
				cartTotal += $localStorage.cart[i].quantity;
				if (end == i) { vm.totalPrice = total; vm.cartItems = cartTotal; }
			}
			return total;
		}
		
		var product_exist = function (id) {
			for (var i = 0; i < $localStorage.cart.length; i++) {
				if ($localStorage.cart[i].product.id == id) {
					$localStorage.cart[i].quantity += 1;
					return true;
				}
			}
			return false;
		};
		
		vm.addToCart = function(id) {
			CartFactory.getProduct(id).then(function(product) {
				if (!product_exist(product.id)) {
					$localStorage.cart.push({ 
						product: product,
						quantity: 1
					});
					vm.totalPrice = getTotalPrice();
				}
			});
		}
		
		vm.removeFromCart = function(id) {
			for (var i = 0; i < $localStorage.cart.length; i++) {
				if ($localStorage.cart[i].product.id == id) {
					$localStorage.cart.splice(i, 1);
				}
			}
		}
		
		vm.finish = function() {
			var invoice = {
				date : new Date(),
				customer : null,
				status : 'ORDERED',
				totalPrice : getTotalPrice()
			};
			
			CartFactory.saveInvoice(invoice).then(function(inv) {
			});
		}
	}
	
})(angular);