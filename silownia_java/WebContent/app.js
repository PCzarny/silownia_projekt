(function(){
	'use strict';
	
	angular.module('gym.project', [
		'ngRoute',
		'gym.login',
		'gym.auth',
		'gym.register',
		'gym.home',
		'gym.single.plan',
		'gym.plans',
		'gym.exercises',
		'gym.profil',
		'gym.market'])

	
		.config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
			$routeProvider.otherwise({ redirectTo: '/login' });
		}])
		.controller('MainController', MainController);
	
		MainController.$inject = ['$scope', '$rootScope', 'AuthService', 'UserService', '$location'];
		function MainController($scope, $rootScope, AuthService, UserService, $location){
			var vm = this;
			vm.isAuth = false;
			vm.logOut = logOut;
			
			$rootScope.$on('SetUser', function(){
				vm.isAuth = AuthService.isAuthenticated();
			})
			
			$scope.$on('$routeChangeSuccess', function () {
				//console.log("Website reloaded")
				if(!vm.isAuth){
					//if ( $location.get() != "/register" )
					//$location.path("/login");
				}
			});
			
			function logOut(){
				UserService.setUser(undefined);
			}
		}	
})();
