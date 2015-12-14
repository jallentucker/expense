angular.module('myApp').factory('createReportFactory',['$http', function($http){
    return{
    	createReport: function(report){
            return $http.post('report/post', report);
        },
    	getCurrentUser: function(){
    		return $http.get("user/getCurrent")
    	}
    }	
}]);