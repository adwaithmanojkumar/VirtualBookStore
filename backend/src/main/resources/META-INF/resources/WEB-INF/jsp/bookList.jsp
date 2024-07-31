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
				<c:forEach items="${booklist}" var="book">
					<tr>
						<td>${book.bookName}</td>
						<td>${book.authorName}</td>
						<td>${book.publishedDate}</td>
						<td><a href="/add-to-cart/${book.id}"
							class="btn btn-success"><i class="fa-shopping-cart">&#128722;</i></a></td>
						<td><a href="/update-book/${book.id}"
							class="btn btn-warning"><i class="fa-shopping-cart">&#128722;</i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@include file="common/footer.jspf"%>