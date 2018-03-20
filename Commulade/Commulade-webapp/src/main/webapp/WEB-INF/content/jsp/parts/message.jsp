<p>
	<s:if test="message.receiverId != null">à: <s:property value="otherName" />
	</s:if>
	<s:else>de: <s:if test="otherName == null">
			<b>#SYSTEM#</b>
		</s:if>
		<s:else>
			<b><span id="messageUsername"><s:property value="otherName" /></span></b>
			<button class="seShaButtons answerButton">Répondre</button>
		</s:else>
	</s:else>
</p>

<p>
	à
	<s:property value="message.timeStr" />
	, le
	<s:property value="message.dateStr" />
</p>

<p>
	<span class="underline">Objet :</span> <span id="messageObject"><s:property value="message.subject" /></span>

</p>

<textarea class="hundWid viewMessageArea" rows="18" spellcheck="false" readonly><s:property value="message.content" /></textarea>
