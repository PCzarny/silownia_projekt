/**
 * 
 */

(function() {
	'use strict';
	
	angular.module('gym.exercises',[])
		.config(['$routeProvider', function($routeProvider) {
			$routeProvider.when('/exercises', {
			templateUrl: 'views/exercises/exercises.html',
			controller: 'ExercisesController',
			controllerAs : 'vm'
		});
		}]).controller('ExercisesController',ExercisesController);
		
	ExercisesController.$inject = ['$scope', '$location', '$http', 'UserService'];
		function ExercisesController($scope, $location, $http, UserService)
		{
			var vm = this
			vm.user = UserService.getUser();
			vm.getUserExercises = getUserExercises;
			
			
			vm.getUserExercises();
			
			console.log("ok");
			function getUserExercises(){
				
				$http.get('./rest/exercise/UserExercises?userId=' + vm.user.id)
				.success(function(d){
					vm.data = d;
					console.log("User Exercises");
				});
					
			}
			
			
		}

})();
