angular.module('myApp').factory('projectFactory',['$http', function($http){
    return{
        createProject: function(project){
            return $http.post('project', project);
        },
    	getCurrentUser: function(){
    		return $http.get("user/getCurrent")
    	}
    }
}])