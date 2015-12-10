// For the following regex expressions, "any character" is restricted to the letters [A-Z] (upper or
// lower), the digits [0-9], and the following special characters: [!@#$%^&*.?]

// emailRegex requirements: any characters, followed by [@], followed by any characters, followed by [.],
// followed by any characters
angular.module('myApp').value('emailRegex', '^[A-Za-z0-9!@#$%^&*.?]{1,}@[A-Za-z0-9!@#$%^&*.?]{1,}[.]{1}[A-Za-z0-9!@#$%^&*.?]{1,}$');

// passwordRegex requirements: capital letter [A-Z] (minimum 1), special character [!@#$%^&*.?]
// (minimum 1), digit (minimum 1). There must be at least 8 total characters (any characters)
angular.module('myApp').value('passwordRegex', '^(?=.*[A-Z])(?=.*[!@#$%^&*.?])(?=.*[0-9])[A-Za-z0-9!@#$%^&*.?]{8,}$');

// projectNameRegex requirements: any character (minimum 1)
angular.module('myApp').value('projectNameRegex', '^.*[A-Za-z0-9!@#$%^&*-_.?]{1,}.*$');

