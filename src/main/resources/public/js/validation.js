var validateEmail = function(email) {
	var pattern = new RegExp('^.{1,}@.{1,}\..{1,}$');
	return pattern.test(email);
};

var validatePassword = function(password) {
	var test1 = validateStrHasMinOfCharClass('.', 8, password);
	var test2 = validateStrHasMinOfCharClass('[A-Z]', 1, password);
	var test3 = validateStrHasMinOfCharClass('[!@#$%&*]', 1, password);
	var test4 = validateStrHasMinOfCharClass('[0-9]', 1, password);
	if (test1 && test2 && test3 && test4) {
		return true;
	} else {
		return false;
	}
};

var validateStrHasMinOfCharClass = function(charClass, min, str) {
	var pattern = new RegExp('^.*' + charClass + '{' + min + ',}.*$');
	return pattern.test(str);
};

console.log(validatePassword('bad'));
console.log(validatePassword('A!0hhhhh'));
console.log(validatePassword('h!0hhhhh'));
console.log(validatePassword('Ah0hhhhh'));
console.log(validatePassword('A!hhhhhh'));
console.log(validatePassword('A!0hhhh'));
