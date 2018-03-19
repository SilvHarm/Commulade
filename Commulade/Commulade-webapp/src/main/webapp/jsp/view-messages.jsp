<div id="leftView" class="centText">
	<button id="newMessageButton" class="seShaButtons" onclick="getSendMessageForm();">Envoyer un message</button>

	<table class="listView">
		<s:if test="receivedList != null">
			<s:iterator value="receivedList" var="var">
				<tr class="messAge <s:if test="#var.messageRead == false">
							notRead
						</s:if>" data-id="<s:property value="#var.id"/>">
					<th><s:if test="#var.senderId != null">
							<s:property value="usernameMap[#var.senderId]" />
						</s:if> <s:else>
			#SYSTEM#
		</s:else></th>
					<th><s:property value="#var.subject" /></th>
					<th><s:property value="#var.timeStr" /></th>
					<th><s:property value="#var.dateStr" /></th>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr class="centText">
				<th>Aucun message reçu</th>
			</tr>
		</s:else>
	</table>

	<hr class="hundWid">

	<table class="listView">
		<s:if test="sentList != null">
			<s:iterator value="sentList" var="var">
				<tr class="messAge" data-id="<s:property value="#var.id"/>">
					<th><s:property value="usernameMap[#var.receiverId]" /></th>
					<th><s:property value="#var.subject" /></th>
					<th><s:property value="#var.timeStr" /></th>
					<th><s:property value="#var.dateStr" /></th>
				</tr>
			</s:iterator>
		</s:if>
		<s:else>
			<tr class="centText">
				<th>Aucun message envoyé</th>
			</tr>
		</s:else>
	</table>
</div>

<div id="messageDiv"></div>
