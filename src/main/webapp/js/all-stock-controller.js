var favouriteStock = angular.module("st.allStock", []);
favouriteStock.controller('AllStockController', function($rootScope, $scope, $anchorScroll, StockService){
	$scope.pageNumber = 1;
	$scope.pageSize = 12;
	
	
	$scope.getItems = function(){
		StockService.getAllStocks($scope.pageNumber - 1, $scope.pageSize).then(function(data){
			$scope.page = data;
		})
	}
	
	$scope.loadMore = function(){
		var pageSize = $scope.page.size + $scope.pageSize;
		StockService.getAllStocks($scope.pageNumber - 1, pageSize ).then(function(data){
			$scope.page = data;
			/*$localtion.hash("loadMore");
			$anchorScroll();*/
		})
		
	}
	
	var init = function(){
		$scope.getItems();
	}
	init();
});