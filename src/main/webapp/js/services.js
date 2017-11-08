$
angular.module('st.services', [])
  .factory('StockService', function($http, $rootScope) {
    var url = '/stocks';
    return {
      updateFavouriteList: function(symbol) {
        return $http.put(url + "/"+ symbol, null).then(function(result) { return result.data; });
      },

      getAllStocks: function(pageNumber, pageSize) {
    	  pageNumber = pageNumber || 0;
    	  pageSize = pageSize || 10;
      	return $http.get(url + "/all?page="+pageNumber +"&size="+pageSize).then(function(result) { return result.data; });
      },

      getFavouriteStockList: function() {
        return $http.get(url + "/favourites").then(function(result) { return result.data; });
      }

    }
  });