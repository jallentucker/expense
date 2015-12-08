angular.module('myApp').value('emailRegex', '^.{1,}@.{1,}\..{1,}$');
angular.module('myApp').value('passwordRegex', '^(?=.*[A-Z])(?=.*[!@#$%^&*])(?=.*[0-9]).{8,}$');
