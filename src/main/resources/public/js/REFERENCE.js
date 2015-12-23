/*DO NOT DELETE!!!
    DO NOT DELETE!!!
        DO NOT DELETE!!!
            DO NOT DELETE!!!
                DO NOT DELETE!!!
                    DO NOT DELETE!!!
                        DO NOT DELETE!!!
                            DO NOT DELETE!!!
                                THIS IS FOR REFERENCE
                                    CLEANER WAY TO DO THE LINE ITEM MESS
                            */
                                



angular.module('myApp').controller('createReportController',
		['$q', '$scope', '$compile', '$element', 'createReportFactory', 
		 'toastr', function($q, $scope, $compile, $element, createReportFactory, 
		  toastr){
                 
	// Sets variable values
    $scope.lineItemId = [];
             $scope.lineItems=[];
        $scope.lineItemArray = [];

   //Adds Another line item row to the ng repeat
    $scope.addLineitem = function(){
        var lineItemObject = {
            'lineItemId': null,
            'lineItemType' : {
                'lineItemTypeId': null
            },
            'monetaryAmount' : null,
            'report' : {
                'reportId' : null
            }             
        }
        $scope.lineItems.push(lineItemObject);
    }
             
    // Adds a report and line items to the database.  This also persists any changes made before the
    // report is submitted to the database and you're returned to the home page.
    $scope.createReport = function(report, selectedProject, status){
            if(report.reportName.length > 2) {
            	createReportFactory.createReport(report).then(
                    function(success){
            
                        report.reportId = success.data;
                    
                        //creates an array for the promises
                        var promiseArray = [];

                        // Posts/Updates each line item on the screen
                        for(var i = 0; i < $scope.lineItems.length; i++){
                            $scope.lineItems[i].report.reportId = success.data;
                        	var promise = createReportFactory.postLineItem($scope.lineItems[i]).then(
                                function(success){
                                    $scope.lineItemId.push(success.data.lineItemId);
                                },
                                function(error){
                                    console.log(error);
                                }
                            );
                            //Adds the promise to an array so we can make js wait for them all to be done
                            promiseArray.push(promise);
                        }
                        
                        // Executes once all promises in promiseArray have been resolved
                        $q.all(promiseArray).then(function() {
                            $scope.lineItemId.sort(function(a, b) {
                                return a - b;
                            });
                        });
                        
                        // Sets line item id
                        for(var i = 0; i < lineItemIdArray.length; i++){
                            lineItemIdArray[i].lineItemId = $scope.lineItemId[i];
                        }
                        // Clears the array so you dont get ids mixed up next time the save button is clicked
                        $scope.lineItemId = [];
                    },
                    function(error){
                        $scope.createReportResult = error;
                    });
            }
            else {
            	console.log("Name didn't meet requirements");

            }
    }
}])






<div ng-repeat="a in lineItems track by $index">
    <div class="row">
        <div class="form-group col-sm-4"> <br>
            <label id="newLineItem">New Line Item:</label>
        </div>
        <div class="col-sm-4">
            <label>Expense Type:</label>
            <select ng-change = "onChange()" class="form-control" ng-model="lineItems[$index].lineItemType.lineItemTypeId" required>
                <option value="">Select your Expense Type</option>
                <option ng-repeat="value in result" ng-value="{{value.lineItemTypeId}}">{{value.lineItemType}}</option>                    
            </select>
        </div>
                
        <div class="form-group col-sm-4">
            <label>Expense Amount:</label>
            <input ng-change = "onChange()" type="number" min="0" step="0.01" class="form-control currency" ng-model="lineItems[$index].monetaryAmount"  placeholder="$0.00" required>
        </div>
    </div>
    <div class="row">
    </div>
</div>