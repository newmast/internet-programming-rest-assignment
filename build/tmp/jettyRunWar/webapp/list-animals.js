(function() {
	'use strict';

	$(document).ready(function() {
		var currentlyOpenPage = 1,
			speciesFilter = '',
			numberOfLegsFilter = '',
			colorFilter = '',
			ageFilter = '';

		function updatePage() {
			animalsService
			  .getAnimalPage(currentlyOpenPage, speciesFilter, numberOfLegsFilter, colorFilter, ageFilter)
			  .then(updateTable);
		}

		function updateTable(animals) {
			$('.all-animals').empty();
			addTableHeader($('.all-animals'));
			animals.forEach(function(animal) {
				var $row = $('<tr />');
				addColumn($row, animal.species);
				addColumn($row, animal.numberOfLegs);
				addColumn($row, animal.color);
				addColumn($row, animal.age);
				$('.all-animals').append($row);
			});
		}

		$('.pagination').twbsPagination({
		  totalPages: 35,
		  visiblePages: 7,
		  onPageClick: function (event, page) {
			  currentlyOpenPage = page;
			  updatePage();
		  }
		});

		animalsService.getSpeciesNames()
			.then(function(species) {
			  $('.species-search').autocomplete({
			      source: species,
				  select: function(event, ui) {
		  			speciesFilter = ui.item.value;
					updatePage();
				  }
			  });
			});

		$('.species-search').on('input', function() {
			speciesFilter = $(this).val();
			updatePage();
		});

		$('.numberOfLegs-search').on('input', function() {
			numberOfLegsFilter = $(this).val();
			updatePage();
		});

		$('.color-search').on('input', function() {
			colorFilter = $(this).val();
			updatePage();
		});

		$('.age-search').on('input', function() {
			ageFilter = $(this).val();
			updatePage();
		});
	});

	function addTableHeader($table) {
		$table.html('<tr>' +
			'<th>Species</th>' +
			'<th>Number of legs</th>' +
			'<th>Color</th>' +
			'<th>Age</th>' +
		'</tr>');
	}

	function addColumn($row, value) {
		var $col = $('<td />');
		$col.text(value);
		$row.append($col);
	}
}());
