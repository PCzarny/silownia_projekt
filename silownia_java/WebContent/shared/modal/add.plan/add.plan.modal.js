(function(angular){
	'use strict';
	
	angular
		.module('gym.plans')
		.directive('addPlanModule', AddPlanModal);
		
	function AddPlanModal(){
		return{
			restrict: 'E',
			replace: 'true',
			link: AddPlanModalLinkFunction,
			templateUrl: 'shared/modal/add.plan/add.plan.modal.html',
            scope: {
                modalData: '='
            },
			controller: AddPlanModalController,
			controllerAs: 'vm',
			bindToControler: true
		};
	}
	function AddPlanModalLinkFunction($scope, $element, $attrs, $ctrl){		
		$scope.$on('add-plan-modal', showModal );
		
		$element.on('hidden.bs.modal', function (e) {
			$scope.vm.cancel();
			console.log("add-plan-modal - hidden");
		})
		
		function showModal (event, args){
			$scope.vm.getData( args );
			$element.modal('show');
		}
	}
	AddPlanModalController.$inject = ['$scope', '$location', '$http']
	function AddPlanModalController($scope, $location, $http){
		var vm = this;
		vm.unsaved = {};
		
		vm.getData = getData;
		vm.cancel = cancel;
		vm.save = save;
		
		initialize();
		
		///////////////////////////
		function initialize(){
			console.log("add-plan-modal - initialization");
		}
		
		function getData(args) {
			console.log("add-plan-modal - get data");
			vm.data = args.data;
		}
		
		function cancel(){
			vm.unsaved.name = '';
			vm.unsaved.surname = '';
			vm.unsaved.email = '';
		}
		

		function save(){
			
			var credencials = ($(".update-plan-form").serializeObject());
			console.log("Plan adde data");
			console.log(credencials);
			
			credencials.trainingDays = null;
			credencials.start_time = null;
			credencials.is_active = null;
			credencials.current_day = null;
			credencials.period = 0;
			credencials.user_id = vm.data.userId;
			credencials.training_plan_id = null;
			credencials.category_id = vm.data.userId;
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