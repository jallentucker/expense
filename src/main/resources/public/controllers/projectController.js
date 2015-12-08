angular.module('myApp').controller('projectCtrl',['$scope', 'projectFactory', function($scope, projectFactory){
    
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
    	project.user = $scope.currentUser;
    	projectFactory.createProject(project).then(
    			function(success){
    				$scope.createProjectResult = success;
    			},
    			function(error){
    				$scope.createProjectResult = error;
    			})
    }
}])