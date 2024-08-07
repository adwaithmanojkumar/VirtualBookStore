<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Book Name</th>
					<th>Author Name</th>
					<th>Published Date</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
			  <c:forEach items="${cartlist}" var="mycart">
					<tr>
						<td>${mycart.bookName}</td>
						<td>${mycart.authorName}</td>
						<td>${mycart.publishedDate}</td>
						<td><a href="remove-from-cart/${mycart.id}"
						class="btn btn-danger"><i class="gg-trash"></i></a>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@include file="common/footer.jspf"%>