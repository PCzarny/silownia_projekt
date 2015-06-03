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

	LoginController.$inject = ['$scope', '$rootScope', 'AuthService', 'UserService', '$location', '$http'];
	function LoginController($scope, $rootScope, AuthService, UserService, $location, $http) {
		
		var vm = this;
		
		$scope.$on('$routeChangeSuccess', function () {
			$scope.errorMessage = false;
			UserService.setUser(undefined);
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
			console.log("Wysylam do resta");
			console.log(credencials);
			
			$http.post('./rest/login/auth', credencials)
				.success(function(data, status) {
					console.log("Odebralem");
				    console.log(status);
				    console.log(data);
				    UserService.setUser(data);
				    console.log(AuthService.isAuthenticated());
				    $rootScope.$broadcast('SetUser');
					$location.url('/home');
				})
			  	.error(function(data, status) {
				    console.log("Błąd");
				    $scope.errorMessage = 'Wrong username or password';
				    console.log(status);
				  });
		});
		
		$('#register-button').on('click',function(){
			$location.url('/register');
			$scope.$apply();
			console.log('Redirect to register');
		});
		
	}
})();