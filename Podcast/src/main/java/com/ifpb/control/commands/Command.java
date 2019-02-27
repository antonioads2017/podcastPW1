package com.ifpb.control.commands;

import com.ifpb.control.commands.Exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    void execute(HttpServletRequest request,HttpServletResponse response) throws CommandException;

}
