(function() {
	'use strict';

	angular.module('gym.plans', [])
		.config(['$routeProvider', function($routeProvider) {
			$routeProvider.when('/plans', {
			templateUrl: 'views/plans/plans.html',
			controller: 'PlansController',
			controllerAs : 'vm'
		});
		}])
		.controller('PlansController', PlansController);

	PlansController.$inject = ['$scope', '$location', '$http', 'UserService'];
	function PlansController($scope, $location, $http, UserService)
	{
		var vm = this;
		vm.user = UserService.getUser();
		
		vm.active = active;
		vm.nonactive = nonactive;
		vm.search = search;
		vm.showTraining = showTraining;
		
		$scope.errorMessage = false;
		
		vm.active();
		
		// ----------------- implementation --------------------------
		function active(){
			$http.get('./rest/plan/getUsersPlans?userId=' + vm.user.id +'&limit=0&active=1&short=true')
			.success(function(d){
				vm.data = d;
				console.log("Activer user plans");
			});
		}
		
		function nonactive(){
			$http.get('./rest/plan/getUsersPlans?userId=' + vm.user.id +'&limit=0&active=0&short=true')
			.success(function(d){
				vm.data = d;
				console.log("Nonactive user plans");
			});
		}
		
		function search(){
			console.log("Search");
		}
		
		function showTraining(id){
			$location.path("/plan/" + id);
			console.log("plan" + id);
		}
	}
})();