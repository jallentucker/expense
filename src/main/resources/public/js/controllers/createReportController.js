
angular.module('myApp').controller('createReportController',['$scope', '$http', 'createReportFactory', function($scope, $http, createReportFactory){
	$scope.report = {};
	$scope.selectedProject = {};
	
    $scope.getCurrentUser = createReportFactory.getCurrentUser().then(
    		function(success){
    			$scope.currentUser = success.data;
    		},
    		function(error){
    			$scope.currentUser = error;
    	});
    
    $scope.reqDropdown = function() {
    	if($scope.selectedProject && $scope.selectedProject.projectName) return false;
    	return true;
    }
    
    $scope.reqLineItem = function() {
    	
    }
    
    $scope.createReport = function(report, selectedProject, status){
		report.user = $scope.currentUser;
        report.project = selectedProject;
        report.status = {statusId: status};
        if(report.reportName.length > 2) {
        	createReportFactory.createReport(report).then(
                function(success){
                    $scope.createReportResult = success;
                    window.location = "/#/home";
                },
                function(error){
                    $scope.createReportResult = error;
                });
        }
        else {
        	console.log("Name didn't meet requirements");
        }
    }

	$scope.ProjectList = null;
	$scope.fillProjectList = function() {
		$http({
			method: 'GET',
			url: '/project/get',
			data: {}
		}).success(function(result) {
			$scope.ProjectList = result;
		});
	}
	$scope.fillProjectList();
}])
    