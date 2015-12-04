angular.module('myApp').factory('usersFactory', ['$http', function($http){

	return {
	
		getUsers: function(){
		
			return $http.get("localhost:8080/users/get");
		
		},
	
		addUser: function(searchQuery){
		
			return $http.post("localhost:8080/users/get");
		
		}
	
	};

}]);