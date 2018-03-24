<header>
	<nav>
		<a class="falseButtonHeader" href="welcome">Accueil</a>

		<a class="falseButtonHeader" href="recherche-site">Les Sites de Grimpe</a>

		<a class="falseButtonHeader" href="recherche-topo">Les Topos</a>

		<a class="falseButtonHeader" href="search-lend-topo">Espace de Prêt</a>


		<s:if test="#attr['username'] != null">
			<a class="falseButtonHeader" href="message">Messagerie</a>
		</s:if>


		<div id="divDisLogRegHeader">
			<s:if test="#attr['username'] != null">
				<s:include value="/WEB-INF/content/jsp/parts/disconnect.jsp"></s:include>
			</s:if>
			<s:else>
				<s:include value="/WEB-INF/content/jsp/parts/logreg.jsp"></s:include>
			</s:else>
		</div>
	</nav>

	<hr id="topHrHeader">
	<hr>
</header>
