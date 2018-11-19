package com.ifpb.control;

import com.ifpb.model.jdbc.ConnectionException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/inicio")
public class FrontController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = (String) request.getAttribute("command");
        try {
            Command command = (Command) Class.forName(this.getClass().getPackage().getName() + "."+commandName).newInstance();
            command.execute(request, response);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            response.sendError(404);
        } catch (CommandException e) {
            response.sendError(e.getStatuscode(), e.getMessage());
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setAttribute("command","CadastrarUsuario");
        doGet(request,response);
    }
}
