(function() {
	"use strict";
	angular.module('gym.auth')
		.factory('UserService', function ($http) {
			var service = {};
			var user = {
				id: 1,
				username: 'user'
			};

			service.setUser = function (newUser) {
				console.log(newUser);
				user = newUser;
			};

			service.getUser = function () {
				return user;
			};

			return service;
		});
})();
