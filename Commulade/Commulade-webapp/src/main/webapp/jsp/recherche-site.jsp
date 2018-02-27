<aside id="searchCriteria">
	<p>Nom du Site :</p>

	<p>Nombre de voies :</p>

	<p>Hauteur :</p>

	<p>Nombre de points :</p>
</aside>

<s:if test="list != null">
	<div id="siteContent">
		<s:iterator value="list" var="var">
			<a class="aMainSite" href="site/<s:property value="id" />">
				<s:property value="name" />
				<s:if test="#var.photoName != null">
					<img class="siteImg" alt="Aucune image disponible" src="<s:property value="%{photoPath}" /><s:property value="photoName" />">
				</s:if>
			</a>
		</s:iterator>
	</div>
</s:if>
<s:else>
	<h1 id="noSiteFound">Aucun site n'a été trouvé</h1>
</s:else>
