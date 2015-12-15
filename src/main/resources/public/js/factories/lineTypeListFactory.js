angular.module('myApp').factory('lineTypeListFactory',['$http', function($http){
	return{
		
 		getType : function(){
		    return $http.get("/lineItemType");
		 }
	}
}]);
 