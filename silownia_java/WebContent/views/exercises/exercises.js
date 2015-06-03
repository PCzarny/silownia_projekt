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
	
	
	
		
	ExercisesController.$inject = ['$scope', '$location', '$http','$document', 'UserService'];
		function ExercisesController($scope, $location, $http,$document, UserService)
		{
			var vm = this
			vm.user = UserService.getUser();
			vm.getUserExercises = getUserExercises;
			vm.getFavouriteExercises = getFavouriteExercises ;
			vm.getAllExercises = getAllExercises ;
			vm.addToFavourite = addToFavourite ;
			vm.addExercise = addExercise ; 
			vm.showAdd = true ;
			vm.add =add ; 
			vm.showDelete = true ; 
			vm.getUserExercises();
			
			console.log("ok");
			function getUserExercises(){
				$(".content").show();
				$(".add").hide();
				$http.get('./rest/exercise/UserExercises?userId=' + vm.user.id)
				.success(function(d){
					vm.data = d;
					console.log(d);

				});				
			}
			
			
			function getFavouriteExercises(){
				$(".content").show();
				$(".add").hide(); 
				$http.get('./rest/exercise/Favourite?userId=' + vm.user.id)
				.success(function(d){
					vm.data = d;
					console.log(d);
					vm.showDelete = "true";
				
				});
				
				
				console.log("hide");
					
			}
			
			
			function add(){
				
				var exer = ($(".form-horizontal").serializeObject());
				exer.exercise_id = null ;
				exer.user_id = vm.user.id ;
				console.log(exer);
				
				$http.post('./rest/exercise/addExercise', exer)
				.success(function(data, status, headers, config) {
					console.log("Poprawnie dodano");
					
//					//console.log(credencials);
//					//$location.url('/login');
				})
			  	.error(function(data, status, headers, config) {
				    //console.log("Błąd rejestracji");
//				    $scope.errorMessage = 'Błędna rejestracja';
				  });
				
				getUserExercises();
				
				
				
			}
			
			function addExercise(){
				console.log("addExercise");
				
				$(".content").hide();
				$(".add").show();
				
				
			}
			
			function addToFavourite(id){
				console.log("add");
				
		
				
				$http.get('./rest/exercise/addFavourite?userId=' + vm.user.id+'&exerciseId='+id);
				console.log(id);
				
				
			}
			
			function getAllExercises(){
				
				$http.get('./rest/exercise/AllExercises')
				.success(function(d){
					vm.data = d;
					vm.showDelete = "false";
					console.log(d);
				});
					
			}

		}

})();
