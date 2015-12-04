(function(){
	angular.module("myApp")
	.config(appConfig)
	.run(['$state', function($state){
		$state.transitionTo('login');
	}]);
	
	function appConfig($stateProvider){
		var search = { name: 'login', url:'/login',
					templateUrl: 'templates/login.html',
					controller: 'loginCtrl'};
		$stateProvider.state(search);
	}
	
})();