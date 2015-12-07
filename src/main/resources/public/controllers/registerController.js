angular.module('myApp').controller('registerCtrl', ['$scope', 'usersFactory', 'registerFactory',
  function($scope, usersFactory){

	$scope.username;
	
	$scope.password;
	
	$scope.confirmUserPassword;
	
	$scope.user = {};
	$scope.user.userPassword;
	$scope.user.userEmail;

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
		console.log(user.userPassword);
		console.log(user.userEmail);
		usersFactory.addUser().then(
			function(results){
				console.log("success");
				$scope.results = results;
			},
			function(error){
				console.log("error");
				console.log(error);
			}
		);
	};
	


}]);