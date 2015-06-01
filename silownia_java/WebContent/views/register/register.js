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

	RegisterController.$inject = ['$scope', '$location', '$http', 'AuthService'];
	function RegisterController($scope, $location, $http, AuthService) {
		$scope.errorMessage = false;
		
		console.log(AuthService.isAuthenticated());
		
		
		$('#submit-button').on('click', function () {
			if ( $('#input-password').val() !== $('#input-password-rep').val() ){
				$scope.errorMessage = 'Wprowadzono różne hasła';
				return;
			}
				
			var credentials = {
				username: $('#input-username').val(),
				name: $('#input-name').val(),
				surname: $('#input-surname').val(),
				email: $('#input-email').val(),
				password: $('#input-password').val()
			};
			
			$http.get('./rest/register/doregister?username=' + credentials.username + '&password=' + credentials.password + '&email=' + credentials.email + '&name=' + credentials.name + '&surname=' + credentials.surname)
			
			// Register service add user
			$location.url('/login');
			console.log('Poprawnie zarejestrowanie');
		});
	}
})();