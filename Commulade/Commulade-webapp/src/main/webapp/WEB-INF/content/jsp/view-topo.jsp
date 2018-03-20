<s:if test="topo != null">
	<div class="centText hundWid">

		<s:if test="#attr['username'] != null">
			<p id="powning" class="sharing">
				<s:if test="isOwned">
					<s:include value="/WEB-INF/content/jsp/parts/own-it-topo.jsp"></s:include>
				</s:if>
				<s:else>
					<s:include value="/WEB-INF/content/jsp/parts/dont-own-it-topo.jsp"></s:include>
				</s:else>
			</p>
		</s:if>

		<div>
			<h1 class="noMar">
				<s:property value="topo.name" />
			</h1>

			<p class="infoTitle">Date à partir de laquelle ces informations sont (censées être) correctes :</p>
			<p>
				<s:property value="topo.editionDate" />
			</p>

			<s:if test="isUpToDate == false">
				<p id="warning">ATTENTION: les informations concernant un ou plusieurs site(s) sont marquées comme plus récentes que la date
					d'édition du topo, il se peut donc que la version physique de celui ci ne corresponde pas à celle que nous vous fournissons !</p>
			</s:if>

			<p>
				<s:property value="topo.description" />
			</p>

			<s:set var="postId" value="topo.id" />
			<s:set var="typeId" value="@fr.silvharm.commulade.model.enu.PostTypeEnum@TOPO.type" />
			<s:include value="/WEB-INF/content/jsp/parts/comment-container.jsp" />
		</div>


		<s:iterator value="topo.listSite" var="site">
			<hr class="hundWid siteSeparator">
			<hr class="hundWid siteSeparator">

			<s:include value="/WEB-INF/content/jsp/view-site.jsp"></s:include>
		</s:iterator>
	</div>
</s:if>
<s:else>
	<h1 class="autoMar">Le topo demandé n'existe pas</h1>
</s:else>

