<div class="commentContainer">

	<s:if test="beanList != null">
		<s:iterator value="beanList" var="comment">
			<div class="comment">
				de <b><s:if test="#comment.username != null">
						<s:property value="#comment.username" />
					</s:if> <s:else>#Visiteur#</s:else></b> , le
				<s:property value="#comment.date" />
				à
				<s:property value="#comment.time" />
				<p>
					<s:property value="#comment.comment" />
				</p>
			</div>
		</s:iterator>
	</s:if>

	<s:else>
		<p>Aucun commentaire n'a encore été posté</p>
	</s:else>
</div>
