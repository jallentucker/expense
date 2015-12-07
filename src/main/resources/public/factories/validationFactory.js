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
		},
		validatePassword: function(password) {
			var test1 = this.validateField('^.{8,}$', password);
			var test2 = this.validateField('^.*[A-Z]{1,}.*$', password);
			var test3 = this.validateField('^.*[!@#$%^&*]{1,}.*$', password);
			var test4 = this.validateField('^.*[0-9]{1,}.*$', password);
			if (test1 && test2 && test3 && test4) {
				return true;
			} else {
				return false;
			}
		}
	};
}]);
