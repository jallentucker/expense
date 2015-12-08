(function(){
	angular.module("myApp")
	.config(appConfig)
	.run(['$state', function($state){
		$state.transitionTo('login');
	}]);
	
	function appConfig($stateProvider){		       
        var createProject = {
            name:'createProject',
            url:'/createProject',
            templateUrl:'/templates/createproject.html',
            controller:'projectCtrl'
        };
        $stateProvider.state(createProject);
        
        var createProject = {
                name:'home',
                url:'/home',
                templateUrl:'/templates/home.html',
                controller:'homeCtrl'
         };
         $stateProvider.state(home);
	}
	
})();