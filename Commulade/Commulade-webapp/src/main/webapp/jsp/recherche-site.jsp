<aside id="searchCriteria">
	<form action="recherche-site" method="post">
		<p>
			<input id="siteName" name="formBean.siteName" type="text" maxlength="48" placeholder="Nom du site...">
		</p>

		<p>Minimum de voies :</p>
		<p class="inputFormP">
			<input class="numberInput" name="formBean.minVoieNumber" type="number" min="1" max="100" placeholder="min...">
		</p>

		<p>Hauteur :</p>
		<p class="inputFormP">
			<input class="numberInput" name="formBean.minHeight" type="number" min="1" max="99" placeholder="min..."> - <input
				class="numberInput" name="formBean.maxHeight" type="number" min="2" max="100" placeholder="max...">
		</p>

		<p>Nombre de points :</p>
		<p class="inputFormP">
			<input class="numberInput" name="formBean.minPointNumber" type="number" min="1" max="99" placeholder="min..."> - <input
				class="numberInput" name="formBean.maxPointNumber" type="number" min="2" max="100" placeholder="max...">
		</p>

		<button id="searchButton">Rechercher</button>
	</form>
</aside>

<s:if test="list != null">
	<div id="siteContent">
		<s:iterator value="list" var="var">
			<a class="aMainSite" href="site/<s:property value="id" />">
				<s:property value="name" />
				<s:if test="#var.photoName != null">
					<img class="resizeImg" alt="Aucune image disponible" src="<s:property value="%{photoPath}" /><s:property value="photoName" />">
				</s:if>
			</a>
		</s:iterator>
	</div>
</s:if>
<s:else>
	<h1 class="autoMar">Aucun site n'a été trouvé</h1>
</s:else>
