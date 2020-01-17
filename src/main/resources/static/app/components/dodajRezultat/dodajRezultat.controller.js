var evidencijaApp = angular.module("evidencijaApp");
evidencijaApp.controller("dodajRezultatCtrl", function($scope,$routeParams, $http, $location){
	
	$scope.ucesnici = [];
	$scope.takmicenja = [];
	
	$scope.rezultat = {};
	$scope.rezultat.ucesnik2Id = "";
	$scope.rezultat.ucesnik1Id = "";
	$scope.rezultat.ishodId = "";
	
	var baseUrl = "/api/ucesnici";
	var takUrl = "/api/takmicenja/rezultat";

var getUcesnike = function(){
		
	$http.get(baseUrl).then(
			function success(res){
				$scope.ucesnici = res.data;
			},
			function error(){
				alert("Something went wrong.");
			}
		);
	}
getUcesnike();


$scope.doRezultat = function(){

	var config = {params:{}}

	if($scope.rezultat.ucesnik2Id != ""){
		config.params.ucesnik2Id = $scope.rezultat.ucesnik2Id;
	}
	
	if($scope.rezultat.ucesnik1Id != ""){
		config.params.ucesnik1Id = $scope.rezultat.ucesnik1Id;
	}
	
	if($scope.rezultat.ishodId != ""){
		config.params.ishodId = $scope.rezultat.ishodId;
	}
	
	$http.get(takUrl, config).then(
			function success(res){
				$location.path("/ucesnici")
			},
			function error(){
				alert("Something went wrong.");
			}
		);
}

	
});