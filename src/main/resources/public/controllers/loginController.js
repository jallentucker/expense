angular.module('myApp').controller('loginCtrl',['$scope', 'loginFactory','usersFactory',
   function($scope, loginFactory, usersFactory) {
	
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
				for(var result: results){
					if(result.userEmail==user.userEmail&&result.userPassword==user.userPassword){
						$location.path( "/home" );
					}
				}
			},
			function(error){
				console.log("error");
				console.log(error);
			}
		);
	};
	
    }
]);