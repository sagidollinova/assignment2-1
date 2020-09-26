<%@include file="header.jsp"%>

<div class="container container-fl">
        <h2>${requestScope.message}</h2>

    <p></p>
    <div class="row">
        <div class="col-md-4 border border-warning">
            <h4>File name: ${requestScope.fileName}</h4>

            <h4>File size: ${requestScope.fileSize}</h4>

        </div>
    </div>
</div>

<%@include file="footer.jsp"%>