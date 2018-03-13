<header>
	<nav>
		<a class="falseButtonHeader" href="welcome">Accueil</a>

		<a class="falseButtonHeader" href="recherche-site">Les Sites de Grimpe</a>

		<a class="falseButtonHeader" href="recherche-topo">Les Topos</a>

		<a class="falseButtonHeader" href="pret-topo">Espace de Prêt</a>


		<div id="divDisLogRegHeader">
			<s:if test="#attr['username'] != null">
				<s:include value="/jsp/parts/disconnect.jsp"></s:include>
			</s:if>
			<s:else>
				<s:include value="/jsp/parts/logreg.jsp"></s:include>
			</s:else>
		</div>
	</nav>

	<hr id="topHrHeader">
	<hr>
</header>
