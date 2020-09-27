import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File myFolder = new File("D:\\DISKS\\database\\data");
        File[] files = myFolder.listFiles();

        String s[] = request.getParameterValues("files");
        int i = 0;
        for (File f : files)
        {
            if(s[i].equals(f.getName()))
            {
                f.delete();
            }
        }
        request.getRequestDispatcher("/jsp/showFiles.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
