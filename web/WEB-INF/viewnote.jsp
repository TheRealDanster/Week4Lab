<%-- 
    Document   : viewnote
    Created on : 24-Sep-2020, 6:20:11 PM
    Author     : cprg352
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note Viewer</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        Title: ${note.getTitle()}
        <br><br>
        Contents:<br>${note.getContent()}
        <br><br>
        <a href="note?edit">Edit</a>
    </body>
</html>
