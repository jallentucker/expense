angular.module('myApp').controller('registerCtrl', ['$scope', 'usersFactory', 'validationFactory', 'emailRegex', 'passwordRegex',
  function($scope, usersFactory, validationFactory, emailRegex, passwordRegex){

	$scope.username;
	
	$scope.password;

	$scope.user = {};
	$scope.user.userPassword = $scope.userPassword;
	$scope.user.userEmail = $scope.userEmail;
	$scope.user.confirmUserPassword = $scope.confirmUserPassword;

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
		if($scope.validateUser(user)) {
			usersFactory.addUser().then(
				function(results){
					$scope.results = results;
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
	$scope.validateEmail = function(email) {
		if (!validationFactory.validateField(emailRegex, false, email)) {
			$scope.emailIsInvalid = true;
		} else {
			$scope.emailIsInvalid = false;
		}
	};
	$scope.validatePassword = function(password) {
		if (!validationFactory.validateField(passwordRegex, false, password)) {
			$scope.passwordIsInvalid = true;
		} else {
			$scope.passwordIsInvalid = false;
		}
	};
	$scope.validateUser = function(user) {
		$scope.passwordsDiffer = !$scope.confirmPassword(user.userPassword, user.confirmUserPassword);
		$scope.emailIsInvalid = !$scope.validateEmail(user.userEmail);
		$scope.passwordIsInvalid = !$scope.validatePassword(user.userPassword);
		if ($scope.passwordsDiffer || $scope.emailIsInvalid || $scope.passwordIsInvalid) {
			return false;
		} else {
			return true;
		}
	};
}]);