package eapli.base.figureManagement.application;

import eapli.base.customerManagement.domain.Customer;
import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureManagement.domain.Figure;
import eapli.base.figureManagement.repository.FigureRepository;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
public class FigureManagementService {

    private final FigureRepository figureRepository;

    public FigureManagementService(final FigureRepository figureRepository){
        this.figureRepository = figureRepository;
    }

    public Figure registerNewFigure(String description, Set<String> keywords, FigureCategory figureCategory, boolean exclusive, Customer customer){
        Figure newFigure = new Figure(description, keywords, figureCategory, exclusive, customer);
        return (Figure) this.figureRepository.save(newFigure);
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
}
