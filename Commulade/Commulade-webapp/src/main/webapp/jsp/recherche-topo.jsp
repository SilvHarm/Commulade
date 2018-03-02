<aside id="searchCriteria">
	<form class="flexCol" action="recherche-topo" method="post">
		<p>
			<input id="siteName" class="observe" name="name" type="text" maxlength="48" placeholder="Nom du topo..."
				value="<s:property value="name" />">
		</p>

		<button id="searchButton">Rechercher</button>
	</form>
</aside>

<s:if test="list != null">
	<div id="siteContent">
		<s:iterator value="list" var="var">
			<a class="aMainSite" href="topo/<s:property value="id" />">
				<div class="flexCol topoContainer">
					<s:property value="name" />

					<p class="noMar description">
						<s:if test="#var.description != null">
							<s:property value="description" />
						</s:if>
					</p>

					<s:property value="editionDate" />
				</div>
			</a>
		</s:iterator>
	</div>
</s:if>
<s:else>
	<h1 class="autoMar">Aucun topo n'a été trouvé</h1>
</s:else>
