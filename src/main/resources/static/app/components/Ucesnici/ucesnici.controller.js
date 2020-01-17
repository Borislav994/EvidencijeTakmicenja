var evidencijaApp = angular.module("evidencijaApp");
evidencijaApp.controller("ucesniciCtrl", function($scope,$routeParams, $http, $location){
	
	$scope.ucesnici = [];
	$scope.takmicenja = [];
	
	$scope.ucesnik = {};
	$scope.ucesnik.naziv = "";
	$scope.ucesnik.mesto = "";
	$scope.ucesnik.email = "";
	$scope.ucesnik.takmicenjeId = "";
	
	$scope.searchParams = {};
	$scope.searchParams.takmicenjeNaziv = $location.search().takmicenjeNaziv != undefined ? $location.search().takmicenjeNaziv : "";
	$scope.searchParams.naziv = $location.search().naziv != undefined ? $location.search().naziv : "";

	
	$scope.pageNum = 0;
	$scope.totalPages = 1
	
	var baseUrl = "/api/ucesnici";
	var takUrl = "/api/takmicenja";
	
var getTakmicenja = function(){
		
		var promise = $http.get(takUrl);
		
		promise.then(
			function success(res){
				$scope.takmicenja = res.data;
				getUcesnike();
				
			},
			function error(){
				alert("Unsuccessful fetch!")
			}
		);

	}

var getUcesnike = function(){
	
var config = { params: {} };
	
	// Dakle, polja config.params objekta moraju da se zovu kako back-end
	// ocekuje
	if($scope.searchParams.takmicenjeNaziv != ""){
		$location.search("takmicenjeNaziv", $scope.searchParams.takmicenjeNaziv);
		config.params.takmicenjeNaziv = $scope.searchParams.takmicenjeNaziv;
	}
	
	if($scope.searchParams.naziv != ""){
		config.params.naziv = $scope.searchParams.naziv;
	}

	config.params.pageNum = $scope.pageNum;
	
	$http.get(baseUrl, config).then(
		function success(res){
			$scope.ucesnici = res.data;
			$scope.totalPages = res.headers("totalPages");
		},
		function error(){
			alert("Something went wrong.");
		}
	);
}
getTakmicenja();

$scope.doAdd = function(){
	$http.post(baseUrl, $scope.ucesnik).then(
		function success(){
			getUcesnike();
			
		},
		function error(){
			alert("Couldn't add activity!");
		}
	);
}

$scope.doDelete = function(id){
	var promise = $http.delete(baseUrl + "/" + id);
	promise.then(
		function success(){
			getUcesnike();
		},
		function error(){
			alert("Something went wrong.");
		}
	);
}

$scope.goToEdit = function(id){
	$location.path("/ucesnici/edit/" + id);
}

$scope.goToDodajRezultat = function(){
	$location.path("/ucesnici/rezultat");
}

$scope.doSearch = function(){

	var params =  {};

	if($scope.searchParams.takmicenjeNaziv != ""){
		params.takmicenjeNaziv = $scope.searchParams.takmicenjeNaziv;
	}
	
	if($scope.searchParams.naziv != ""){
		params.naziv = $scope.searchParams.naziv;
	}
	
	$location.search(params);
}

$scope.changePage = function(direction){
	$scope.pageNum = $scope.pageNum + direction;
	getUcesnike();
}


	
});