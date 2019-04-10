package com.ifpb.followup.api.ws;

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
        resources.add(com.ifpb.followup.api.resource.ResourceAluno.class);
        resources.add(com.ifpb.followup.api.resource.ResourceAuthentication.class);
        resources.add(com.ifpb.followup.api.resource.ResourceAvaliacao.class);
        resources.add(com.ifpb.followup.api.resource.ResourceProfessor.class);
        resources.add(com.ifpb.followup.api.resource.ResourceQuestao.class);
        resources.add(com.ifpb.followup.api.resource.ResourceResposta.class);      
    }
    
}