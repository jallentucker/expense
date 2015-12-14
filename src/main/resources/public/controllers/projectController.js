angular.module('myApp').controller('projectCtrl',['$scope', 'projectFactory', 'validationFactory', 'projectNameRegex', function($scope, projectFactory, validationFactory, projectNameRegex){
    
    $scope.project = {};
    
    $scope.getCurrentUser = projectFactory.getCurrentUser().then(
    		function(success){
    			console.log(success.data);
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
}])