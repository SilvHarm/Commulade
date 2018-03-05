/*
 * When window size change, the elements of the class "imgSecteur" will have their height adjusted to be equal to new width
 */
window.onload = adaptHeight();

$(window).resize(function() {
	adaptHeight();
});

/*
 * When an element of one the classes is clicked, it will either hide or reveal
 * the rest of their parent
 */
$('.hSecObserver').click(function() {
	secHideAndSeek(this);
});

$('.hVoieObserver').click(function() {
	voieHideAndSeek(this);
});

/*
 * Functions
 */
function adaptHeight() {
	$('.imgSecObs').css('height', $('body').width() * 0.15);
}

function hideAndSeek(element) {
	var elemHeight = $(element).css('height');
	var parent = $(element).parent();

	if ($(parent).css('height') != elemHeight) {
		$(parent).animate({
			height : elemHeight
		}, 300);
	} else {
		$(parent).css({
			height : 'unset'
		});

		return true;
	}
}

function secHideAndSeek(element) {
	if (hideAndSeek(element)) {
		$('html').animate({
			scrollTop : $(element).offset().top
		}, 200);
	}
}

function voieHideAndSeek(element) {
	if (hideAndSeek(element)) {
		$('html').animate({
			scrollTop : $(element).parent().parent().offset().top
		}, 200);
	}
}
