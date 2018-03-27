<s:if test="#attr['userId'] != topoOwned.ownerId">
	<div class="centText hundWid">
		<s:if test="#attr['userId'] != null">
			<s:if test="borrowedList != null">
				<h1>Vos Emprunts</h1>
				<table class="autoMar">
					<tbody>
						<s:iterator value="borrowedList" var="var">
							<tr data-lendingId="<s:property value="#var.id" />">
								<td><span class="item"><s:property value="#var.lendingStart" /></span></td>
								<td>au</td>
								<td><span class="item"><s:property value="#var.lendingEnd" /></span></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:if>

			<h1>Souhaitez-vous emprunter ?</h1>
			<div id="borrowDiv">
				<label>Emprunter du </label><input id="startDate" type="date" min="<s:property value="todayPlus" />"
					max="<s:property value="todayPlusMonth" />" autocomplete="off"> <label> au </label> <input id="endDate" type="date"
					autocomplete="off">
				<button id="borrowButton" class="seShaButtons">Emprunter</button>
			</div>
		</s:if>
		<s:else>
			<h1>Vous devez d'abord vous connectez pour pouvoir emprunter un Topo à un autre utilisateur</h1>
		</s:else>

		<h1>Périodes Libres</h1>
		<table class="autoMar">
			<tbody>
				<s:iterator value="freeLendingList" var="var">
					<tr>
						<td class="item"><s:property value="#var[0]" /></td>
						<td>au</td>
						<td class="item"><s:property value="#var[1]" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</s:if>
<s:else>
	<s:if test="lendingList == null">
		<h1 class="autoMar">Personne ne vous a emprunté ce topo récemment ou ne souhaite vous l'emprunter</h1>
	</s:if>
	<s:else>
		<table class="autoMar">
			<tbody>
				<s:iterator value="lendingList" var="var">
					<tr data-lendingId="<s:property value="#var.id" />">
						<td>par <span class="item"><s:property value="usernameMap[#var.borrowerId]" /></span></td>
						<td>du <span class="item"><s:property value="#var.lendingStart" /></span></td>
						<td>au <span class="item"><s:property value="#var.lendingEnd" /></span></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:else>
</s:else>
