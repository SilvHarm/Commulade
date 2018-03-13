var parent;
/*
 * When window size change, the elements of the class "imgSecteur" will have
 * their height adjusted to be equal to new width
 */
window.onload = adaptHeight();
window.onload = buttonSet();

$(window).resize(function() {
	adaptHeight();
});

/*
 * When an element of one the classes is clicked, it will either hide or reveal
 * the rest of their parent
 */
if ($('.hSiteObserver').length > 1) {
	$('.hSiteObserver').css('cursor', 'pointer');

	$('.hSiteObserver').click(function() {
		siteHideAndSeek(this);
	});
}

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
	$('.col-3').css('height', $('.col-3').css('width'));
	$('.imgSecObs').css('height', $('body').width() * 0.15);
}

function buttonSet() {
	$("#iDontOwnIt").click(function() {
		iDontOwnIt();
	});

	$("#iOwnIt").click(function() {
		iOwnIt();
	});
}

function hideAndSeek(element, parent) {
	var elemHeight = $(element).css('height');

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

function iDontOwnIt() {
	$.ajax({
		type : 'POST',
		url : 'iDontOwnIt',
		success : function(data) {
			setPowning(data);
		}
	});
}

function iOwnIt() {
	$.ajax({
		type : 'POST',
		url : 'iOwnIt',
		success : function(data) {
			setPowning(data);
		}
	});
}

function secHideAndSeek(element) {
	parent = $(element).parent();

	if (hideAndSeek(element, parent)) {
		$('html').animate({
			scrollTop : $(element).offset().top
		}, 200);
	}
}

function setPowning(html) {
	$('#powning').html(html);

	buttonSet();
}

function siteHideAndSeek(element) {
	parent = $(element).parent().parent().parent();

	if (hideAndSeek(element, parent)) {
		$('html').animate({
			scrollTop : $(parent).offset().top
		}, 200);
	}
}

function voieHideAndSeek(element) {
	parent = $(element).parent();

	if (hideAndSeek(element, parent)) {
		$('html').animate({
			scrollTop : $(parent).parent().offset().top
		}, 200);
	}
}
