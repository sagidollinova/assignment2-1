import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class Download extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String[] s = request.getParameterValues("files");

        for (String fileName : s)
        {
            fileName = fileName.substring(0, fileName.lastIndexOf("|") - 2);
            File file = new File("D:\\DISKS\\database\\data\\" + fileName);

            if (file.exists()) {
                response.setContentType("application/octet-stream");
                response.setContentLength((int) file.length());

                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

                FileInputStream in = new FileInputStream(file);

                int i;
                while ((i = in.read()) != -1) {
                    out.write(i);
                }
                in.close();
                out.close();
            }
        }

    }
}
