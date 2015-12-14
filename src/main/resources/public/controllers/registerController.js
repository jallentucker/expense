angular.module('myApp').controller('registerCtrl', ['$scope', 'usersFactory', 'validationFactory', 'emailRegex', 'passwordRegex',
  function($scope, usersFactory, validationFactory, emailRegex, passwordRegex){

	$scope.username;
	
	$scope.password;

	$scope.user = {};
	$scope.user.userPassword;
	$scope.user.userEmail;
	$scope.confirmUserPassword;

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
	$scope.addUser = function(){
		if($scope.validateUser($scope.user)) {
			usersFactory.addUser($scope.user).then(
				function(results){
					console.log(results);
					window.location.href = "http://localhost:8080/login";
				},
				function(error){
					console.log(error);
				}
			);
		}
	};
	$scope.confirmPassword = function(password, confirmation) {
		if (!validationFactory.confirmPassword(password, confirmation) && password !== undefined && confirmation !== undefined) {
			$scope.passwordsDiffer = true;
		} else {
			$scope.passwordsDiffer = false;
		}
	};
	$scope.validateEmailOnBlur = function(email) {
		if (email !== undefined && !validationFactory.validateField(emailRegex, email)) {
			$scope.emailIsInvalid = true;
		} else {
			$scope.emailIsInvalid = false;
		}
	};
	$scope.validateEmailOnSubmit = function(email) {
		if (!validationFactory.validateField(emailRegex, email)) {
			$scope.emailIsInvalid = true;
		} else {
			$scope.emailIsInvalid = false;
		}
	};
	$scope.validatePasswordOnBlur = function(password) {
		if (password !== undefined && !validationFactory.validateField(passwordRegex, password)) {
			$scope.passwordIsInvalid = true;
		} else {
			$scope.passwordIsInvalid = false;
		}
	};
	$scope.validatePasswordOnSubmit = function(password) {
		if (!validationFactory.validateField(passwordRegex, password)) {
			$scope.passwordIsInvalid = true;
		} else {
			$scope.passwordIsInvalid = false;
		}
	};
	$scope.validateUser = function(user) {
		$scope.confirmPassword(user.userPassword, user.confirmUserPassword);
		$scope.validateEmailOnSubmit(user.userEmail);
		$scope.validatePasswordOnSubmit(user.userPassword);
		if ($scope.passwordsDiffer || $scope.emailIsInvalid || $scope.passwordIsInvalid) {
			return false;
		} else {
			return true;
		}
	};
}]);