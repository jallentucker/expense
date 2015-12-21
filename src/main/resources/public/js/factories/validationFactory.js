angular.module('myApp').factory('validationFactory', [function() {
	return {
		
		// Makes sure that the passwords match.
		confirmPassword: function(password, confirmation) {
			if (password === confirmation) {
				return true;
			} else {
				return false;
			}
		},
		
		// Validates that the entered field meets the regex requirements.
		validateField: function(pattern, str) {
			var regex = new RegExp(pattern);
			return regex.test(str);
		}
	};
}]);
