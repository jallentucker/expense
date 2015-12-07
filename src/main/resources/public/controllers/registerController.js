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
	$scope.confirmPassword = function(password1, password2) {
		if (!registerFactory.confirmPassword(password1, password2)) {
			$scope.passwordsDiffer = true;
		} else {
			$scope.passwordsDiffer = false;
		}
	};
	$scope.validateEmail = function(email) {
		if (!registerFactory.validateEmail(email)) {
			$scope.emailIsInvalid = true;
		} else {
			$scope.emailIsInvalid = false;
		}
	};
	$scope.validatePassword = function(password) {
		if (!registerFactory.validatePassword(password)) {
			$scope.passwordIsInvalid = true;
		} else {
			$scope.passwordIsInvalid = false;
		}
	};
}]);