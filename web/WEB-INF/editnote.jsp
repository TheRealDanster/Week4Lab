<%-- 
    Document   : editnote
    Created on : 24-Sep-2020, 6:20:28 PM
    Author     : cprg352
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note Editor</title>
    </head>
    <body>
        <form method="post" action="note">
            <h1>Simple Not Keeper</h1>
            <h2>View Note</h2>
            Title:<input type="text" name="title" value="${note.getTitle()}">
            <br><br>
            Contents:<br><input type="text" name="content" value="${note.getContent()}">
            <br><br>
            <button>Save</button>
        </form>
    </body>
</html>
