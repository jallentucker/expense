angular.module('myApp').value('emailRegex', '^.{1,}@.{1,}\..{1,}$');
angular.module('myApp').value('passwordMinCharRegex', '^.{8,}$');
angular.module('myApp').value('passwordMinCapitalCharRegex', '^.*[A-Z]{1,}.*$');
angular.module('myApp').value('passwordMinSpecialCharRegex', '^.*[!@#$%^&*]{1,}.*$');
angular.module('myApp').value('passwordMinNumberRegex', '^.*[0-9]{1,}.*$');
