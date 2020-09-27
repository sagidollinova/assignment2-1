<%@ page import="java.io.File" %>
<%@ page import="java.util.List" %>
<%@include file="header.jsp"%>

<div class="container container-fl">

    <p></p>

    <div class="row">
        <div class="col-md-4 border border-warning">
            <form method="post" action="deleteFile">
            <%
                List<String> list = (List<String>) request.getAttribute("allFiles");
                int i = 0;
                for (String ss : list)
                {
                    %>
                    <input type="checkbox" id="<% out.println(i); %>" name="files" >
                    <label for="<% out.println(i); %>"> <% out.println(ss); %> </label><br>
                    <%
                    i++;
                }
            %>
                <button type="submit" class="btn btn-primary" id="submitbtn">Delete</button>
            </form>
        </div>
        <a href="http://localhost:8080/3week3_war_exploded/">Main page</a>
    </div>
</div>

<%@include file="footer.jsp"%>