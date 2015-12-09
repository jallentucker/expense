
angular.module('myApp').controller('createReportController',['$scope', '$http', 'createReportFactory', function($scope, $http, createReportFactory){
	$scope.report = {};
	
    $scope.getCurrentUser = createReportFactory.getCurrentUser().then(
    		function(success){
    			console.log(success.data);
    			$scope.currentUser = success.data;
    		},
    		function(error){
    			$scope.currentUser = error;
    	});
    $scope.createReport = function(report){
            report.user = $scope.currentUser;
            createReportFactory.createReport(report).then(
                    function(success){
                        $scope.createReporttResult = success;
                    },
                    function(error){
                        $scope.createReportResult = error;
                    });
    };
    
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
    