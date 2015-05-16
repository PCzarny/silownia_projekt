(function() {
	'use strict';

	angular.module('gym.register', [])
		.config(['$routeProvider', function($routeProvider) {
			$routeProvider.when('/register', {
			templateUrl: 'views/register/register.html',
			controller: 'RegisterController'
		});
		}])
		.controller('RegisterController', RegisterController);

	RegisterController.$inject = ['$scope', '$rootScope', '$location'];
	function RegisterController($scope, $rootScope, $location) {
		$scope.errorMessage = true;
		$('#submit-button').on('click', function () {
			if ( $('#input-password').val() !== $('#input-password-rep').val() ){
				$scope.errorMessage = false;
				return;
			}
				
			var credentials = {
				username: $('#input-username').val(),
				email: $('#input-email').val(),
				password: $('#input-password').val()
			};
			// Register service add user
			$location.url('/login');
			console.log('Poprawnie zarejestrowanie');
		});
	}
})();