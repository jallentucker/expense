angular.module('myApp').factory('validationFactory', [function() {
	return {
		confirmPassword: function(password, confirmation) {
			if (password === confirmation) {
				return true;
			} else {
				return false;
			}
		},
		// The persist argument is a boolean that indicates whether the user is trying to persist data or not.
		// This argument is provided so that validation is not fired when focusing out of an empty field.
		validateField: function(pattern, persist, str) {
			if (!persist && str === undefined) {
				return true;
			} else {
				if (str === undefined) {
					return false;
				} else {
					var regex = new RegExp(pattern);
					return regex.test(str);
				}

			}
		}
	};
}]);
