angular.module('myApp').controller('registerCtrl', ['$scope', 'usersFactory', 'validationFactory', 'emailRegex', 'passwordRegex',
  function($scope, usersFactory, validationFactory, emailRegex, passwordRegex){

	// Sets variables
	$scope.username;
	$scope.password;
	$scope.user = {};
	$scope.user.userPassword;
	$scope.user.userEmail;
	$scope.confirmUserPassword;

	// Gets the current logged in user Id.
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
	
	// Adds a user to the database upon validation is passed.
	$scope.addUser = function(){
		if($scope.validateUser($scope.user)) {
			usersFactory.addUser($scope.user).then(
				function(results){
					window.location.href = "http://localhost:8080/login";
				},
				function(error){
					console.log(error);
				}
			);
		}
	};
	
	// Checks to see that the two passwords entered match.  If not, show error message.
	$scope.confirmPassword = function(password, confirmation) {
		if (!validationFactory.confirmPassword(password, confirmation) && password !== undefined && confirmation !== undefined) {
			$scope.passwordsDiffer = true;
		} else {
			$scope.passwordsDiffer = false;
		}
	};
	
	// Checks to see that the email is valid, if not, show error message.
	$scope.validateEmailOnBlur = function(email) {
		if (email !== undefined && !validationFactory.validateField(emailRegex, email)) {
			$scope.emailIsInvalid = true;
		} else {
			$scope.emailIsInvalid = false;
		}
	};
	
	// Checks to see that the email is valid upon submit.  If not, show error message.
	$scope.validateEmailOnSubmit = function(email) {
		if (!validationFactory.validateField(emailRegex, email)) {
			$scope.emailIsInvalid = true;
		} else {
			$scope.emailIsInvalid = false;
		}
	};
	
	// Checks to see if the password meets requirements.  If not, show error message.
	$scope.validatePasswordOnBlur = function(password) {
		if (password !== undefined && !validationFactory.validateField(passwordRegex, password)) {
			$scope.passwordIsInvalid = true;
		} else {
			$scope.passwordIsInvalid = false;
		}
	};
	// Checks to see that the password is valid upon submit.  If not, show error message.
	$scope.validatePasswordOnSubmit = function(password) {
		if (!validationFactory.validateField(passwordRegex, password)) {
			$scope.passwordIsInvalid = true;
		} else {
			$scope.passwordIsInvalid = false;
		}
	};
	
	// Wraps all functionality into single call.
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