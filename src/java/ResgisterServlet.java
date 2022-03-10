
//import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ResgisterServlet"})
public class ResgisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
            
    Registerclass PC = new Registerclass();
    
     out.println("<b>THIS IS YOUR CURRENT LIST OF AVAILABLE PARTICIPANTS</b>"+"<br/>"+"<br>");
        //get a connection to database
        Connection  myconnect = DriverManager.getConnection("jdbc:mysql://localhost:3306/Samuel_Test1", "samuel", "sam123");
        //creating a statement
        Statement mystat = myconnect.createStatement();
        
        //execute SQL query
        ResultSet myRs = mystat.executeQuery("select* from Registration");
        
        //process the result set
          while(myRs.next()){
          out.println(myRs.getString("FistName") +"   |   " + myRs.getString("LastName") +"  |  " + myRs.getString("Gender")+ "   |   "+"\t\t" + myRs.getString("Comments")+"<br>"+"<br>");
          }      
        
        }   
        catch (SQLException ex) {
            Logger.getLogger(ResgisterServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 private static class Registerclass {

        public Registerclass() {
        }

        private Connection getCon() {
            //To change body of generated methods, choose Tools | Templates.
            throw new UnsupportedOperationException("Not supported yet."); 
        }
    }
  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <codeGET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

   

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
/*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
/*
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

*/

                   //String FistName = request.getParameter("FistName");
                   //String LastName = request.getParameter("LastName");
                   //String Comments = request.getParameter("Comments");
  
  // Image = readFromFile("","","");
   // writeToFile(Image);
 // String Photographer_Name = request.getParameter("Photographer_Name");

 //Connection con = PC.getCon();
     //Statement stat = con.createStatement();
   //  stat.executeUpdate("insert into user(Client_Name,Image,Photographer_Name) values('"+Client_Name+"','"+Image+"','"+Photographer_Name+"')");
     //ResultSet myRs = stat.executeQuery("select* from photos");