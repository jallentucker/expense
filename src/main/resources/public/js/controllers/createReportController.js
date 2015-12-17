
angular.module('myApp').controller('createReportController',['$scope', '$compile', '$element', '$http', 'createReportFactory', 'lineItemFactory', 'lineTypeListFactory', function($scope, $compile, $element, $http, createReportFactory, lineItemFactory, lineTypeListFactory){
                                                             
    $scope.monetary= [];
    $scope.expenseType = [];
	$scope.report = {};
	
    $scope.getCurrentUser = createReportFactory.getCurrentUser().then(
    		function(success){
    			$scope.currentUser = success.data;
    		},
    		function(error){
    			$scope.currentUser = error;
    	});
    
    $scope.reqDropdown = function() {
    	if($scope.selectedProject && $scope.selectedProject.projectId) return false;
    	return true;
    }
   
    $scope.createReport = function(report, selectedProject, lineItemTypes, status){
    		report.user = $scope.currentUser;
            report.project = selectedProject;
            report.status = {statusId: status};
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
                        
                        for(var i = 0; i <$scope.lineItemArray.length; i++){
                            var id = lineItemFactory.postLineItem($scope.lineItemArray[i]).then(
                             function(success){
                                 console.log("SUCCESS!");
                             },
                            function(error){
                                console.log(error);
                            })
                        }
                        console.log($scope.lineItemArray);
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

	$scope.ProjectList = createReportFactory.getProjects().then(
			function(success){
				$scope.projectName = success.data;
			},
			function(error) {
				$scope.projectName = error;
			}
		);
	
	$scope.lineTypesList = lineTypeListFactory.getType().then(
            function(success){
                $scope.result = success.data;
            },
            function(error){
                $scope.result = error;
            }
        );
	
		$scope.lineItems=[];
        $scope.lineItem= {};
    
        $scope.lineItemArray = [];
		$scope.count = 0;
		$scope.addLineitem = function(){
            $scope.lineItems.push($scope.lineItem);
		}
		
}])


    