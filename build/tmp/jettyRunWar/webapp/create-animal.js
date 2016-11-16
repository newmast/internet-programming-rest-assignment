(function() {
    'use strict';

    $(document).ready(function() {
        $('#submit').on('click', function() {
            var species = $('#species-input').val(),
                numberOfLegs = $('#legs-input').val(),
                color = $('#color-input').val(),
                age = $('#age-input').val();

            createAnimal({
                "species": species,
                "numberOfLegs": numberOfLegs,
                "color": color,
                "age": age
            });
        });
    });

    function createAnimal(animal) {
        animalsService.createAnimal(animal);
    }
}());
