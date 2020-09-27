import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowFiles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File myFolder = new File("D:\\DISKS\\database\\data");
        File[] files = myFolder.listFiles();
        List<String> content = new ArrayList<>();
        for (File f : files)
        {
            String asd = f.getName() + " (" + f.length()/1024 + "KB)";
            content.add(asd);
        }
        request.setAttribute("allFiles", content);
        request.getRequestDispatcher("/jsp/showFiles.jsp").forward(request, response);
    }


}
