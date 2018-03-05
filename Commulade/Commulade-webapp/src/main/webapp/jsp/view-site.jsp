<s:if test="site != null">
	<div class="flexCol hundWid">
		<div id="siteInfos" class="row centText infDiv">

			<s:if test="site.photoName != null">
				<div class="col-3 flexCol">
					<img class="imgBord resizeImg" alt="Image introuvable"
						src="<s:property value="%{sitePhotoPath}" /><s:property value="site.photoName" />">
				</div>
			</s:if>
			<s:else>
				<div class="col-3 flexCol imgBord">
					<h2 class="autoMar">Aucune image disponible</h2>
				</div>
			</s:else>

			<div class="col-9">
				<h1 class="noMar">
					<s:property value="site.name" />
				</h1>

				<p class="infoTitle">Date � partir de laquelle ces informations sont (cens�es �tre) correctes :</p>
				<p>
					<s:property value="site.date" />
				</p>

				<p class="infoTitle">Emplacement :</p>
				<p>
					<s:property value="site.place" />
				</p>

				<p class="infoTitle">Indications chemin :</p>
				<p>
					<s:property value="site.pathIndication" />
				</p>
			</div>
		</div>


		<s:iterator value="site.listSecteur" var="var">
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
					</div>
				</s:iterator>

			</div>
		</s:iterator>

	</div>
</s:if>
<s:else>
	<h1 class="autoMar">Le site demand� n'existe pas</h1>
</s:else>