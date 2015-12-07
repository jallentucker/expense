angular.module('myApp').factory('loginFactory', [function(){
	
	return {
		comfirmEmail: function(email1, email2) {
			if (email1 === email2) {
				return true;
			} else {
				return false;
			}
		}
	};
}]);
         