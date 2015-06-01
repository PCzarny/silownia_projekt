(function() {
	'use strict';

	angular.module('gym.login', [])
		.config(['$routeProvider', function($routeProvider) {
			$routeProvider.when('/login', {
			templateUrl: 'views/login/login.html',
			controller: 'LoginController',
			controllerAs: 'vm' 
		});
		}])
		.controller('LoginController', LoginController);

	LoginController.$inject = ['$scope', '$rootScope', 'AuthService', 'UserService', '$location'];
	function LoginController($scope, $rootScope, AuthService, UserService, $location) {
		$scope.errorMessage = false;
		
		var vm = this;
		
		UserService.setUser(undefined);

		$('#login-button').on('click', function () {
			var credentials = {
				username: $('#input-username').val(),
				password: $('#input-password').val()
			};

			AuthService.login(credentials).then(function (data) {
				console.log(data);
				if ( data.status == true){
					var user = {
							id : 1,
							username: credentials.username
						}
					UserService.setUser(user);
					$rootScope.$broadcast('SetUser');
					$location.url('/home');
					console.log('Poprawnie zalogowano: ' + user.username);
				}
				else{
					$scope.errorMessage = 'Wrong username or password';
					console.log('niepoprawne logowanie');
				}	
			});
		});
		
		$('#register-button').on('click',function(){
			$location.url('/register');
			$scope.$apply();
			console.log('Redirect to register');
		});
	}
})();