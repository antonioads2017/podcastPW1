package com.ifpb.control.Listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.File;

public class FileLocationContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //Pegando o caminho da aplicação
        String rootPath = System.getProperty("catalina.home");
        //Pegando o contexto da aplicação
        ServletContext ctx = servletContextEvent.getServletContext();
        //pegando caminho relativo para o diretório de imágens
        String relativePathImg = ctx.getInitParameter("img.dir");
        String relativePathAudio = ctx.getInitParameter("audio.dir");
        File fileImg = new File(rootPath + File.separator + relativePathImg);
        File fileAudio = new File(rootPath + File.separator + relativePathAudio);
        if(!fileImg.exists()){
            fileImg.mkdirs();
        }
        if(!fileAudio.exists()){
            fileAudio.mkdirs();
        }
        System.out.println("Diretorio de arquivos criado para o armazenamento e imagens e audios");
        //Setando no contexto a referencia ao diretório e o caminho para o mesmo
        ctx.setAttribute("IMG_DIR_FILE", fileImg);
        ctx.setAttribute("IMG_DIR", rootPath + File.separator + relativePathImg);
        ctx.setAttribute("AUDIO_DIR_FILE",fileAudio);
        ctx.setAttribute("AUDIO_DIR",rootPath + File.separator + relativePathAudio);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
