import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

import java.util.Iterator;
import java.util.List;

public class FileUpload extends HttpServlet {
    private boolean isMultipart;
    private String filePath;
    private File file ;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("file uploading...");
        try {

            List<FileItem> files = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

            StringBuilder uploadPath = new StringBuilder("D:\\DISKS\\database\\data\\");
            // creates the directory if it does not exist
            filePath = uploadPath.toString();
            File uploadDir = new File(filePath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            for(FileItem item : files)
            {
                String fileName = item.getName();
                long size = item.getSize();
                request.setAttribute("fileName", fileName);
                request.setAttribute("fileSize", size);
                item.write(new File(filePath + fileName));
            }


            System.out.println("file uploaded!!!");

            request.setAttribute("message", "Upload has been done successfully!");

        } catch (FileUploadException e) {
            request.setAttribute("message", "There was an error: " + e.getMessage());
        } catch (Exception e) {
            request.setAttribute("message", "There was an error: " + e.getMessage());
        }
        getServletContext().getRequestDispatcher("/jsp/message.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
