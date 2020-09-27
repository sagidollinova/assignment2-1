<%@include file="header.jsp"%>

<div class="container container-fl">
        <h2>${message}</h2>

    <p></p>
    <div class="row">
        <div class="col-md-4 border border-warning">
            <h4>File name: ${fileName}</h4>

            <h4>File size: ${fileSize/1024}</h4>
        </div>
        <a href="http://localhost:8080/3week3_war_exploded/">Main page</a>
    </div>
</div>

<%@include file="footer.jsp"%>