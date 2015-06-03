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
	function MarketController($scope, $location, $http, UserService)
	{
		var vm = this;
		vm.planes;
		vm.mainPlans = mainPlans;
		vm.search = search;
		vm.podmien=podmien;
		vm.asign = asign;
		vm.remove = remove;
		vm.user = UserService.getUser();
		mainPlans();
		
		$http.get('./rest/plan/getPlansByNameAndCat?name=&catName=any&limit=0&shortVersion=true')
		.success(function(d){
			vm.data=d;
			for(var k in vm.data)
			{
				console.log("vm.data.owner: "+k);
				podmien(k);
				check(k);
			
			}
			console.log(d);
		})
		// pobieranie kategorii
		$http.get('./rest/plan/getCategories')
		.success(function(d){
			vm.categories=d;
			console.log(d);
		})
		
		function asign(butId){
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth()+1; //January is 0!
			var yyyy = today.getFullYear();

			if(dd<10) {
			    dd='0'+dd
			} 

			if(mm<10) {
			    mm='0'+mm
			} 

			today = yyyy+'-'+mm+'-'+dd;
			var cur = dd%7;
			console.log(today);
			var text = '{ "userId": '+vm.user.id+', "trainingPlanId": '+butId+', "startDate": "'+today+'", "isActive": 1, "currentDay":'+cur+'}';
			console.log(text);
			
			$http.post('./rest/plan/asignPlan',text)
				.success(function(data,status,headers,config){
					console.log("Udało się");
				})
				.error(function(){});
			vm.mainPlans();
			vm.search();
			$scope.$apply();
				
		}
		
		function remove(butId){
			var today = new Date();
			var dd = today.getDate();
			var mm = today.getMonth()+1; //January is 0!
			var yyyy = today.getFullYear();

			if(dd<10) {
			    dd='0'+dd
			} 

			if(mm<10) {
			    mm='0'+mm
			} 

			today = yyyy+'-'+mm+'-'+dd;
			var cur = dd%7;
			console.log(today);
			var text = '{ "userId": '+vm.user.id+', "trainingPlanId": '+butId+', "startDate": "'+today+'", "isActive": 1, "currentDay":'+cur+'}';
			console.log(text);
			
			$http.post('./rest/plan/removePlanFromUser',text)
				.success(function(data,status,headers,config){
					console.log("Udało się");
				})
				.error(function(){});
			vm.mainPlans();
			vm.search();
		}
		
		function mainPlans(){
			$http.get('./rest/plan/getUsersPlans?userId=' + vm.user.id +'&limit=0&active=2&short=true')
			.success(function(d){
				vm.planes = d;
				console.log("Update plans");
			});
		}
		
		function check(k){
			vm.data[k].current_day = 0;
			for(var i in vm.planes)
				{
					console.log("Porownuje "+vm.planes[i].training_plan_id+" z "+vm.data[k].training_plan_id);
					if(vm.planes[i].training_plan_id == vm.data[k].training_plan_id)
					{
						vm.data[k].current_day = 1;	
						$scope.$apply;
					}
				}
			}
		
		function podmien(k){
			$http.get('http://localhost:8080/silownia_java/rest/user/info?userId='+vm.data[k].owner).success(function(s){
				
				console.log("podmieniam "+k+" na "+ s.login);
				vm.data[k].owner=s.login;
			})
		}
		
		function search(){
			var name = $('#plan-name').val();
			var cat = $('#category-select option:selected').text();
			console.log(cat);
			$http.get('./rest/plan/getPlansByNameAndCat?name='+name+'&catName='+cat+'&limit=0&shortVersion=true')
			.success(function(d){
				vm.data=d;
				
				for(var k in vm.data)
					{
						console.log("vm.data.owner: "+k);
						podmien(k);
						check(k);
					
					}
				console.log("Szukam planow z "+name+" w nazwie z kategorii "+cat);
				console.log(d);
			})
		}
		
	}
	
})();