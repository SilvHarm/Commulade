window.onload = adaptHeight();

$(window).resize(function() {
	adaptHeight();
});

function adaptHeight() {
	$('.aMainSite').css('height', $('.aMainSite').width());
}
