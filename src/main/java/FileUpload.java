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
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file ;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("file uploading...");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload sf = new ServletFileUpload(factory);
        try {
            String uploadPath = getServletContext().getRealPath("")
                    + File.separator + "C:\\apache-tomcat-9.0.37\\webapps\\data\\";
            // creates the directory if it does not exist
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            List<FileItem> files = sf.parseRequest(request);
            String names = "";
            /*for(FileItem item : files)
            {
                item.write(new File("D:\\JAVA\\3week3\\" + item.getName()));
                names += item.getName() + " ";

            }*/
            Iterator iter = files.iterator();


            // iterates over form's fields
            while (iter.hasNext()) {
                FileItem fi = (FileItem)iter.next();
                if ( !fi.isFormField () ) {
                    // Get the uploaded file parameters
                    String fieldName = fi.getFieldName();
                    String fileName = fi.getName();
                    String contentType = fi.getContentType();
                    boolean isInMemory = fi.isInMemory();
                    long sizeInBytes = fi.getSize();
                    request.setAttribute("fileName", fileName);
                    request.setAttribute("fileSize", sizeInBytes);

                    // Write the file
                    if( fileName.lastIndexOf("\\") >= 0 ) {
                        file = new File( filePath + fileName.substring( fileName.lastIndexOf("\\"))) ;
                    } else {
                        file = new File( filePath + fileName.substring(fileName.lastIndexOf("\\") + 1)) ;
                    }
                    fi.write( file ) ;
                    System.out.println("test");
                }
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
