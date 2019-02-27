package com.ifpb.control.servlets;


import com.ifpb.control.commands.Command;
import com.ifpb.control.commands.Exceptions.CommandException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Mailson Dennis
 *
 */

@WebServlet("/inicio")
public class FrontController extends HttpServlet {


    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String commandName = request.getParameter("comando");
        try {
            Command command = (Command) Class.forName(this.getClass().getPackage().getName() + "."+commandName).newInstance();
            command.execute(request, response);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            response.sendError(404);
        } catch (CommandException e) {
            response.sendError(e.getStatuscode(), e.getMessage());
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        service(request,response);
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service(request,response);
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service(request,response);
    }

}
