angular.module('myApp').controller('projectCtrl',['$scope', 'projectFactory', 'validationFactory', 'projectNameRegex', function($scope, projectFactory, validationFactory, projectNameRegex){
    
	// Sets the project object to null.
    $scope.project = {};
    
    // Retrieves the current user.
    $scope.getCurrentUser = projectFactory.getCurrentUser().then(
    		function(success){
    			$scope.currentUser = success.data;
    		},
    		function(error){
    			$scope.currentUser = error;
    		});
    
    // Creates a project if the project name meets the requirements and redirects the user
    // to the home page on a successful submit.  Otherwise, it'll stay on the same page.
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

    // Validates that the name of the project meets the requirements.
    $scope.validateProjectName = function(projectName, persist) {
        if (!validationFactory.validateField(projectNameRegex, persist, projectName)) {
            $scope.projectNameIsInvalid = true;
        } else {
            $scope.projectNameIsInvalid = false;
        }
    };
}])