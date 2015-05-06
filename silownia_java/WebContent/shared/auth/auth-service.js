(function() {
	"use strict";
	angular.module('gym.auth') 
		.factory('AuthService', ['$http', 'UserService', function ($http, UserService) {
		var service = {};

		service.login = function (credentials) {
			return $http.get('./rest/login/authenticate?username=' + credentials.username + '&password=' + credentials.password)
			.then(function (res) {
				  console.log(res.data);
				  return res.data;
			  });
		};

		service.isAuthenticated = function () {
			return !!UserService.getUser();
		};

		return service;
	}]);
})();
