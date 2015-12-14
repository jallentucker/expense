angular.module('myApp').factory('validationFactory', [function() {
	return {
		confirmPassword: function(password, confirmation) {
			if (password === confirmation) {
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
