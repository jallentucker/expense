angular.module('myApp').factory('usersFactory', ['$http', function($http){

	return {
	
		getUsers: function(){

			return $http.get("/user/get");
		
		},
	
		addUser: function(user){
			return $http.post("/user/post",user);
		
		}
	
	};

}]);