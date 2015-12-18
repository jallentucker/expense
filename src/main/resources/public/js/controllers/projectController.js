angular.module('myApp').controller('projectCtrl',['$scope', 'projectFactory', 'validationFactory', 'projectNameRegex', function($scope, projectFactory, validationFactory, projectNameRegex){
    
    $scope.project = {};
    
    $scope.getCurrentUser = projectFactory.getCurrentUser().then(
    		function(success){
    			$scope.currentUser = success.data;
    		},
    		function(error){
    			$scope.currentUser = error;
    		});
    
    $scope.createProject = function(project){
        $scope.validateProjectName(project.projectName, true);
        if (!$scope.projectNameIsInvalid) {
            project.user = $scope.currentUser;
            projectFactory.createProject(project).then(
                    function(success){
                       $scope.createProjectResult = success
                       if(success.data == true)
                       {
                    	   window.location = "/#/home";
                       }
                    },
                    function(error){
                        $scope.createProjectResult = error;
                    });
        }
    };

    $scope.validateProjectName = function(projectName, persist) {
        if (!validationFactory.validateField(projectNameRegex, persist, projectName)) {
            $scope.projectNameIsInvalid = true;
        } else {
            $scope.projectNameIsInvalid = false;
        }
    };
    
    
    $scope.types = function(){
        typesFactory.getTypes().then(
            function(success){
                $scope.result = success;
            },
            function(error){
                $scope.result = error;
            }
        );
    };
}])