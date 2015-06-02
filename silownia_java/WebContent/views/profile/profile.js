(function() {
	'use strict';

	angular.module('gym.profil', [])
		.config(['$routeProvider', function($routeProvider) {
			$routeProvider.when('/profil/:id', {
			templateUrl: 'views/profil/profil.html',
			controller: 'ProfilController',
			controllerAs: 'vm' 
		});
		}])
		.controller('ProfilController', ProfilController);

	ProfilController.$inject = ['$scope', 'UserService', '$routeParams', '$http'];
	function ProfilController($scope, UserService, $routeParams, $http) {
		
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
		
		// --- implementation ------------------------		
	}
})();