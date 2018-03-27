$('#startDate').change(function() {
	setMinMaxOfEndDate();
});

$('#borrowButton').click(function() {
	submitBorrow();
});

/*******************************************************************************
 * Functions
 ******************************************************************************/
function setMinMaxOfEndDate() {
	var startDate = new Date($('#startDate').val());

	var minDay = startDate.getDate();
	if (minDay < 10) {
		minDay = '0' + minDay;
	}

	var minMonth = startDate.getMonth() + 1;
	if (minMonth < 10) {
		minMonth = '0' + minMonth;
	}

	var min = startDate.getFullYear() + '-' + minMonth + '-' + minDay;

	$('#endDate').attr('min', min);

	startDate.setDate(startDate.getDate() + 5);

	var maxDay = startDate.getDate();
	if (maxDay < 10) {
		maxDay = '0' + maxDay;
	}

	var maxMonth = startDate.getMonth() + 1;
	if (maxMonth < 10) {
		maxMonth = '0' + maxMonth;
	}

	var max = startDate.getFullYear() + '-' + maxMonth + '-' + maxDay;

	$('#endDate').attr('max', max);
	$('#endDate').val('');
}

function submitBorrow() {
	var startVal = $('#startDate').val();
	var endVal = $('#endDate').val();

	var startDate = new Date(startVal);
	var endDate = new Date(endVal);
	if (!isNaN(Date.parse(startDate)) && !isNaN(Date.parse(endDate))) {
		if (startDate < endDate) {
			$
					.ajax({
						type : 'POST',
						url : 'borrow-topo-owned?startDate=' + startVal
								+ '&endDate=' + endVal,
						success : function(data) {
							console.log(data);
							if ($.trim(data)) {
								$('#borrowDiv').html(data);
							} else {
								$('#borrowDiv')
										.html(
												'Votre emprunt à été enregistré, mais le prêteur peut toujours le refuser si il le souhaite.'
														+ '<br>'
														+ 'Nous vous conseillons de le contacter.');
							}
						}
					});
		}
	}
}
