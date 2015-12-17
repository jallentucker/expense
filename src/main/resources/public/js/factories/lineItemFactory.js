angular.module('myApp').factory('lineItemFactory',['$http', function($http){
	return{
		
 		postLineItem : function(lineItem){
		    return $http.post("/lineItem", lineItem);
		 }
	}
}]);
 