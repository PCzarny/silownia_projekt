(function() {
	'use strict';

	angular.module('gym.market', [])
		.config(['$routeProvider', function($routeProvider) {
			$routeProvider.when('/market', {
			templateUrl: 'views/market/market.html',
			controller: 'MarketController',
			controllerAs: 'vm'
		});
		}])
		.controller('MarketController',MarketController);
	
	MarketController.$inject = ['$scope', '$location', '$http', 'UserService'];
	function MarketController($scoper, $location, $http, UserService)
	{
		var vm = this;
		vm.search = search;
		
		$http.get('./rest/plan/getPlansByNameAndCat?name=&catName=any&limit=0&shortVersion=true')
		.success(function(d){
			vm.data=d;
			console.log(d);
		})
		// pobieranie kategorii
		$http.get('./rest/plan/getCategories')
		.success(function(d){
			vm.categories=d;
			console.log(d);
		})
		
		function search(){
			var name = $('#plan-name').val();
			var cat = $('#category-select option:selected').text();
			console.log(cat);
			$http.get('./rest/plan/getPlansByNameAndCat?name='+name+'&catName='+cat+'&limit=0&shortVersion=true')
			.success(function(d){
				vm.data=d;
				console.log("Szukam planow z "+name+" w nazwie z kategorii "+cat);
				console.log(d);
			})
		}
		
	}
	
})();