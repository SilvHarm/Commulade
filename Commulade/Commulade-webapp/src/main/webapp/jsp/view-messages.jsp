<div>
	<div>
		<s:if test="receivedList != null">
			<s:iterator value="receivedList" var="var"></s:iterator>
		</s:if>
		<s:else>
			<h2>Aucun message re�u</h2>
		</s:else>
	</div>

	<div>
		<s:if test="sentList != null">
			<s:iterator value="sentList" var="var"></s:iterator>
		</s:if>
		<s:else>
			<h2>Aucun message envoy�</h2>
		</s:else>
	</div>
</div>

<div></div>
