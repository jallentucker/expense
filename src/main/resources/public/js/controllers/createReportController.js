
angular.module('myApp').controller('createReportController',['$scope', '$compile', '$element', '$http', 'createReportFactory', 'lineItemFactory', 'lineTypeListFactory', function($scope, $compile, $element, $http, createReportFactory, lineItemFactory, lineTypeListFactory){
                                                             
    $scope.monetary= [];
    $scope.expenseType = [];
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
    
    $scope.createReport = function(report, selectedProject, lineItemTypes){
    		//console.log($scope.monetary);
            //console.log($scope.expenseType);
            report.user = $scope.currentUser;
            report.project = selectedProject;
            if(report.reportName.length > 2) {
            	createReportFactory.createReport(report).then(
                    function(success){
                        $scope.createReportResult = success;
                        
                        for(var i = 0; i < $scope.expenseType.length; i++){
                            var lineItemObj = {
                                'lineItemType':{
                                        'lineItemTypeId' : $scope.expenseType[i]
                                },
                                'monetaryAmount' : $scope.monetary[i],
                                'report' : {
                                        'reportId' : success.data
                                }
                            };
                            $scope.lineItemArray.push(lineItemObj);
                        }
                        
                        report.reportId = success.data;
                        
                        for(var i = 0; i <$scope.lineItemArray.length; i++){
                            lineItemFactory.postLineItem($scope.lineItemArray[i]).then(
                             function(success){
                                 $scope.postLineItemSuccess = success.data;
                             },
                            function(error){
                                console.log(error);
                            })
                        }
                        console.log($scope.lineItemArray);
                        $scope.lineItemArray = [];
                        $scope.lineItems = [];
                        $scope.monetary= [];
                        $scope.expenseType = [];
                       // console.log($scope.monetary);
                       // console.log($scope.expenseType);
                       // window.location = "/#/home";
                        
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
	
	$scope.lineTypesList = lineTypeListFactory.getType().then(
            function(success){
                $scope.result = success.data;
            },
            function(error){
                $scope.result = error;
            }
        );
	
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
	
	
		$scope.lineItems=[];
        $scope.lineItem= {};
    
        $scope.lineItemArray = [];
		$scope.count = 0;
		$scope.addLineitem = function(){
            $scope.lineItems.push($scope.lineItem);
		}
		
}])


    