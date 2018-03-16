<p>
	<s:if test="message.receiverId != null">à: <s:property value="message.receiverId" />
	</s:if>
	<s:else>de: <s:if test="message.senderId == null">#SYSTEM#</s:if>
		<s:property value="message.senderId" />
	</s:else>
</p>

<p>
	à
	<s:property value="message.timeStr" />
	, le
	<s:property value="message.dateStr" />
</p>

<p>
	<span class="underline">Objet :</span>
	<s:property value="message.subject" />
</p>

<textarea class="hundWid" rows="20" spellcheck="false" readonly><s:property value="message.content" /></textarea>