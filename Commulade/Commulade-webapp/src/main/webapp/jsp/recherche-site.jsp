<aside id="searchCriteria">
	<form action="recherche-site" method="post" onsubmit="return validateForm();">
		<p>
			<input id="siteName" class="observe" name="formBean.siteName" type="text" maxlength="48" placeholder="Nom du site..."
				value="<s:property value="formBean.siteName" />">
		</p>

		<p>Hauteur :</p>
		<p class="inputFormP">
			<input class="numberInput observe" name="formBean.minHeight" type="number" min="1" max="99" placeholder="min..."
				value="<s:property value="formBean.minHeight" />"> - <input class="numberInput observe" name="formBean.maxHeight" type="number"
				min="2" max="100" placeholder="max..." value="<s:property value="formBean.maxHeight" />">
		</p>

		<p>Nombre de points :</p>
		<p class="inputFormP">
			<input class="numberInput observe" name="formBean.minPointNumber" type="number" min="1" max="99" placeholder="min..."
				value="<s:property value="formBean.minPointNumber" />"> - <input class="numberInput observe" name="formBean.maxPointNumber"
				type="number" min="2" max="100" placeholder="max..." value="<s:property value="formBean.maxPointNumber" />">
		</p>

		<p>Cotation :</p>
		<p class="inputFormP">
			<input class="numberInput observe" name="formBean.cotation" type="number" min="3" max="9" placeholder="3-9"
				value="<s:property value="formBean.cotation" />">
		</p>

		<button class="hundWid seShaButtons someButton">Rechercher</button>
	</form>

	<button class="hundWid seShaButtons someButton" onclick="document.location='share-site'">Partager un site</button>
</aside>


<s:if test="list != null">
	<div id="siteContent">

		<s:iterator value="list" var="var">
			<div class="divSiteTopo" onclick="document.location='site/<s:property value="id" />'">
				<div class="flexCol siteTopoContainer">
					<s:property value="name" />

					<s:if test="#var.photoName != null">
						<img class="resizeImg siteImg" alt="Aucune image disponible" src="<s:property value="%{photoPath}" /><s:property value="photoName" />">
					</s:if>
				</div>
			</div>
		</s:iterator>

	</div>
</s:if>
<s:else>
	<h1 class="autoMar">Aucun site n'a été trouvé</h1>
</s:else>
