
angular.module('myApp').controller('createReportController',
		['$q', '$scope', '$compile', '$element', 'createReportFactory', 
		 'toastr', function($q, $scope, $compile, $element, createReportFactory, 
		  toastr){
                 
	// Sets variable values
    $scope.monetary= [];
    $scope.expenseType = [];
    $scope.lineItemId = [];
	$scope.report = {};
	$scope.showSubmitBtn = false;
	$scope.submitBtnHide = true;
	$scope.isClicked = false;
	
	// Any change after clicking the save button in order to show the submit button
	// hides the submit button again and waits for save button click.
	$scope.onChange = function(){
		if($scope.isClicked == true){
			$scope.submitBtnHide = true;
		}
	}
	
	// Retrieves the current user that is logged into the app.
    $scope.getCurrentUser = createReportFactory.getCurrentUser().then(
    		function(success){
    			$scope.currentUser = success.data;
    		},
    		function(error){
    			$scope.currentUser = error;
    	});
    
    // Makes sure that all the drop down menus have a value selected in order to save a report.
    $scope.reqDropdown = function() {
    	if($scope.selectedProject && $scope.selectedProject.projectId &&
    			$scope.expenseType[$index] && $scope.expenseType[$index].lineItemTypeId) return false;
    	return true;
    }

    var setLineItemId = function(i) {
        if ($scope.lineItemId.length !== 0 && i < $scope.lineItemId.length) {
            return $scope.lineItemId[i];
        } else {
            return null;
        }
    };
   
    // Adds a report and line items to the database.  This also persists any changes made before the
    // report is submitted to the database and you're returned to the home page.
    $scope.createReport = function(report, selectedProject, lineItemTypes, status){
    		// Tells it which values to grab to be passed into the database.
    		report.user = $scope.currentUser;
            report.project = {};
            report.project.projectId = selectedProject;
            report.status = {statusId: status};
            if(report.reportName.length > 2) {
            	createReportFactory.createReport(report).then(
                    function(success){
                        $scope.createReportResult = success;
                        // Sets the reportId for the entire report so that any changes before submit 
                        // will persist to the database without adding another report.
                        report.reportId = success.data;
                        for(var i = 0; i < $scope.expenseType.length; i++){
                        	// Line item object that is passed into the database.
                            var lineItemObj = {
                                'lineItemId': setLineItemId(i),
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
                        
                        // Adds each line item on the page.
                        var promiseArray = [];
                        $scope.lineItemId = [];
                        for(var i = 0; i <$scope.lineItemArray.length; i++){
                        	var promise = createReportFactory.postLineItem($scope.lineItemArray[i]).then(
                                function(success){
                                    $scope.lineItemId.push(success.data.lineItemId);
                                    $scope.postLineItemSuccess = success.data;
                                },
                                function(error){
                                    console.log(error);
                                }
                            );
                            promiseArray.push(promise);
                            // $scope.lineItemArray[i].lineItemId = $scope.postLineItemSuccess;
                        }
                        $q.all(promiseArray).then(function() {
                            $scope.lineItemId.sort(function(a, b) {
                                return a - b;
                            });
                        });
                        // If status is equal to 'submitted' and it is successful, return to the 
                        // home page.
                        if (status == 2)
                        	{
                        		window.location = "/#/home";
                        	}
                        // If status is equal to 'saved' send the data to the database and alert the
                        // user that the data has been saved.
                        if(status == 4){
                        	$scope.submitBtnHide = false;
                        	$scope.isClicked = true;
                        	toastr.success('Success', 'Your Report Has Been Saved');
                        }
                        $scope.lineItemArray = [];
                        // $scope.lineItems = [];
                        // $scope.lineItems.push($scope.lineItem);
                        // $scope.monetary= [];
                        // $scope.expenseType = [];
                    },
                    function(error){
                        $scope.createReportResult = error;
                    });
            }
            else {
            	console.log("Name didn't meet requirements");

            }
        }

    // Retrieves the projects in the database and populates the project dropdown.
	$scope.ProjectList = createReportFactory.getProjects().then(
			function(success){
				$scope.projectName = success.data;
			},
			function(error) {
				$scope.projectName = error;
			}
		);
	
	// Retrieves the line item types in the database and populates the line item types dropdown.
	$scope.lineTypesList = createReportFactory.getType().then(
            function(success){
                $scope.result = success.data;
            },
            function(error){
                $scope.result = error;
            }
        );
	
		// Sets the line Items array and line item object to null
		$scope.lineItems=[];
        $scope.lineItem= {};
    
        $scope.lineItemArray = [];
		$scope.count = 0;
		
		// Populates the page with a clean line item object for the user to fill in 
		// with desired values.
		$scope.addLineitem = function(){
            $scope.lineItems.push($scope.lineItem);
		}
		
		// When the page loads, one line item shows on the page.
		$scope.addLineitem();
}])


    