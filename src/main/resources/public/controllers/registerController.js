angular.module('myApp').controller('registerCtrl', ['$scope', 'usersFactory', 'registerFactory',
  function($scope, usersFactory, registerFactory){

	$scope.username;
	
	$scope.password;

	$scope.confirmPassword;
	
	$scope.user = {};
	$scope.user.userPassword = $scope.userPassword;
	$scope.user.userEmail = $scope.userEmail;

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
		
		usersFactory.addUser().then(
			function(results){
				$scope.results = results;
			},
			function(error){
				console.log(error);
			}
		);
	};
	$scope.validateEmail = function(email) {
		if (!registerFactory.validateEmail(email)) {
			$scope.emailIsInvalid = true;
		} else {
			$scope.emailIsInvalid = false;
		}
	};
}]);