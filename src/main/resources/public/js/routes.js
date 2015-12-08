(function(){
	angular.module("myApp")
	.config(appConfig)
	.run(['$state', function($state){
		$state.transitionTo('home');
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
         
         var createReport = {
        		 name: 'createReport',
        		 url: '/createReport',
        		 templateUrl: '/templates/createReport.html',
        		 controller: 'createReportController'
         };
         $stateProvider.state(createReport);
	}
	
})();