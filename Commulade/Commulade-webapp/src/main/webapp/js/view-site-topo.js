var parent;

$('.comButton').click(function() {
	getComment(this);
});

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

function getComment(element) {
	var parent = $(element).parent();
	var postId = $(parent).attr('data-postid');
	var postType = $(parent).attr('data-postType');

	$.ajax({
		type : 'POST',
		url : 'get-comment',
		data : jQuery.param({
			postId : postId,
			postType : postType
		}),
		success : function(data) {
			$(element).html('Cacher les commentaires');
			$(element).unbind();
			$(element).click(function() {
				hideComment(this);
			});

			$(parent).append(data);
			$(parent).find('#postId').attr('value', postId);
			$(parent).find('#postType').attr('value', postType);
		}
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

function hideComment(element) {
	$(element).html('Afficher les commentaires');
	$(element).unbind();
	$(element).click(function() {
		getComment(this);
	});

	$(element).parent().children('div').remove();
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
