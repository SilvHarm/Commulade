<header>
	<nav>
		<a class="falseButtonHeader" href="welcome">Accueil</a>

		<a class="falseButtonHeader" href="recherche-site">Les Sites de Grimpe</a>

		<a class="falseButtonHeader" href="recherche-topo">Les Topos</a>

		<a class="falseButtonHeader" href="pret-topo">Espace de Prêt</a>


		<s:if test="username != null">
			<a class="disLogRegHeader" href="disconnect">
				<s:property value="username" />
				: Se Déconnecter
			</a>
		</s:if>
		<s:else>
			<a class="disLogRegHeader" href="register">S'inscrire</a>
			<span id="ou">OU</span>
			<a class="disLogRegHeader" href="login">Se Connecter</a>
		</s:else>
	</nav>

	<hr id="topHrHeader">
	<hr>
</header>
