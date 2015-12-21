angular.module('myApp').factory('createReportFactory',['$http', function($http){
    return{ 
    	createReport: function(report){
            return $http.post('report', report);
        },
        
    	getCurrentUser: function(){
    		return $http.get("user/getCurrent")
    	},
    	
 		getProjects: function(){
		    return $http.get("/project");
		 },
		 
	 	postLineItem : function(lineItem){
			 return $http.post("/lineItem", lineItem);
		},
		
 		getType : function(){
		    return $http.get("/lineItemType");
		 }
    }	
}]); 