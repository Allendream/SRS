package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Professor;
import service.PersonService;
import service.UserService;

/**
 * Servlet implementation class addProfessorServlet
 */
@WebServlet("/addProfessorServlet")
public class addProfessorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProfessorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = response.getWriter();
		 String ssn="";
         String name="";
         String title="";
         String department="";
         
         if(!request.getParameter("ssn").equals("")){
        	 ssn=request.getParameter("ssn");
         }
         if(!request.getParameter("name").equals("")){
        	 name=request.getParameter("name");
         }
         if(!request.getParameter("title").equals("")){
        	 title=request.getParameter("title");
         }
         if(!request.getParameter("department").equals("")){
        	 department=request.getParameter("department");
         }
         Professor professor=new Professor();
         professor.setSsn(ssn);
         professor.setName(name);
         professor.setTitle(title);
         professor.setDepartment(department);
         System.out.println("ssn:"+ssn+"  "+"name:"+"  "+name+"title:"+"  "+title+"department:"+"  "+department);
         
         PersonService personService=new PersonService();
         try {
			if(personService.addProfessor(professor)){
				pw.println("新增成功");
			}
			else{
				pw.println("新增失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
		
	}

}
