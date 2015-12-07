angular.module('myApp').controller('registerCtrl', ['$scope', 'usersFactory', 'registerFactory',
  function($scope, usersFactory){

	$scope.username;
	
	$scope.password;
	
	$scope.confirmPassword;
	
	$scope.user = {};
	$scope.user.password = $scope.password;
	$scope.user.username = $scope.username;

	$scope.getUsers = function(){
	
		usersFactory.getUsers().then(
			function(results){
				$scope.results = results;
			},
			function(error){
				console.log(error);
			}
		);
	};
	$scope.addUser = function(user){
		
		usersFactory.addUsers().then(
			function(results){
				$scope.results = results;
			},
			function(error){
				console.log(error);
			}
		);
	};
	


}]);