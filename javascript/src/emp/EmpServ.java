package emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServ
 */
@WebServlet("/EmpServ")//이 페이지의 주소
public class EmpServ extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * Default constructor.
    */
   public EmpServ() {
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
//      response.getWriter().append("Served at: ").append(request.getContextPath());
      PrintWriter out = response.getWriter();
      EmpDAO dao = new EmpDAO();
      List<Employee> list = dao.getEmpList();
      out.println("{\"data\":[");
      int cnt=0;
      for(Employee emp : list) {
    	  out.println("{\"firstName\":\"" + emp.getFirstName() + "\",\"lastName\":\"" + emp.getLastName()
          + "\",\"email\":\"" + emp.getEmail() + "\"}");// 스크립트 출력(\"는 글자 그대로 보이게)
    	  cnt++;
    	  if(list.size() != cnt)
    		  out.println(",");
      }
      out.println("]}");

   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}