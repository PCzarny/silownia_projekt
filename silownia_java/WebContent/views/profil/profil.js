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
		vm.id = $routeParams['id'];
		
		vm.editUser = editUser;
		
		$http.get('./rest/user/info?userId=' + vm.id)
			.success(function(d){
				vm.data = d;
				console.log("User id " + vm.id);
				console.log(vm.data);
			});
		
		// --- implementation ------------------------
		
		function editUser(){
			console.log("Edit user " + vm.id)
		}
	}
})();