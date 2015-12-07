angular.module('myApp').controller('loginCtrl',['$scope', 'loginFactory','usersFactory',
   function($scope, loginFactory, usersFactory) {
	
	$scope.userEmail;
	
	$scope.userPassword;
		
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
	
    }
]);