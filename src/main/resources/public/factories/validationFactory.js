angular.module('myApp').factory('validationFactory', [function() {
	return {
		confirmPassword: function(password1, password2) {
			if (password1 === password2) {
				return true;
			} else {
				return false;
			}
		},
		validateField: function(pattern, str) {
			var regex = new RegExp(pattern);
			return regex.test(str);
		}
	};
}]);
