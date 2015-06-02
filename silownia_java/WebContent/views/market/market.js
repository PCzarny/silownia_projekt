(function() {
	'use strict';

	angular.module('gym.market', [])
		.config(['$routeProvider', function($routeProvider) {
			$routeProvider.when('/market', {
			templateUrl: 'views/market/market.html'
		});
		}])
})();