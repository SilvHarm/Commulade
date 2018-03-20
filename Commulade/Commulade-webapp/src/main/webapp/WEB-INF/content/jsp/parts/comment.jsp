<div class="commentContainer">
	<form action="add-comment" method="post">
		<input id="postId" name="commentForm.postId" type="hidden"> <input id="postType" name="commentForm.postType" type="hidden">
		<textarea name="commentForm.comment" cols="96" rows="3" maxlength="256" placeholder="Ecrivez votre commentaire..." spellcheck="false"
			required></textarea>
		<button class="seShaButtons sendComButton">Commenter</button>
	</form>


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
		<p class="siteSeparator">Aucun commentaire n'a encore été posté</p>
	</s:else>
</div>
