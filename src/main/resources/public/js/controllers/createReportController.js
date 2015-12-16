
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
    
    $scope.submitReport = function(report, selectedProject){
    		report.user = $scope.currentUser;
            report.project = selectedProject;
            report.status = {statusName: "submitted"};
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

	$scope.StatusList = null;
	$scope.fillStatusList = function() {
		$http({
			method: 'GET',
			url: '/status',
			data: {}
		}).success(function(result) {
			$scope.StatusList = result;
		});
	}
	
	$scope.fillProjectList();
	$scope.fillStatusList();
}])
    