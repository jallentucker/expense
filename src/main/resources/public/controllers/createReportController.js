
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
    $scope.createReport = function() {
    	$http({
    		method: 'POST',
    		url: '/report/post',
    		data: $scope.report
    	}).success(function(data){
    		console.log(data);
    		$scope.report=data;
    	}, function(error){
    		$scope.report = error;
    	});
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
    