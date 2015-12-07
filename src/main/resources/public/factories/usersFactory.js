angular.module('myApp').factory('usersFactory', ['$http', function($http){

	return {
	
		getUsers: function(){
		
			return $http.get("localhost:8080/user/get");
		
		},
	
		addUser: function(user){
		
			return $http.post("localhost:8080/user/post");
		
		}
	
	};

}]);