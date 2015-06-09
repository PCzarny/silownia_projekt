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

	LoginController.$inject = ['$scope', 'AuthService', '$location'];
	function LoginController($scope, AuthService, $location) {
		
		var vm = this;
		
		$scope.$on('$routeChangeSuccess', function () {
			$scope.errorMessage = false;
		});
		
		$('#login-button').on('click', function () {
			
			$.fn.serializeObject = function()
			{
			    var o = {};
			    var a = this.serializeArray();
			    $.each(a, function() {
			        if (o[this.name] !== undefined) {
			            if (!o[this.name].push) {
			                o[this.name] = [o[this.name]];
			            }
			            o[this.name].push(this.value || '');
			        } else {
			            o[this.name] = this.value || '';
			        }
			    });
			    return o;
			};
			var credencials = ($(".form-login").serializeObject());
			console.log("Login data sending to server");
			console.log(credencials);
			
			AuthService.login(credencials)
				.success(function(data, status) {
					console.log("Login function success");
					$location.path('/home');
				})
				.error(function(data, status){
					$scope.errorMessage = 'Nieprawidłowy login lub hasło';
					console.log("Login function error");
				});
		});
		
		$('#register-button').on('click',function(){
			$location.path('/register');
			$scope.$apply();
			console.log('Redirect to register');
		});
		
	}
})();