<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="./angular.js"></script>
<style>
table, td  {
  border: 1px solid grey;
  border-collapse: collapse;
  padding: 5px;
}
</style>
</head>
<body>
<h1>Hello World!</h1>
<div ng-app="myApp" ng-controller="userCtrl"> 

<!-- <table>
  <tr ng-repeat="x in lists">
    <td ng-if="$odd" style="background-color:#f1f1f1">
    {{ x.id }}</td>
    <td ng-if="$even">
    {{ x.id }}</td>
    <td ng-if="$odd" style="background-color:#f1f1f1">
    {{ x.userName }}</td>
    <td ng-if="$even">
    {{ x.userName }}</td>
  </tr>
</table> -->



</div>

<script>

/* var app = angular.module('myApp', []);
app.controller('userCtrl', function($scope, $http) {
	  $http({method: 'GET', 
		      url: '/NhryService/rest/user/allByPage',
		      params:{
		    	  		  'pageNo':1,
		    	  		  'pageSize':2
		    	       }
	  }).
	  success(function(data, status, headers, config) {
	    alert(data+"");
	    $scope.lists = data.list;
	  }).
	  error(function(data, status, headers, config) {
	      alert('error: ' + data);
	  });
}); */


</script>

</body>
</html>