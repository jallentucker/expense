angular.module('myApp').factory('usersFactory', ['$http', function($http){

	return {
	
		getUsers: function(){
			return $http.get('/user');
		},
	
		addUser: function(user){
			return $http.post('user', user);
		}
	};

}]);