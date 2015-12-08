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
	$scope.addUser = function(user){
		console.log('user: ');
		console.log(user);
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
	$scope.validateEmail = function(email, persist) {
		if (!validationFactory.validateField(emailRegex, persist, email)) {
			$scope.emailIsInvalid = true;
			console.log('emailIsInvalid');
		} else {
			$scope.emailIsInvalid = false;
		}
		console.log(validationFactory.validateField(emailRegex, true, 'h i@gmail.com'));
	};
	$scope.validatePassword = function(password, persist) {
		console.log('password:' + password);
		console.log('persist:' + persist);
		if (!validationFactory.validateField(passwordRegex, persist, password)) {
			$scope.passwordIsInvalid = true;
			console.log('passwordIsInvalid');
		} else {
			$scope.passwordIsInvalid = false;
		}
		console.log(validationFactory.validateField(passwordRegex, true, 'Q!1q qqq'));
	};
	$scope.validateUser = function(user) {
		// $scope.passwordsDiffer = !$scope.confirmPassword(user.userPassword, user.confirmUserPassword);
		// $scope.emailIsInvalid = !$scope.validateEmail(user.userEmail);
		// $scope.passwordIsInvalid = !$scope.validatePassword(user.userPassword);
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