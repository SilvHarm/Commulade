<s:if test="#attr['userId'] != topoOwned.ownerId">
	<s:if test="#attr['userId'] != null">
		<div id="borrowDiv">
			<label>Emprunter du </label><input id="startDate" type="date"> <label> au </label> <input id="endDate" type="date">
			<button id="borrowButton" class="seShaButtons">Emprunter</button>
		</div>
	</s:if>
	<s:else>
		<h1>Vous devez d'abord vous connectez pour pouvoir emprunter un Topo à un autre utilisateur</h1>
	</s:else>

	<table>
		<tbody>
			<s:iterator value="freeLendingList" var="var">
				<tr class="lendItem">
					<td><s:property value="#var[0]" />
					<td>
					<td><s:property value="#var[1]" />
					<td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</s:if>
<s:else>
	<table>
		<tbody>
			<s:iterator value="lendingList" var="var">
				<tr class="lendItem">
					<td><s:property value="usernameMap['#var.borrowerId']" />
					<td>
					<td><s:property value="#var.lendingStart" />
					<td>
					<td><s:property value="#var.lendingEnd" />
					<td>
				</tr>
			</s:iterator>
		</tbody>
	</table>
</s:else>

