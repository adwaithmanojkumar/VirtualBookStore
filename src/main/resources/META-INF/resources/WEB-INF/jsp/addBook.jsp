<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div>
	<div class="container">
		<h1>Enter Book Details</h1>
		<form:form method="post" modelAttribute="book">
			<fieldset class="mb-3">
				<form:label path="bookName">Book Name</form:label>
				<form:input type="text" path="bookName" required="required" />
				<form:errors path="bookName" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="mb-3">
				<form:label path="authorName">Author Name</form:label>
				<form:input type="text" path="authorName" required="required" />
				<form:errors path="authorName" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="publishedDate">Date</form:label>
				<form:input type="text" path="publishedDate" required="required" />
				<form:errors path="publishedDate" cssClass="text-warning" />
			</fieldset>

			<form:input type="hidden" path="id" />
			<input type="submit" class="btn btn-success" />
		</form:form>
	</div>
</div>
<%@include file="common/footer.jspf"%>
<script type="text/javascript">
	$('#date').datepicker({
		format : 'yyyy-mm-dd'
	});
</script>