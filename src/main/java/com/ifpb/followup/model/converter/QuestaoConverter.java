package com.ifpb.followup.model.converter;

import com.ifpb.followup.consumer.ConsumerQuestao;
import com.ifpb.followup.model.Questao;
import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Amanda
 */
@FacesConverter(value = "questaoConverter", forClass = Questao.class)
public class QuestaoConverter implements Converter {

    private ConsumerQuestao consumerQuestao;

    public QuestaoConverter() {
        this.consumerQuestao = CDI.current().select(ConsumerQuestao.class).get();
    }
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value == null || value.isEmpty()) {
            return null;
        } else {
            System.out.println("resultado: " + consumerQuestao.buscar(value.toString()));
            return consumerQuestao.buscar(value);

        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Questao q = (Questao) value;
        if (q != null) {
            return String.valueOf(q.getId());
        } else {
            return null;
        }
    }

}
