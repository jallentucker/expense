angular.module('myApp').factory('projectFactory',['$http', function($http){
    return{
    	
    	// POSTS a project to the database.
        createProject: function(project){
            return $http.post('project', project);
        },
        
        // GETS current user that is logged in.
    	getCurrentUser: function(){
    		return $http.get("user/getCurrent")
    	}
    }
}])