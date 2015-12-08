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
        
        var home = {
                name:'home',
                url:'/home',
                templateUrl:'/templates/home.html',
                controller:'homeCtrl'
         };
         $stateProvider.state(home);
         
         var login = {
        		 name:'login',
                 url:'/login',
                 templateUrl:'/loginpage.html',
                 controller:'homeCtrl'
         }
         $stateProvider.state(login);
	}
	
})();