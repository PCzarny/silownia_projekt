(function() {
	"use strict";
	angular.module('gym.auth')
		.factory('UserService', function ($rootScope, $http) {
			var service = {};
			var user = {};

			service.setUser = function (newUser) {
				user = newUser;
				console.log(user);
				$rootScope.$broadcast('SetUser');			
			};

			service.getUser = function () {
				return user;
			};

			return service;
		});
})();
