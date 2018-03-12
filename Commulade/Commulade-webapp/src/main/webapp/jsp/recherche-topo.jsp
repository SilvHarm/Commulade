<aside id="searchCriteria">
	<form class="flexCol" action="recherche-topo" method="post" onsubmit="return validateForm();">
		<p>
			<input id="siteName" class="observe" name="name" type="text" maxlength="48" placeholder="Nom du topo..."
				value="<s:property value="name" />">
		</p>

		<button class="seShaButtons someButton">Rechercher</button>
	</form>
</aside>


<s:if test="list != null">
	<div id="siteContent">

		<s:iterator value="list" var="var">
			<div class="divSiteTopo" onclick="document.location='topo/<s:property value="id" />'">
				<div class="flexCol siteTopoContainer">
					<s:property value="name" />

					<p class="noMar description">
						<s:if test="#var.description != null">
							<s:property value="description" />
						</s:if>
					</p>

					<s:property value="editionDate" />
				</div>
			</div>
		</s:iterator>

	</div>
</s:if>
<s:else>
	<h1 class="autoMar">Aucun topo n'a été trouvé</h1>
</s:else>
