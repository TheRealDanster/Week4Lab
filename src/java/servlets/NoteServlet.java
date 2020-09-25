package servlets;

import java.lang.String;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author Daniel Tompkins
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        Note note = new Note();
        
        note.setTitle(br.readLine());
        note.setContent(br.readLine());

        request.setAttribute("note", note);
        
        if (request.getParameter("edit") != null) {
         getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        } else {
         getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);   
        }
        
        br.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        
        Note note = new Note();
        note.setTitle(title);
        note.setContent(content);
        
        pw.println(title);
        pw.println(content);
        pw.close();
        
        request.setAttribute("note", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}
