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
            controller:'projectController'
        };
        $stateProvider.state(createProject);
	}
	
})();