<aside id="searchCriteria">
	<form class="flexCol" action="search-topo-owned" method="post" onsubmit="return validateForm();">
		<p>
			<input id="siteName" class="observe" name="name" type="text" maxlength="48" placeholder="Nom du topo..."
				value="<s:property value="name" />">
		</p>

		<button class="seShaButtons someButton">Rechercher</button>
	</form>
</aside>


<div class="hundWid">
	<s:if test="borrowedList != null">
		<div class="hundWid listTopoOwned">
			<s:iterator value="borrowedList" var="topoOwned">
				<s:include value="/WEB-INF/content/jsp/parts/topo-owned-search-view.jsp" />
			</s:iterator>
		</div>

		<hr class="hundWid siteSeparator">
	</s:if>


	<s:if test="userOwnedList != null">
		<div class="hundWid listTopoOwned">
			<s:iterator value="userOwnedList" var="topoOwned">
				<s:include value="/WEB-INF/content/jsp/parts/topo-owned-search-view.jsp" />
			</s:iterator>
		</div>

		<hr class="hundWid siteSeparator">
	</s:if>


	<s:if test="notOwnedList != null">
		<div class="hundWid listTopoOwned">
			<s:iterator value="notOwnedList" var="topoOwned">
				<s:include value="/WEB-INF/content/jsp/parts/topo-owned-search-view.jsp" />
			</s:iterator>
		</div>
	</s:if>
	<s:else>
		<h1 class="autoMar">Aucun utilisateur ne prête de topo en ce moment</h1>
	</s:else>
</div>
