(function() {
	"use strict";
	angular.module('gym.auth')
		.factory('UserService', function ($rootScope, $http) {
			var service = {};
			var user = {};

			service.setUser = function (newUser) {
				console.log(newUser);
				console.log("cos doszlo");
				user = newUser;
				console.log(user);
				$rootScope.$broadcast('SetUser');
				
				if(user){
					$(document).find("ul.known").show();
					$(document).find("ul.unknown").hide();
				}
				else{
					$(document).find("ul.known").hide();
					$(document).find("ul.unknown").show();
				}
					
			};

			service.getUser = function () {
				return user;
			};

			return service;
		});
})();
