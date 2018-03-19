<p>
	<s:if test="message.receiverId != null">à: <s:property value="otherName" />
	</s:if>
	<s:else>de: <s:if test="otherName == null">#SYSTEM#</s:if>
		<s:property value="otherName" />
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

<textarea class="hundWid viewMessageArea" rows="20" spellcheck="false" readonly><s:property value="message.content" /></textarea>
