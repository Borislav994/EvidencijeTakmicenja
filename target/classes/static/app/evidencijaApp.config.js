var evidencijaApp = angular.module("evidencijaApp");
evidencijaApp.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/ucesnici', {
			templateUrl : '/app/components/ucesnici/ucesnici.html'
		})
		.when('/ucesnici/edit/:id', {
			templateUrl : '/app/components/edit-ucesnici/edit-ucesnici.html'
		})
		.when('/ucesnici/rezultat', {
			templateUrl : '/app/components/dodajRezultat/dodajRezultat.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);