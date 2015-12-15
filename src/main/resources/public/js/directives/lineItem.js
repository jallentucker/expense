

//Create a directive, first parameter is the html element to be attached.	  
//We are attaching student html tag. 
//This directive will be activated as soon as any student element is encountered in html

angular.module('myApp').directive('lineitem', function() {
   //define the directive object
   var directive = {};
   
   //restrict = E, signifies that directive is Element directive
   directive.restrict = 'E';
   
   //template replaces the complete element with its text. 
   directive.template =
	   '<form class="container" id="addLineitemForm" class="form-inline" role="form">\
        		  <div class="row">\
        		     <div class="form-group col-sm-4">\
        		      <label><h3>{{lineitem.name}}</h3></label>\
        		    </div>\
        		    <div class="col-sm-4">\
        		      <label>Expense Type:</label>\
	   				<select class="form-control" ng-model="lineitem.value">\
	   					<option value="">Select your Expense Type</option>\
       					<option ng-repeat="value in lineitem.values" value="{{value}}">\
           					{{value}}\
           				</option>\
           			</select>\
       		      </div>\
        		      <div class="form-group col-sm-4">\
        		      <label>Expense Amount:</label>\
        		      <input type="text" class="form-control" id="monetaryValue" format="currency" ng-model="lineitem.money"placeholder={{lineitem.money|currency}}>\
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
