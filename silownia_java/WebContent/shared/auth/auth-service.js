(function() {
	"use strict";
	angular.module('gym.auth') 
		.factory('AuthService', ['$http', 'UserService', function ($http, UserService) {
		var service = {};

		service.login = function (credencials) {
			return $http.post('./rest/login/auth', credencials)
			.success(function(data, status) {
				console.log("Login success");
				//console.log(data);
			    UserService.setUser(data);
			})
		  	.error(function(data, status) {
			    console.log("Login error");
			  });
		};
		
		service.logout = function(){
			UserService.setUser(undefine);
		}

		service.isAuthenticated = function () {
			return !!UserService.getUser();
		};
		
		service.register = function(credencials){
			return $http.post('./rest/user/registerUser', credencials)
				.success(function(data, status) {
					console.log("Registration success");
					console.log(credencials);
				})
			  	.error(function(data, status) {
				    console.log("Registration error");
				  });
		}

		return service;
	}]);
})();
