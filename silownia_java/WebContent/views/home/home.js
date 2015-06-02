(function() {
	'use strict';

	angular.module('gym.home', [])
		.config(['$routeProvider', function($routeProvider) {
			$routeProvider.when('/home', {
			templateUrl: 'views/home/home.html',
			controller: 'HomeController',
			controllerAs: 'vm' 
		});
		}])
		.controller('HomeController', HomeController);
	
	HomeController.$inject = ['$scope', 'UserService', '$routeParams'];
	function HomeController($scope, UserService, $routeParams) {
		
		$scope.errorMessage = false;

		var vm = this;
		$scope.$on('$routeChangeSuccess', function () {
			vm.user = UserService.getUser();
			console.log("home");
			console.log(vm.user);
		});
	}
})();