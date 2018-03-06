<s:if test="topo != null">
	<div class="centText hundWid">
		<div>
			<h1 class="noMar">
				<s:property value="topo.name" />
			</h1>

			<p class="infoTitle">Date � partir de laquelle ces informations sont (cens�es �tre) correctes :</p>
			<p>
				<s:property value="topo.editionDate" />
			</p>

			<s:if test="isUpToDate == false">
				<p id="warning">ATTENTION: les informations concernant un ou plusieurs site(s) sont marqu�es comme plus r�centes que la date
					d'�dition du topo, il se peut donc que la version physique de celui ci ne corresponde pas � celle que nous vous fournissons !</p>
			</s:if>

			<p>
				<s:property value="topo.description" />
			</p>
		</div>


		<s:iterator value="topo.listSite" var="site">
			<hr class="hundWid siteSeparator">
			<hr class="hundWid siteSeparator">

			<s:include value="/jsp/view-site.jsp"></s:include>
		</s:iterator>
	</div>
</s:if>
<s:else>
	<h1 class="autoMar">Le topo demand� n'existe pas</h1>
</s:else>

