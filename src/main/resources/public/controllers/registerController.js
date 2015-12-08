angular.module('myApp').controller('registerCtrl', ['$scope', 'usersFactory', 'validationFactory', 'emailRegex', 'passwordRegex',
  function($scope, usersFactory, validationFactory, emailRegex, passwordRegex){

	$scope.username;
	
	$scope.password;

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
		if (!validationFactory.confirmPassword(password1, password2) && password1 !== undefined && password2 !== undefined) {
			$scope.passwordsDiffer = true;
		} else {
			$scope.passwordsDiffer = false;
		}
	};
	$scope.validateEmail = function(email) {
		if (!validationFactory.validateField(emailRegex, email) && email !== undefined) {
			$scope.emailIsInvalid = true;
		} else {
			$scope.emailIsInvalid = false;
		}
	};
	$scope.validatePassword = function(password) {
		if (!validationFactory.validateField(passwordRegex, password) && password !== undefined) {
			$scope.passwordIsInvalid = true;
		} else {
			$scope.passwordIsInvalid = false;
		}
	};
}]);