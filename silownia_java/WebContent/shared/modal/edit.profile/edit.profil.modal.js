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
			templateUrl: 'shared/modal/edit.profile/edit.profile.modal.html',
            scope: {
                modalData: '='
            },
			controller: ProfilEditModalController,
			controllerAs: 'vm',
			bindToControler: true
		};
	}
	function ProfilEditModalLinkFunction($scope, $element, $attrs, $ctrl){
		console.log("Board modal modal - link function");
		
		$scope.$on('add-company', addMode );
		
		function addMode (event, args){
			$scope.vm.getAddData( args );
			$element.modal('show');
		}
		$scope.$on('edit-company', editMode );
		
		$element.on('hidden.bs.modal', function (e) {
			$scope.vm.cancel();
			console.log("Board edit modal - hidden");
		})
		
		function editMode (event, args){
			$scope.vm.getEditData( args );
			$element.modal('show');
		}
	}
	BoardEditModalController.$inject = ['$scope', '$location', 'BoardService']
	function BoardEditModalController($scope, $location, BoardService){
		var vm = this;
		vm.countries = {};
		vm.unsaved = {};
		
		vm.getEditData = getEditData;
		vm.getAddData = getAddData;
		vm.getRegions = getRegions;
		vm.cancel = cancel;
		
		initialize();
		
		///////////////////////////
		function initialize(){
			console.log("Board modal - initialization");
			BoardService.getCountries(function(d){
				vm.countries = d;
			});
			console.log("Board modal - get countries");
		}
		
		function getEditData(args) {
			console.log("Board modal - receive 'edit-company'");
			vm.mode = args.mode;
			vm.data = args.data;
			vm.regionData = [vm.data.region];
			vm.countryData = [vm.data.country];
			vm.selectedRegion = vm.regionData[0];
			vm.selectedCountry = vm.countryData[0];
		}
		
		function getAddData(args) {
			console.log("Board modal - receive 'add-company'");
			vm.mode = args.mode;
			vm.data = [];
			
			vm.countryData = vm.countries;
			vm.selectedCountry = null;
			
			vm.regionData = [];
			vm.selectedRegion = null;
		}
		
		function getRegions(){
			BoardService.getRegions(vm.selectedCountry.id, function(d){
				vm.regionData = d;
			});
			console.log("Board modal - get regions");
		}
		
		function cancel(){
			vm.unsaved.name = '';
			vm.unsaved.vatNumber = '';
			vm.unsaved.zonesNumber = '';
			vm.unsaved.street = '';
			vm.unsaved.cityName = '';
			vm.unsaved.postalCode = '';
		}
	}
})(angular);