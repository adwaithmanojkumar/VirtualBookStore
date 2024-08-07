<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div>
	<div class="container">
		<h1>${(book.id==0)?'Add Book Details':'Update Book Details'}</h1>
		<form:form method="post" modelAttribute="book" >
			<fieldset class="mb-3">
				<form:label path="bookName">Book Name</form:label>
				<form:input type="text" path="bookName" required="required" value="${book.bookName}" />
				<form:errors path="bookName" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="mb-3">
				<form:label path="authorName">Author Name</form:label>
				<form:input type="text" path="authorName" required="required" value="${book.authorName}" />
				<form:errors path="authorName" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="publishedDate">Date</form:label>
				<form:input type="date" path="publishedDate" required="required" value="${book.publishedDate}" />
				<form:errors path="publishedDate" cssClass="text-warning" />
			</fieldset>

			<form:input type="hidden" path="id" />
			<input type="submit" class="btn btn-success" value="${(book.id==0)?'Add':'Update'}"/>
		</form:form>
	</div>
</div>
<%@include file="common/footer.jspf"%>
<script type="text/javascript">
	$('#date').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>