(function() {
	"use strict";
	angular.module('gym.auth') 
		.service('AuthService', ['$http', 'UserService', function ($http, UserService) {
		var service = {};

		service.login = function (credentials) {
			return $http.post('./rest/login/authenticate?username=' + credentials.username + '&password=' + credentials.password)
			  .then(function (res) {
				  console.log(res);
				  return res.data;
			  });
		};

		service.isAuthenticated = function () {
			return !!UserService.getUser();
		};

		return service;
	}]);
})();
