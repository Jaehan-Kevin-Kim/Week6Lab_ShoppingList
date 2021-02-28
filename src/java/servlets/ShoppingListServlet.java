/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 841898
 */
public class ShoppingListServlet extends HttpServlet {
ArrayList <String> itemList = new ArrayList<>();

     

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        HttpSession session = request.getSession();
         String username = (String) session.getAttribute("username");
         request.setAttribute("username", username);
         System.out.println("username session: " + username);
        
        
     getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request,response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         HttpSession session = request.getSession();
          String usernameFromSession = (String) session.getAttribute("username");
          
          String action = request.getParameter("action");
          session.setAttribute("action", action);
          
          if (action.equals("register")){
//          if (usernameFromSession == null || usernameFromSession.equals("")){
              String username = request.getParameter("username");
              session.setAttribute("username", username);
              request.setAttribute("usernameFromSession", username);
          } else if (action.equals("add")){
              request.setAttribute("username", usernameFromSession);
              String item = request.getParameter("item");
//               itemList = new ArrayList();
               itemList.add(item);
               request.setAttribute("itemList", itemList);

           } else if (action.equals("delete")){
               String selectedItem = request.getParameter("item");
               itemList.remove(selectedItem);
                request.setAttribute("itemList", itemList);
//              request.setAttribute("username", usernameFromSession);
//              String item = request.getParameter("item");
////               itemList = new ArrayList();
//               itemList.add(item);
//               request.setAttribute("itemList", itemList);
         
          }
                     
//               if (item != null || !item.equals("")){
//                   itemList.add(item);
                   
               
          
         
//         System.out.println("username" + username);
         
         
         
         getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request,response);
         
//         System.out.println("action" + action);
         
    }
}



