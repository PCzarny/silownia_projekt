(function() {
	'use strict';

	angular.module('gym.single.plan', [])
		.config(['$routeProvider', function($routeProvider) {
			$routeProvider.when('/plan/:plan', {
			templateUrl: 'views/single-plan/single-plan.html',
			controller: 'PlanController',
			controllerAs: 'vm' 
		});
		}])
		.controller('PlanController', PlanController);

	PlanController.$inject = ['$scope', 'UserService', '$routeParams', '$http'];
	function PlanController($scope, UserService, $routeParams, $http) {
		
		$scope.errorMessage = false;

		var vm = this;
		vm.user = UserService.getUser();
		vm.planId = $routeParams['plan'];
		
		$http.get('./rest/plan/getPlanByID?planId='+ vm.planId +'&shortVersion=false')
			.success(function(d){
				vm.data = d;
				console.log("Plan id " + vm.planId);
				console.log(vm.data);
			});
	}
})();