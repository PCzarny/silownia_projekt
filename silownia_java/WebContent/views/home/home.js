(function() {
	'use strict';

	angular.module('gym.home', [])
		.config(['$routeProvider', function($routeProvider) {
			$routeProvider.when('/home', {
			templateUrl: 'views/home/home.html'
		});
		}])
})();