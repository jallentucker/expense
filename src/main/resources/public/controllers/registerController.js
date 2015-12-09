angular.module('myApp').controller('registerCtrl', ['$scope', 'usersFactory', 'validationFactory', 'emailRegex', 'passwordRegex',
  function($scope, usersFactory, validationFactory, emailRegex, passwordRegex){

	$scope.username;
	
	$scope.password;

	$scope.user = {};
	$scope.user.userPassword;
	$scope.user.userEmail;
	$scope.user.confirmUserPassword;

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
		//if($scope.validateUser($scope.user)) {
			usersFactory.addUser($scope.user).then(
				function(results){
					console.log(results);
				},
				function(error){

					console.log(error);
				}
			);
		//}
	};
	$scope.confirmPassword = function(password, confirmation) {
		if (!validationFactory.confirmPassword(password, confirmation) && password !== undefined && confirmation !== undefined) {
			$scope.passwordsDiffer = true;
		} else {
			$scope.passwordsDiffer = false;
		}
	};
	$scope.validateEmail = function(email, persist) {
		if (!validationFactory.validateField(emailRegex, persist, email)) {
			$scope.emailIsInvalid = true;
		} else {
			$scope.emailIsInvalid = false;
		}
	};
	$scope.validatePassword = function(password, persist) {
		if (!validationFactory.validateField(passwordRegex, persist, password)) {
			$scope.passwordIsInvalid = true;
		} else {
			$scope.passwordIsInvalid = false;
		}
	};
	$scope.validateUser = function(user) {
		$scope.confirmPassword(user.userPassword, user.confirmUserPassword);
		$scope.validateEmail(user.userEmail, true);
		$scope.validatePassword(user.userPassword, true);
		if ($scope.passwordsDiffer || $scope.emailIsInvalid || $scope.passwordIsInvalid) {
			return false;
		} else {
			return true;
		}
	};
}]);