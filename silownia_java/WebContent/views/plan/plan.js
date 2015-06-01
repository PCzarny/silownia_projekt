(function () {
	'use strict';

	angular.module('gym.plan')
	.config(['$routeProvider', function($routeProvider) {
	  $routeProvider.when('/plan', {
		templateUrl: 'views/plan/plan.html',
		controller: 'PlanController'
	  });
	}])

	.controller('PlanController', PlanController);

	PlanController.$inject = ['$scope', '$routeParams'];
	function PlanController($scope, $routeParams) {
		//$scope.planId = $routeParams['plan'];
		
		console.log("plan");
	}
})();
