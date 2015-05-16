(function(){
	'use strict';
	
	angular.module('gym.project', [
		'ngRoute',
		'gym.login',
		'gym.auth',
		'gym.register'])
	
		.config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
			//$routeProvider.otherwise({ redirectTo: '/login' });
		}])
})();