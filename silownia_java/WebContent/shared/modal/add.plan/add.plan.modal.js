(function(angular){
	'use strict';
	
	angular
		.module('gym.plans')
		.directive('addPlanModal', AddPanelModal);
		
	function AddPanelModal(){
		return{
			restrict: 'E',
			replace: 'true',
			link: AddPanelModalLinkFunction,
			templateUrl: 'shared/modal/add.plan/add.plan.modal.html',
            scope: {},
			controller: AddPanelModalController,
			controllerAs: 'vm',
			bindToControler: true
		};
	}
	function AddPanelModalLinkFunction($scope, $element, $attrs, $ctrl){		
		$scope.$on('add-plan-modal', showModal );
		
		$element.on('hidden.bs.modal', function (e) {
			$scope.vm.cancel();
			console.log("plan add modal - hidden");
		})
		
		function showModal (event, args){
			$element.modal('show');
		}
	}
	AddPanelModalController.$inject = ['$scope', '$location', '$http', 'UserService']
	function AddPanelModalController($scope, $location, $http, UserService){
		var vm = this;
		vm.unsaved = {};
		
		vm.cancel = cancel;
		vm.save = save;
		vm.categories = [];
		
		initialize()
		///////////////////////////
		function initialize()
		{
			$http.get('./rest/plan/getCategories')
			.success(function(d){
				vm.categories = d;
				console.log("Get plan categories");
			});
			vm.user = UserService.getUser();
		}
		
		function cancel(){
			vm.unsaved.name = '';
		}
		
		function save(){
			
			var credencials = {};
			credencials.name = $('#planName').val();
			credencials.categoryId = $('#planCategory option:selected').val();
			credencials.categoryName = $('#planCategory option:selected').text();
			credencials.trainingDays = null;
			credencials.start_time = null;
			credencials.current_day = null;
			credencials.period = null;
			
			credencials.user_id = vm.user.id;
			credencials.training_plan_id = null;
			credencials.owner = null;
			
			
			console.log(credencials);

			$http.post('./rest/plan/addPlanRow', credencials)
				.success(function(data, status) {
					console.log("Add plan success");
					console.log(credencials);
				})
			  	.error(function(data, status) {
				    console.log("Add plan error");
				    //$scope.errorMessage = 'Żądanie anulowano';
				  });
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