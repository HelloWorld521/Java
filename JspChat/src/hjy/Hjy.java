package hjy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hjy
 */
@WebServlet("/Hjy")
public class Hjy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hjy() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		try{
			String filename=request.getParameter("filename");
			String filename2=new String(filename.getBytes("ISO-8859-1"),"utf-8");
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-disposition","attachment;filename="+filename);
			bis=new BufferedInputStream(new FileInputStream(getServletContext().getRealPath("/"+filename2)));
			bos=new BufferedOutputStream(response.getOutputStream());
			byte[] buff=new byte[2048];
			int bytesRead;
			while((bytesRead=bis.read(buff))!=-1){bos.write(buff,0,bytesRead);}
		}catch(Exception e){e.printStackTrace();}
		finally{if(bis!=null){bis.close();}
		
		if(bos!=null){bos.close();}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
