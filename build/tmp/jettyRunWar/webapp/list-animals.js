(function() {
	'use strict';

	$(document).ready(function() {

		$('.pagination').twbsPagination({
		  totalPages: 35,
		  visiblePages: 7,
		  onPageClick: function (event, page) {
		    animalsService.getAnimalPage(page)
				.then(function(animals) {
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
				});
		  }
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
