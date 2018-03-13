window.onload = setDisconnectHeader();

/*
 * Functions
 */
function disconnect() {
	$.ajax({
		type : 'POST',
		url : 'disconnect',
		success : function(data) {
			setDivDisLogRegHeader(data);
		}
	});
}

function setDisconnectHeader() {
	$("#disconnectHeader").click(function() {
		disconnect();
	});
}

function setDivDisLogRegHeader(html) {
	$('#divDisLogRegHeader').html(html);
}
