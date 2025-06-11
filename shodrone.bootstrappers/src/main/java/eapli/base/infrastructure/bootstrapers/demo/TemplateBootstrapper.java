package eapli.base.infrastructure.bootstrapers.demo;

import eapli.base.showProposalManagement.application.ConfigureTemplateController;
import eapli.base.showProposalManagement.domain.Template;
import eapli.framework.actions.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemplateBootstrapper implements Action {

    private static final Logger LOGGER = LoggerFactory.getLogger(
            TemplateBootstrapper.class);

    private final ConfigureTemplateController controller = new ConfigureTemplateController();

    @Override
    public boolean execute() {
        addTemplate("temp_eng1", "filesLPROG/show_proposal_EN_V1.txt");
        addTemplate("temp_eng2", "filesLPROG/show_proposal_EN_V2.txt");
        return true;
    }

    private boolean addTemplate(String name,String filepath){
        Template template = null;
        try{
            if(controller.registerTemplate(name, filepath)){
                return true;
            }
        }catch (final Exception e){
            LOGGER.warn("Assuming {} already exists (activate trace log for details)", filepath);
            LOGGER.trace("Assuming existing record", e);
        }
        return false;
    }

}
