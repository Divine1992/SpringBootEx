
(function () {
   'use strict';

   angular
       .module('app')
       .controller('BookingsController', BookingsController);

   BookingsController.$inject['$http'];

   function BookingsController($http) {
       var vm = this;

       vm.bookings = [];
       vm.bookingDetails = {
           hotelName : "",
           pricePerNight : "",
           numberOfNight : ""
       };

       vm.getAll = getAll;
       vm.getAffordable = getAffordable;
       vm.deleteBooking = deleteBooking;
       vm.addHotel = addHotel;
       vm.getHotel = getHotel;
       vm.updateHotel = updateHotel;

       init();

       function init() {
           getAll();
       }

       function getAll() {
           var url = "/bookings/all";
           $http.get(url).then(function (response) {
               vm.bookings = response.data;
           });
       }

       function getAffordable() {
           var url = "/bookings/affordable/" + 100;
           $http.get(url).then(function (response) {
               vm.bookings = response.data;
           });
       }

       function deleteBooking(id){
           var url = "/bookings/delete/" + id;
           $http.post(url).then(function (response) {
               vm.bookings = response.data;
           })
       }

       function addHotel() {
           $http({
            method : 'POST',
            url : 'bookings/create',
            data : angular.toJson(vm.bookingDetails),
            headers : {
                'Content-Type' : 'application/json'
            }
            }).then(function (response) {
             vm.bookings = response.data;});
       }
       
       function getHotel(id) {
           var url = "/bookings/get/" + id;
           $http.get(url).then(function (response) {

           });
       }

       function updateHotel() {
           $http({
            method : 'POST',
            url : 'bookings/update',
            data : angular.toJson(vm.bookingDetails),
            headers : {
                'Content-Type' : 'application/json'
            }
            }).then(function (response) {
             vm.bookingDetails = response.data;});
       }

       /*function selectBooking() {
           vm.bookingDetails.hotelName = vm.bookings.hotelName;
           vm.bookingDetails.numberOfNight = vm.bookings.numberOfNight;
           vm.bookingDetails.pricePerNight = vm.bookings.pricePerNight;
       }*/
   }
})();