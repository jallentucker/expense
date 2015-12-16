
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
    
    $scope.createReport = function(report, selectedProject, lineItemTypes){
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
	
	$scope.lineTypesList = function(){
        lineTypesListFactory.getTypes().then(
            function(success){
                $scope.result = success;
            },
            function(error){
                $scope.result = error;
            }
        );
    }
	
	$scope.lineItemsList = null;
	$scope.fillLineItemsList = function() {
		$http({
			method: 'GET',
			url: '/lineItemType',
			data: {}
		}).success(function(result) {
			$scope.lineItemsList = result;
		});
	}
	

	$scope.fillProjectList();
	$scope.fillLineItemsList();
	
	
		$scope.lineitems=[];
		$scope.count = 0;
		$scope.addLineitem = function(){
			$scope.count++;
			$scope.lineItem = {};
			$scope.lineItem.lineItemType = {};
			$scope.lineItem.lineItemType.lineItemType;
		 	$scope.lineItem.monetaryAmount;
			$scope.lineitems.push($scope.lineitem);
			$scope.fillLineItemsList();
			newElement = $compile("<br/><lineitem></lineitem><br/>{{lineitems}}")($scope)
			$element.parent().append(newElement)
			
		}
		
}])


    