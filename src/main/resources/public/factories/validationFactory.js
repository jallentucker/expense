angular.module('myApp').factory('validationFactory', ['passwordMinCharRegex', 'passwordMinCapitalCharRegex', 'passwordMinSpecialCharRegex', 'passwordMinNumberRegex', function(passwordMinCharRegex, passwordMinCapitalCharRegex, passwordMinSpecialCharRegex, passwordMinNumberRegex) {
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
		},
		validatePassword: function(password) {
			var test1 = this.validateField(passwordMinCharRegex, password);
			var test2 = this.validateField(passwordMinCapitalCharRegex, password);
			var test3 = this.validateField(passwordMinSpecialCharRegex, password);
			var test4 = this.validateField(passwordMinNumberRegex, password);
			if (test1 && test2 && test3 && test4) {
				return true;
			} else {
				return false;
			}
		}
	};
}]);
