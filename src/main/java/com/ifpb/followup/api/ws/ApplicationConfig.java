package com.ifpb.followup.api.ws;

import com.ifpb.followup.api.resource.ResourceAluno;
import com.ifpb.followup.api.resource.ResourceAvaliacao;
import com.ifpb.followup.api.resource.ResourceProfessor;
import com.ifpb.followup.api.resource.ResourceQuestao;
import com.ifpb.followup.api.resource.ResourceResposta;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * Created by Rodger on Apr 8, 2019 11:28:46 AM
 */
@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(ResourceAluno.class);
        resources.add(ResourceAvaliacao.class);
        resources.add(ResourceProfessor.class);
        resources.add(ResourceQuestao.class);
        resources.add(ResourceResposta.class);      
    }
    
}