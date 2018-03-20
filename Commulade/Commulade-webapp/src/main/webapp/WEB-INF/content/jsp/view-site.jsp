<s:if test="site != null">
	<s:set var="site" value="site" />
</s:if>

<s:if test="#site != null">
	<div class="divSeek flexCol hundWid">
		<div id="siteInfos" class="row centText infDiv">

			<s:if test="#site.photoName != null">
				<div class="col-3 flexCol">
					<img class="imgBord resizeImg" alt="Image introuvable"
						src="<s:property value="%{sitePhotoPath}" /><s:property value="#site.photoName" />">
				</div>
			</s:if>
			<s:else>
				<div class="col-3 flexCol imgBord">
					<h2 class="autoMar">Aucune image disponible</h2>
				</div>
			</s:else>

			<div class="col-9">
				<h1 class="hSiteObserver noMar">
					<s:property value="#site.name" />
				</h1>

				<p class="infoTitle">Date à partir de laquelle ces informations sont (censées être) correctes :</p>
				<p>
					<s:property value="#site.date" />
				</p>

				<p class="infoTitle">Emplacement :</p>
				<p>
					<s:property value="#site.place" />
				</p>

				<p class="infoTitle">Indications chemin :</p>
				<p>
					<s:property value="#site.pathIndication" />
				</p>
			</div>

			<s:set var="postId" value="#site.id" />
			<s:set var="postType" value="@fr.silvharm.commulade.model.enu.PostTypeEnum@SITE.type" />
			<s:include value="/WEB-INF/content/jsp/parts/comment-container.jsp" />
		</div>


		<s:iterator value="#site.listSecteur" var="var">
			<hr class="hundWid">

			<div class="centText divSeek">
				<h1 class="hSecObserver noMar">
					<s:property value="#var.name" />
				</h1>

				<s:if test="#var.photoName != null">
					<img class="imgBord imgSecObs" alt="Image introuvable"
						src="<s:property value="%{secteurPhotoPath}" /><s:property value="#var.photoName" />">
				</s:if>
				<s:else>
					<div class="divImgSecteur flexCol imgBord imgSecObs infDiv">
						<h2 class="autoMar">Aucune image disponible</h2>
					</div>
				</s:else>

				<s:set var="postId" value="#var.id" />
				<s:set var="postType" value="@fr.silvharm.commulade.model.enu.PostTypeEnum@SECTEUR.type" />
				<s:include value="/WEB-INF/content/jsp/parts/comment-container.jsp" />


				<s:iterator value="#var.listVoie" var="ver">
					<div class="divSeek">
						<h3 class="hVoieObserver">
							<s:property value="#ver.name" />
						</h3>

						<s:iterator value="#ver.listLongueur" var="vir">
							<p>
								<span class="spanLong">Hauteur: <s:property value="#vir.height" /></span> <span class="spanLong">Nombre de points: <s:property
										value="#vir.nombrePoints" /></span> <span class="spanLong">Cotation: <s:property value="#vir.cotation" />
								</span>
							</p>
						</s:iterator>

						<%-- <s:set var="postId" value="#ver.id" />
						<s:set var="postType" value="@fr.silvharm.commulade.model.enu.PostTypeEnum@VOIE.type" />
						<s:include value="/WEB-INF/content/jsp/parts/comment-container.jsp" /> --%>

					</div>
				</s:iterator>

			</div>
		</s:iterator>

	</div>
</s:if>
<s:else>
	<h1 class="autoMar">Le site demandé n'existe pas</h1>
</s:else>