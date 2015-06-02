(function(){
	'use strict';
	
	angular.module('gym.project', [
		'ngRoute',
		'gym.login',
		'gym.auth',
		'gym.register',
		'gym.home',
		'gym.single.plan',
		'gym.plans',
		'gym.exercises',
		'gym.market'])

	
		.config(['$routeProvider', '$httpProvider', function ($routeProvider, $httpProvider) {
			$routeProvider.otherwise({ redirectTo: '/login' });
		}])
})();
