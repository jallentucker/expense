angular.module('myApp').factory('usersFactory', ['$http', function($http){

	return {
	
		getUsers: function(){
		
			return $http.get("localhost:8080/users/get").then(
				function(response){
				
					return response;
					
				},
				function(error){
				
					return error;
					
				}
			);
		
		},
	
		addUser: function(searchQuery){
		
			return $http.post("localhost:8080/users/get").then();
		
		}
	
	};

}]);