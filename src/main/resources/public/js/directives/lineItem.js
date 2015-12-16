

//Create a directive, first parameter is the html element to be attached.	  
//We are attaching student html tag. 
//This directive will be activated as soon as any student element is encountered in html

angular.module('myApp').directive('lineitem', function() {
   //define the directive object
   var directive = {};
   
   //restrict = E, signifies that directive is Element directive
   directive.restrict = 'E';
   
   //scope is used to distinguish each student element based on criteria.
   directive.scope = {
      lineitem : "=name"
   }
   
   //template replaces the complete element with its text. 
   directive.template =
	   '<form class="container" id="lineitems" class="form-inline" role="form">\
        		  <div class="row">\
        		     <div class="form-group col-sm-4">\
        		      <label><h3>Add Line Items</h3></label>\
        		    </div>\
        		    <div class="col-sm-4">\
        		      <label>Expense Type:</label>\
	   				<select class="form-control" class="lineItemType" ng-model="lineitem.lineItem.ineItemType.lineItemType">\
	   					<option value="">Select your Expense Type</option>\
       					<option ng-repeat="value in lineitem.lineItemsList" value="{{value.lineItemType}}">\
           					{{value.lineItemType}}\
           				</option>\
           			</select>\
       		      </div>\
        		      <div class="form-group col-sm-4">\
        		      <label>Expense Amount:</label>\
        		      <input type="text" class="form-control" class="monetaryAmount" format="currency" ng-model="lineitem.lineItem.monetaryAmount" placeholder="$0.00">\
        		     </div>\
        		  </div>\
        		  <div class="row">\
        		</div>\
        	</form>';
   
  
   
   //compile is called during application initialization. AngularJS calls it once when html page is loaded.
	
   directive.compile = function(element, attributes) {
      //element.css("border", "5px solid #000000");
      
      //linkFunction is linked with each element with scope to get the element specific data.
     var linkFunction = function($scope, element, attributes) {
         element.css("background-color", "#000000");
      }
     return linkFunction;
   }
   return directive;
});
