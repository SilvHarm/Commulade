<form action="send-message">
	<p>
		<input name="sendMessageForm.receiverName" type="text" pattern="[a-zA-Z]{6,32}" maxLength="32" size="35"
			placeholder="Nom du destinataire..." required>
	</p>

	<p>
		<input name="sendMessageForm.subject" type="text" maxLength="32" size="35" placeholder="Objet du message..." required>
	</p>

	<p>
		<span class="underline">Message :</span>
	</p>

	<textarea class="hundWid" name="sendMessageForm.content" rows="16" maxlength="1024" spellcheck="false" required></textarea>

	<button id="sendButton" class="messageButton seShaButtons">Envoyer</button>
</form>
