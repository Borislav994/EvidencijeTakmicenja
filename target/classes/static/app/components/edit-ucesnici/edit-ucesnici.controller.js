var evidencijaApp = angular.module("evidencijaApp");
evidencijaApp.controller("editUcesniciCtrl", function($scope,$routeParams, $http, $location){
	
	$scope.ucesnici = [];
	$scope.takmicenja = [];
	
	$scope.ucesnik = {};
	$scope.ucesnik.naziv = "";
	$scope.ucesnik.mesto = "";
	$scope.ucesnik.email = "";
	$scope.ucesnik.odigraoSusreta = "";
	$scope.ucesnik.brBodova = "";
	$scope.ucesnik.takmicenjeId = "";
	
	var baseUrl = "/api/ucesnici/" + $routeParams.id;
	var takUrl = "/api/takmicenja";
	
var getTakmicenja = function(){
		
		var promise = $http.get(takUrl);
		
		promise.then(
			function success(res){
				$scope.takmicenja = res.data;
				
				
			},
			function error(){
				alert("Unsuccessful fetch!")
			}
		);

	}
getTakmicenja();

var getUcesnike = function(){
	
	var promise = $http.get(baseUrl);
	promise.then(
		function uspeh(odg){
			$scope.ucesnik = odg.data;
		},
		function neuspeh(){
			console.log("Something went wrong!");
		}
	);
}
getUcesnike();


$scope.doEdit = function() {
	$http.put(baseUrl, $scope.ucesnik).then(function success() {
		$location.path("/ucesnici");
	}, function error() {
		alert("Something went wrong.");
	});
}

	
});