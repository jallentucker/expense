angular.module('myApp').controller('projectCtrl',['$scope', 'projectFactory', function($scope, projectFactory){
    $scope.welcomeMsg = "PROJECT!!!!"
    
    $scope.project = {};
}])