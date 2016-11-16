var animalsService = (function() {
    'use strict';
    var baseUrl = 'http://localhost:8081/rst/';
    function getAnimalPage(page) {
        return new Promise(function(resolve, reject) {
            $.get({
                url: baseUrl + 'api/animals?page=' + page,
                dataType: "json",
                success: function(data){
                    resolve(data);
                }
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
        createAnimal: createAnimal
    };
}());
