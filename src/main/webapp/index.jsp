<%@include file="jsp/header.jsp"%>

<div class="container container-fl">
	<button class="btn btn-info" id="btnn">
		<h2>Tap here to open select form:</h2>
	</button>
	<p></p>

	<div class="row">
		<div class="col-md-4 border border-warning" id="mainform">
			<form action="upload" method="post" enctype="multipart/form-data">
				<div class="form-group"><br>
					<label for="filee"><h3>Select file:</h3></label>
					<hr>
					<input type="file" id="filee">
				</div>
				<hr>
				<button type="submit" class="btn btn-primary" id="submitbtn">Send</button><p></p>
			</form>
		</div>
	</div>
</div>

<%@include file="jsp/footer.jsp"%>