(function(angular){
	'use strict';
	
	angular
		.module('gym.profil')
		.directive('profilEditModal', ProfilEditModal);
		
	function ProfilEditModal(){
		return{
			restrict: 'E',
			replace: 'true',
			link: ProfilEditModalLinkFunction,
			templateUrl: 'shared/modal/edit.profil/edit.profil.modal.html',
            scope: {
                modalData: '='
            },
			controller: ProfilEditModalController,
			controllerAs: 'vm',
			bindToControler: true
		};
	}
	function ProfilEditModalLinkFunction($scope, $element, $attrs, $ctrl){		
		$scope.$on('profil-modal', showModal );
		
		$element.on('hidden.bs.modal', function (e) {
			$scope.vm.cancel();
			console.log("profile edit modal - hidden");
		})
		//$('#profile-save').on('click', $scope.vm.save());
		
		function showModal (event, args){
			$scope.vm.getData( args );
			$element.modal('show');
		}
	}
	ProfilEditModalController.$inject = ['$scope', '$location', '$http']
	function ProfilEditModalController($scope, $location, $http){
		var vm = this;
		vm.unsaved = {};
		
		vm.getData = getData;
		vm.cancel = cancel;
		vm.save = save;
		
		initialize();
		
		///////////////////////////
		function initialize(){
			console.log("Board modal - initialization");
		}
		
		function getData(args) {
			console.log("Edit profile modal - get data");
			vm.mode = args.mode;
			vm.data = args.data;
		}
		
		function cancel(){
			vm.unsaved.name = '';
			vm.unsaved.surname = '';
			vm.unsaved.email = '';
		}
		

		function save(){
			
			var credencials = ($(".update-form").serializeObject());
			console.log("Profil update data");
			console.log(credencials);
			credencials.userId = vm.data.userId;
			credencials.login = vm.data.login;
			credencials.create_on = vm.data.create_on;
			console.log(credencials);

			$http.post('./rest/user/updateProfile', credencials)
				.then(function(data, status) {
					console.log("Profil update success");
					console.log(credencials);
				});
//			  	.error(function(data, status) {
//				    console.log("Profil update error");
//				    //$scope.errorMessage = 'Żądanie anulowano';
//				  });
			console.log("Koniec")
		};
		
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
	}
})(angular);