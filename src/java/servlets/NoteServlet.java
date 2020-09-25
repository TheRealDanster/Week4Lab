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

    Note note = new Note();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
	BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        this.note.setTitle(br.readLine());
        this.note.setContent(br.readLine());
	br.close();

        request.setAttribute("note", note);
        
        if (request.getParameter("edit") != null) {
         getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        } else {
         getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);   
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        this.note.setTitle(request.getParameter("title"));
        this.note.setContent(request.getParameter("content"));
       
        pw.println(this.note.getTitle());
        pw.println(this.note.getContent());
        pw.close();
        
        request.setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }
}
