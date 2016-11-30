var animalsService = (function() {
    'use strict';
    var baseUrl = 'http://localhost:8081/rst/';
    function getAnimalPage(page, species, numberOfLegs, color, age) {
        return new Promise(function(resolve, reject) {
            var queryUrl = 'api/animals?page=' + page;

            if (species) {
                queryUrl += '&species=' + species;
            }

            if (numberOfLegs) {
                queryUrl += '&numberOfLegs=' + numberOfLegs;
            }

            if (color) {
                queryUrl += '&color=' + color;
            }

            if (age) {
                queryUrl += '&age=' + age;
            }

            $.get({
                url: baseUrl + queryUrl,
                dataType: "json",
                success: resolve
            });
        });
    }

    function getSpeciesNames() {
        return new Promise(function(resolve, reject) {
            $.get({
                url: baseUrl + "api/animals/species",
                dataType: "json",
                success: resolve
            });
        });
    }

    function createAnimal(animal) {
        return new Promise(function(resolve, reject) {
            $.ajax({
              contentType: 'application/json',
              url: baseUrl + 'api/animals',
              method: "POST",
              data: JSON.stringify(animal),
              dataType: "json"
          }).success(function(data) {
              resolve(data);
          }).error(function(err) {
              console.log(err);
          });
        });
    }

    return {
        getAnimalPage: getAnimalPage,
        getSpeciesNames: getSpeciesNames,
        createAnimal: createAnimal
    };
}());
