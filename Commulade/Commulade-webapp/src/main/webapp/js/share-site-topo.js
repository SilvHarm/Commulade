var siteCount = 0;
var i, j, k, l, parent, tempo;

$(function() {
	if ($('#topo').length != 0) {
		console.log('Topo');
	} else {
		i = 0;
		j = 0;
		k = 0;
		l = 0;

		$('form').prepend(siteHtml);
		$('form > div > hr').remove();
		$('form > div > button.delInline').remove();
	}
});

/*******************************************************************************
 * Functions
 ******************************************************************************/
function addSite(element) {
	i = siteCount;
	j = 0;
	k = 0;
	l = 0;

	$(element).before(siteHtml());

	siteCount++;
}

function addSecteur(element) {
	parent = $(element).parent();

	i = $(element).parent().attr('data-id');
	j = parseInt(parent.children('div:last').attr('data-id')) + 1;
	k = 0;
	l = 0;

	$(element).before(secteurHtml());
}

function addVoie(element) {
	parent = $(element).parent();

	i = parent.parent().attr('data-id');
	j = parent.attr('data-id');
	k = parseInt(parent.children('div:last').attr('data-id')) + 1;
	l = 0;

	$(element).before(voieHtml());
}

function addLongueur(element) {
	parent = $(element).parent();

	i = parent.parent().parent().attr('data-id');
	j = parent.parent().attr('data-id');
	k = parent.attr('data-id');
	l = parseInt(parent.children('div:last').attr('data-id')) + 1;

	$(element).before(longueurHtml());
}

function deleteItem(element) {
	parent = $(element).parent();

	if (parent.parent().children('div').length > 1) {
		parent.remove();
	}
}

/*******************************************************************************
 * html
 ******************************************************************************/
function deleteButton() {

	return '<button class="delInline removeItem" type="button" onclick="deleteItem(this)"><span class="deleteSymbol">X</span></button>';
}

function siteHtml() {
	return '<div class="centText divSeek" data-id="'
			+ siteCount
			+ '">'

			+ '<hr class="hundWid siteSeparator"><hr class="hundWid siteSeparator">'

			+ '<p class="delInline"><input name="topoForm.listSite['
			+ siteCount
			+ '].name" type="text" maxlength="48" size="50" placeholder="Nom du site..." required></p>'

			+ deleteButton()

			+ '<p><input name="topoForm.listSite['
			+ siteCount
			+ '].photo" type="file" accept=".png, .jpg, .jpeg"></p>'

			+ '<p><textarea class="biggerFont" name="topoForm.listSite['
			+ siteCount
			+ '].place" maxlength="127" cols="32" rows="4" placeholder="Lieu du site..." spellcheck="false" required></textarea></p>'

			+ '<p><textarea class="biggerFont" name="topoForm.listSite['
			+ siteCount
			+ '].pathIndication" maxlength="255" cols="64" rows="4" placeholder="Chemin pour se rendre sur le site..." spellcheck="false" required></textarea></p>'

			+ secteurHtml()

			+ '<button class="addItem" type="button" onclick="addSecteur(this)">Ajouter un secteur</button>'
			+ '</div>';
}

function secteurHtml() {
	return '<div class="centText divSeek" data-id="'
			+ j
			+ '">'

			+ '<hr class="hundWid">'

			+ '<p class="delInline"><input name="topoForm.listSite['
			+ i
			+ '].listSecteur['
			+ j
			+ '].name" type="text" maxlength="48" size="50" placeholder="Nom du secteur..." required></p>'

			+ deleteButton()

			+ '<p><input name="topoForm.listSite['
			+ i
			+ '].listSecteur['
			+ j
			+ '].photo" type="file" accept=".png, .jpg, .jpeg"></p>'

			+ voieHtml()

			+ '<button class="addItem" type="button" onclick="addVoie(this)">Ajouter une voie</button>'
			+ '</div>';
}

function voieHtml() {
	return '<div class="centText divSeek" data-id="'
			+ k
			+ '">'

			+ '<p class="delInline"><input name="topoForm.listSite['
			+ i
			+ '].listSecteur['
			+ j
			+ '].listVoie['
			+ k
			+ '].name" type="text" maxlength="48" size="50" placeholder="Nom de la voie..." required></p>'

			+ deleteButton()

			+ longueurHtml()

			+ '<button class="addItem" type="button" onclick="addLongueur(this)">Ajouter une longueur</button>'
			+ '</div>';
}

function longueurHtml() {
	return '<div class="centText divSeek" data-id="'
			+ l
			+ '">'

			+ '<p class="delInline"><input name="topoForm.listSite['
			+ i
			+ '].listSecteur['
			+ j
			+ '].listVoie['
			+ k
			+ '].listLongueur['
			+ l
			+ '].height" type="number" min="0" max="32000" placeholder="Hauteur en mètre..." required>'

			+ '<input name="topoForm.listSite['
			+ i
			+ '].listSecteur['
			+ j
			+ '].listVoie['
			+ k
			+ '].listLongueur['
			+ l
			+ '].nombrePoints" type="number" min="0" max="32000" placeholder="Nombre de points..." required>'

			+ '<input name="topoForm.listSite['
			+ i
			+ '].listSecteur['
			+ j
			+ '].listVoie['
			+ k
			+ '].listLongueur['
			+ l
			+ '].cotation" type="text" maxlength="8" size="10" placeholder="Cotation..." required></p>'

			+ deleteButton()

			+ '</div>';
}
