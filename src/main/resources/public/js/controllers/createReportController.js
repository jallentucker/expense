
angular.module('myApp').controller('createReportController',['$scope', '$compile', '$element', '$http', 'createReportFactory', function($scope, $compile, $element, $http, createReportFactory){

	$scope.report = {};
	$scope.selectedProject = {};
	
    $scope.getCurrentUser = createReportFactory.getCurrentUser().then(
    		function(success){
    			$scope.currentUser = success.data;
    		},
    		function(error){
    			$scope.currentUser = error;
    	});
    
    $scope.createReport = function(report, selectedProject){
    		report.user = $scope.currentUser;
            report.project = selectedProject;
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
	
		$scope.addLineitem = function(){
			$scope.count++;
			newElement = $compile("<br/><lineitem></lineitem><br/>")($scope)
			$element.parent().append(newElement)
		}
		$scope.count = 1;
		$scope.lineitem = {};
		$scope.lineitem.name = "Line Item";
		$scope.lineitem.values = ["Mileage", "Per Diem", "Lodging", "Travel", "Meals", "Entertainment", "Parking", "Other"];
	 	$scope.lineitem.value = null;
	 	$scope.lineitem.money = 0;
}])


    