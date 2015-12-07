(function(){
	angular.module("myApp")
	.config(appConfig)
	.run(['$state', function($state){
		$state.transitionTo('login');
	}]);
	
	function appConfig($stateProvider){
		var login = { name: 'login', url:'/login',
					templateUrl: 'templates/login.html',
					controller: 'loginCtrl'};
		$stateProvider.state(login);
		var register = { name: 'register', url:'/register',
				templateUrl: 'templates/register.html',
				controller: 'registerCtrl'};
		$stateProvider.state(register);
		
		
	}
	
})();