<form class="autoMar flexCol" action="registerForm" method="post">
	<p>
		<label>Nom d'utilisateur : </label><input id="username" name="user.username" type="text" pattern="[0-9a-zA-Z]{6,32}" maxlength="32"
			placeholder="Nom d'Utilisateur..." required> <label>[0-9, a-z, A-Z]</label>
	</p>
	<p>
		<label>Mot de passe : </label><input id="password" name="user.password" type="password" pattern=".{6,16}" placeholder="Mot de Passe..."
			required>
	</p>

	<button id="validate" class="seShaButtons">S'enregistrer</button>
</form>