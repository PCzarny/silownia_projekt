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
	function RegisterController($scope, $location, $http, UserService)
	{
		var vm = this;
		vm.user = UserService.getUser();
		
		$scope.errorMessage = false;
		
		$http.get('./rest/plan/getPlans?byXXX=1&value=' + vm.user.id +'&active=2&short=true')
			.success(function(d){
				vm.data = d;
				console.log("Succes");
			});
	}
})();