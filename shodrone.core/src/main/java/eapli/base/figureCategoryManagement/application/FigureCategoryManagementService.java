package eapli.base.figureCategoryManagement.application;

import eapli.base.figureCategoryManagement.domain.FigureCategory;
import eapli.base.figureCategoryManagement.repositories.FigureCategoryRepository;
import eapli.framework.time.util.CurrentTimeCalendars;

import java.util.Calendar;
import java.util.Optional;

public class FigureCategoryManagementService {

    private final FigureCategoryRepository figureCategoryRepository;

    public FigureCategoryManagementService(final FigureCategoryRepository figureCategoryRepository) {
        this.figureCategoryRepository = figureCategoryRepository;
    }

    public FigureCategory registerNewFigureCategory(final String name, final String description) {
        if(isFigureCategoryNameUsed(figureCategoryRepository, name)){
            throw new IllegalArgumentException("Figure Category name already in use");
        }
        FigureCategory figureCategory = new FigureCategory(name, description, CurrentTimeCalendars.now());
        return (FigureCategory) this.figureCategoryRepository.save(figureCategory);
    }

    public Optional<FigureCategory> findFigureCategoryById(Long id) {
        return this.figureCategoryRepository.findById(id);
    }

    public Iterable<FigureCategory> findFigureCategoryByName(String name) {
        return this.figureCategoryRepository.findByName(name);
    }

    public Iterable<FigureCategory> findFigureCategoryByDescription(String description) {
        return this.figureCategoryRepository.findByDescription(description);
    }

    public void editFigureCategory(FigureCategory figureCategory, String newName, String newDescription) {
        boolean edited = false;
        if (newName == null || newName.isEmpty()) {
            throw new IllegalArgumentException("Figure Category name cannot be null or empty!");
        } else if (!newName.equals("N")) {
            edited = true;
           if (isFigureCategoryNameUsed(figureCategoryRepository, newName)) {
                throw new IllegalArgumentException("Figure Category name already in use");
            }else {
                figureCategory.changeName(newName);
            }
        }
        if (newDescription == null || newDescription.isEmpty()) {
            throw new IllegalArgumentException("Figure Category description cannot be null or empty!");
        } else if (!newDescription.equals("N")) {
            edited = true;
            figureCategory.changeDescription(newDescription);
        }
        if (edited) {
            figureCategoryRepository.save(figureCategory);
        }
    }


    public Iterable<FigureCategory> findAll() {
        return this.figureCategoryRepository.findAll();
    }

    public FigureCategory deactivateFigureCategory(FigureCategory figureCategory) {
        figureCategory.deactivate(CurrentTimeCalendars.now());
        return (FigureCategory) this.figureCategoryRepository.save(figureCategory);
    }

    public FigureCategory activateFigureCategory(FigureCategory figureCategory) {
        figureCategory.activate(CurrentTimeCalendars.now());
        return (FigureCategory) this.figureCategoryRepository.save(figureCategory);
    }


    public boolean isFigureCategoryNameUsed(FigureCategoryRepository repo, String name) {
        return repo.isFigureCategoryNameUsed(name);
    }

    public Iterable<FigureCategory> findByActive(boolean active) {
        return this.figureCategoryRepository.findByActive(active);
    }

    public void changeStatus (FigureCategory figureCategory, boolean newStatus) {
        if (newStatus) {
            figureCategory.activate(Calendar.getInstance());
        } else {
            figureCategory.deactivate(Calendar.getInstance());
        }
        this.figureCategoryRepository.save(figureCategory);
    }
}
