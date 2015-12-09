// For the following regex expressions, "any character" is restricted to the letters [A-Z] (upper or
// lower), the digits [0-9], and the following special characters: [!@#$%^&*-_.?]

// projectNameRegex requirements: any character (minimum 1)
angular.module('myApp').value('projectNameRegex', '^.*[A-Za-z0-9!@#$%^&*-_.?]{1,}.*$');
