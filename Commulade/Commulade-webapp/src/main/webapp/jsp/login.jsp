<form class="autoMar flexCol" action="loginForm" method="post">
	<p>
		<label>Nom d'utilisateur : </label><input id="username" name="user.username" type="text" pattern="[a-zA-Z]{6,32}"
			placeholder="Nom d'Utilisateur..." required> <label>[a-z, A-Z]</label>
	</p>
	<p>
		<label>Mot de passe : </label><input id="password" name="user.password" type="password" pattern=".{6,16}" placeholder="Mot de Passe..."
			required>
	</p>

	<button id="validate" class="seShaButtons">Se connecter</button>
</form>