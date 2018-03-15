<form class="flexCol hundWid" action="share-topo-form" method="post" enctype="multipart/form-data">
	<div id="topo" class="centText hundWid">
		<p>
			<input name="topoForm.name" type="text" maxlength="48" size="50" placeholder="Nom du topo..." required>
		</p>

		<p>
			<label>Date d'�dition du topo: </label> <input name="editionDate" type="date" max="<s:property value="todayDate"/>" required>
		</p>

		<p>
			<textarea name="topoForm.description" maxlength="255" cols="64" rows="4" placeholder="Description du topo..." spellcheck="false"></textarea>
		</p>

		<button id="addSiteBut" class="addItem seShaButtons" type="button" onclick="addSite(this)">Ajouter un site</button>
	</div>

	<s:if test="#attr['username'] != null">
		<p id="wishCheck">
			<input name="wishToShare" type="checkbox"><label>Je poss�de physiquement ce topo et souhaite le partager avec d'autres
				utilisateurs</label>
		</p>
	</s:if>

	<button id="shareButton" class="seShaButtons">Partager</button>
</form>
