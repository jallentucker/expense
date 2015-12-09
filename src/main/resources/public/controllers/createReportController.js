
angular.module('myApp').controller('createReportController',['$scope', 'createReportFactory', function($scope, createReportFactory){
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
    				$scope.createReportResult = success;
    			},
    			function(error){
    				$scope.createReportResult = error;
    			})
    }
}])
    