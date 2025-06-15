package eapli.base.figureManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.LPOGConnection.plugins.FigureValidator;
import eapli.base.figureManagement.domain.DSL;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.DSLRepository;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.base.pluginManagementService.domain.Plugin;
import eapli.base.pluginManagementService.domain.PluginName;
import eapli.base.pluginManagementService.domain.PluginType;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;

@Component
public class FigureManagementService {

    private final FigureRepository figureRepository;

    private final DSLRepository dslRepository;

    public FigureManagementService(final FigureRepository figureRepository, final DSLRepository dslRepository) {
        this.figureRepository = figureRepository;
        this.dslRepository = dslRepository;
    }

    public Figure registerNewFigure(String description, Set<String> keywords, FigureCategory figureCategory,
                                    boolean exclusive, Customer customer, SystemUser createdBy, String dslPath) {
        try {
            String dslContent = Files.readString(Paths.get(dslPath));
            String[] lines = dslContent.split("\n");
            if(!FigureValidator.validateFigureRealData(dslContent)){
                System.out.println("ERROR: Document Content invalid!");
                throw new IllegalArgumentException("Invalid DSL content in file: " + dslPath);
            }
            String versionLine = lines[0];

            DSL dsl = registerNewDSL(dslPath, versionLine);

            Figure newFigure = new Figure(description, keywords, figureCategory, exclusive, customer, createdBy, dsl, dslContent);
            return this.figureRepository.save(newFigure);

        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Erro ao ler o ficheiro DSL: " + dslPath, e);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }


    private DSL registerNewDSL(String dslPath, String version) {
        Optional<DSL> existingDSL = this.dslRepository.findByFilePath(dslPath);
        if (existingDSL.isPresent()) {
            return existingDSL.get();
        }

        Plugin plugin = new Plugin(new PluginName("dslPlugin"), "Plugin for dsls", PluginType.DSL);
        DSL newDSL = new DSL(dslPath, plugin, version);

        return this.dslRepository.save(newDSL);
    }

    public Figure decommissionFigure(Figure figure){
        figure.deactivate(CurrentTimeCalendars.now());
        return (Figure) this.figureRepository.save(figure);
    }

    public Figure activateFigure(Figure figure){
        figure.activate();
        return (Figure) this.figureRepository.save(figure);
    }

    public Iterable<Figure> activeFigures(){
        return this.figureRepository.findByActive(true);
    }

    public Iterable<Figure> inactiveFigures(){
        return this.figureRepository.findByActive(false);
    }

    public Iterable<Figure> findByCategory(FigureCategory figureCategory){
        return this.figureRepository.findByFigureCategory(figureCategory);
    }

    public Iterable<Figure> findByKeyword(String keyword){
        return this.figureRepository.findByKeyword(keyword);
    }

    public Iterable<Figure> findByExclusivity(boolean exclusive){
        return this.figureRepository.findByExclusivity(exclusive);
    }
    public Iterable<Figure> listPublicFigures(){
        return this.figureRepository.findByExclusivity(false);
    }
    public Iterable<Figure> findByKeywordAndCategory(String keyword, FigureCategory category){
        return this.figureRepository.findByKeywordAndCategory(keyword, category);
    }
    public Iterable<Figure> findByExclusivityAndCustomer(boolean exclusive, Customer customer) {
        return this.figureRepository.findByExclusivityAndCustomer(exclusive, customer);
    }
}
