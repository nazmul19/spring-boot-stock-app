var myStock = angular.module('stock', ['ngRoute', 'st.services', 'st.allStock',
	'st.favouriteStock', 'ui.bootstrap']);
	
	myStock.config(["$routeProvider", function ($routeProvider) {
		$routeProvider.when('/', {controller: 'AllStockController', templateUrl: 'all-stock-tpl.html'});
		$routeProvider.when('/favouriteStocks', {controller: 'FavouriteStockController', templateUrl: 'favourite-stock-tpl.html'});
	}]);
	
	myStock.config(["$httpProvider", function ($httpProvider) {
	    $httpProvider.interceptors.push('LoadingInterceptor');
	}]);
	
	/*myStock.config(["$locationProvider", function($locationProvider) {
		$locationProvider.html5Mode(true);
	    $locationProvider.hashPrefix('!');
    }]);*/
	
	myStock.service('LoadingInterceptor', ['$q', '$rootScope', '$log', 
		function ($q, $rootScope, $log) {
		    'use strict';
		 
		    var xhrCreations = 0;
		    var xhrResolutions = 0;
		 
		    function isLoading() {
		        return xhrResolutions < xhrCreations;
		    }
		 
		    function updateStatus() {
		        $rootScope.loading = isLoading();
		    }
		 
		    return {
		        request: function (config) {
		            xhrCreations++;
		            updateStatus();
		            return config;
		        },
		        requestError: function (rejection) {
		            xhrResolutions++;
		            updateStatus();
		            $log.error('Request error:', rejection);
		            return $q.reject(rejection);
		        },
		        response: function (response) {
		            xhrResolutions++;
		            updateStatus();
		            return response;
		        },
		        responseError: function (rejection) {
		            xhrResolutions++;
		            updateStatus();
		            $log.error('Response error:', rejection);
		            return $q.reject(rejection);
		        }
		    };
		}]);