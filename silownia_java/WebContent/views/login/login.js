(function() {
	'use strict';

	angular.module('gym.login', [])
		.config(['$routeProvider', function($routeProvider) {
			$routeProvider.when('/login', {
			templateUrl: 'views/login/login.html',
			controller: 'LoginController',
			controllerAs: 'vm' 
		});
		}])
		.controller('LoginController', LoginController);

	LoginController.$inject = ['$scope', '$rootScope', 'AuthService', 'UserService', '$location', '$http'];
	function LoginController($scope, $rootScope, AuthService, UserService, $location, $http) {
		$scope.errorMessage = false;
		
		var vm = this;
		
		UserService.setUser(undefined);

		$('#login-button').on('click', function () {
//			var credentials = {
//				username: $('#input-username').val(),
//				password: $('#input-password').val()
//			};
//
//			AuthService.login(credentials).then(function (data) {
//				console.log(data);
//				if ( data.status == true){
//					var user = {
//							id : 1,
//							username: credentials.username
//						}
//					UserService.setUser(user);
//					$rootScope.$broadcast('SetUser');
//					$location.url('/home');
//					console.log('Poprawnie zalogowano: ' + user.username);
//				}
//				else{
//					$scope.errorMessage = 'Wrong username or password';
//					console.log('niepoprawne logowanie');
//				}	
//			});
			$.fn.serializeObject = function()
			{
			    var o = {};
			    var a = this.serializeArray();
			    $.each(a, function() {
			        if (o[this.name] !== undefined) {
			            if (!o[this.name].push) {
			                o[this.name] = [o[this.name]];
			            }
			            o[this.name].push(this.value || '');
			        } else {
			            o[this.name] = this.value || '';
			        }
			    });
			    return o;
			};
			var credencials = ($(".form-login").serializeObject());
			console.log("Wysylam do resta");
			console.log(credencials);

			
			
			$http.post('./rest/login/auth', credencials).
			  success(function(data, status, headers, config) {
				  console.log("Odebralem");
			    console.log(status);
			    console.log(data);
				  UserService.setUser(data);
			  }).
			  error(function(data, status, headers, config) {
			    console.log("Błąd");
			    console.log(status);
			  });
			//var object = $.extend({}, credencials, "userId":null,"name":null,"surname":null,"email":null,"create_on":null});
		});
		
		$('#register-button').on('click',function(){
			$location.url('/register');
			$scope.$apply();
			console.log('Redirect to register');
		});
		
	}
})();