$(".messAge").click(function() {
	getMessage(this);
});

$(".notRead").click(function() {
	wasRead(this);
});

/*******************************************************************************
 * Functions
 ******************************************************************************/
function getMessage(element) {
	var id = parseInt($(element).attr('data-id'));

	if (Number.isInteger(id)) {
		$.ajax({
			type : 'POST',
			url : 'view-message?messageId=' + id,
			success : function(data) {
				$('#messageDiv').html(data);
			}
		});
	}
}

function getSendMessageForm() {
	$.ajax({
		type : 'POST',
		url : 'get-message-form',
		success : function(data) {
			$('#messageDiv').html(data);
		}
	});
}

function wasRead(element) {
	var id = parseInt($(element).attr('data-id'));

	if (Number.isInteger(id)) {
		$.ajax({
			type : 'POST',
			url : 'message-read?messageId=' + id
		});

		$(element).removeClass("notRead");
	}
}