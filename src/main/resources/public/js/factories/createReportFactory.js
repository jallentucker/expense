angular.module('myApp').factory('createReportFactory',['$http', function($http){
    return{ 
    	
    	// POSTS the report to the database.
    	createReport: function(report){
            return $http.post('report', report);
        },
        
        // GETS the current user that is logged in.
    	getCurrentUser: function(){
    		return $http.get("user/getCurrent")
    	},
    	
    	// GETS current projects in the database.
 		getProjects: function(){
		    return $http.get("/project");
		 },
		 
		// POSTS line items added to the database
	 	postLineItem : function(lineItem){
			 return $http.post("/lineItem", lineItem);
		},
		
		// GETS the line item types from the database.
 		getType : function(){
		    return $http.get("/lineItemType");
		 }
    }	
}]); 