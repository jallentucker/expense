
angular.module('myApp').controller('createReportController',['$scope', '$compile', '$element', '$http', 'createReportFactory', 'lineItemFactory', function($scope, $compile, $element, $http, createReportFactory, lineItemFactory){
                                                             
    $scope.test= [];
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
    
    $scope.createReport = function(report, selectedProject, lineItemTypes){
        console.log($scope.test);
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
                                'monetaryAmount' : $scope.test[i],
                                'report' : {
                                        'reportId' : success.data
                                }
                            };
                            $scope.lineItemArray.push(lineItemObj);
                        }
                        
                        for(var i = 0; i <$scope.lineItemArray.length; i++){
                            lineItemFactory.postLineItem($scope.lineItemArray[i]);
                        }
                        
                        //console.log($scope.lineItemArray);
                        //window.location = "/#/home";
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
                $scope.result = success.data;
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
	
	
		$scope.lineItems=[];
        $scope.lineItem= {};
    
        $scope.lineItemArray = [];
		$scope.count = 0;
		$scope.addLineitem = function(){
            
            
            
            
           console.log($scope.test)
           console.log($scope.expenseType);
                
            $scope.lineItems.push($scope.lineItem);

			/*$scope.count++;
			$scope.lineitem ={};
			//$scope.lineitem.lineItemType = {};
			//$scope.lineitem.lineItemType.lineItemType = null;
			//$scope.lineitem.lineItem.lineItemType.lineItemType = null;
		 	//$scope.lineitem.monetaryAmount = null;
			$scope.lineitems.push($scope.lineitem.lineItem);
			$scope.fillLineItemsList();
			$scope.lineitem.lineItemsList = $scope.lineItemsList;
			newElement = $compile("<br/><lineitem name='lineitem'></lineitem><br/>{{lineitems}}")($scope)
			$element.parent().append(newElement)*/
			
		}
		
        /*$scope.clickTest = function(){
            for(var i = 0; i < $scope.expenseType.length; i++){
                var lineItemObj = {
                        'lineItemType':{
                                'lineItemTypeId' : $scope.expenseType[i]
                        },
                        'monetaryAmount' : $scope.test[i],
                        'report' : 
                };
                //console.log($scope.test[i]);
                //lineItemObj.monetaryAmount = $scope.test[i];
                //lineItemObj.lineItemType.lineItemTypeId = $scope.expenseType[i];
                $scope.lineItemArray.push(lineItemObj);
                //$scope.lineItemArray[i] = $scope.lineItemObj;
                
            }
            console.log($scope.lineItemArray);
        }
        /*$scope.addLineItemRow = function(){
            do the append.
            
            '<div class="lineItem'+count+'">'
            
            for(var i = 0; i <count; i++){
                angular.element('lineItem'+i).
            }
        }*/
}])


    