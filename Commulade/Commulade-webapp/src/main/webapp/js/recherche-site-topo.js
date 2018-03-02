/*
 * When window size change, the elements of the class "aMainSite" will their height adjusted to their new width
 */
window.onload = adaptHeight();

$(window).resize(function() {
	adaptHeight();
});

/*
 * Functions
 */
function adaptHeight() {
	$('.aMainSite').css('height', $('.aMainSite').width());
}

// Test if an element with the class "observe" is not empty
function validateForm() {
	var list = $('.observe');

	for (var i = 0, len = list.length; i < len; i++) {
		if (!($(list[i]).val() === "")) {
			return true;
		}
	}

	return false;
}
