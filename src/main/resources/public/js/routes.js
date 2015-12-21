(function(){
	angular.module("myApp")
	.config(appConfig)
	.run(['$state', function($state){
		$state.transitionTo('home');
	}]);
	
	// Create Project page.
	function appConfig($stateProvider){		       
        var createProject = {
            name:'createProject',
            url:'/createProject',
            templateUrl:'/templates/createproject.html',
            controller:'projectCtrl'
        };
        $stateProvider.state(createProject);
        
        // Home page.
        var home = {
                name:'home',
                url:'/home',
                templateUrl:'/templates/home.html',
         };
         $stateProvider.state(home);
         
         // Create Report page.
         var createReport = {
        		 name: 'createReport',
        		 url: '/createReport',
        		 templateUrl: '/templates/createReport.html',
        		 controller: 'createReportController'
         };
         $stateProvider.state(createReport);
	}
})();