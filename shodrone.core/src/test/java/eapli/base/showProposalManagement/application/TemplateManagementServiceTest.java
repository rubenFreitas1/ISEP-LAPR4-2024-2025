package eapli.base.showProposalManagement.application;

import eapli.base.showProposalManagement.domain.Template;
import eapli.base.showProposalManagement.repositories.TemplateRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TemplateManagementServiceTest {

    @Mock
    private TemplateRepository templateRepository;

    @InjectMocks
    private TemplateManagementService service;

    private Template template;
    private String validName;
    private String validContent;

    @BeforeEach
    void setup() {
        validName = "Standard Template";
        validContent = "Dear Customer,\nThis is a template content.\nBest regards,\nTeam";
        template = new Template(validName, validContent);
    }

    @Test
    void createTemplate_success() {
        when(templateRepository.isNameUsed(validName)).thenReturn(false);
        when(templateRepository.isContentUsed(validContent)).thenReturn(false);
        when(templateRepository.save(any(Template.class))).thenReturn(template);

        Template result = service.createTemplate(validName, validContent);

        assertNotNull(result);
        assertEquals(validName, result.name());
        assertEquals(validContent, result.content());

        verify(templateRepository).isNameUsed(validName);
        verify(templateRepository).isContentUsed(validContent);
        verify(templateRepository).save(any(Template.class));
    }

    @Test
    void createTemplate_throwsExceptionWhenNameIsNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.createTemplate(null, validContent)
        );

        assertEquals("Template Name cannot be null or empty", exception.getMessage());
        verify(templateRepository, never()).save(any(Template.class));
    }

    @Test
    void createTemplate_throwsExceptionWhenNameIsEmpty() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.createTemplate("", validContent)
        );

        assertEquals("Template Name cannot be null or empty", exception.getMessage());
        verify(templateRepository, never()).save(any(Template.class));
    }

    @Test
    void createTemplate_throwsExceptionWhenNameIsAlreadyUsed() {
        when(templateRepository.isNameUsed(validName)).thenReturn(true);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.createTemplate(validName, validContent)
        );

        assertEquals("Template Name already in use", exception.getMessage());
        verify(templateRepository).isNameUsed(validName);
        verify(templateRepository, never()).save(any(Template.class));
    }

    @Test
    void createTemplate_throwsExceptionWhenContentIsNull() {
        when(templateRepository.isNameUsed(validName)).thenReturn(false);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.createTemplate(validName, null)
        );

        assertEquals("Template Content cannot be null or empty", exception.getMessage());
        verify(templateRepository).isNameUsed(validName);
        verify(templateRepository, never()).save(any(Template.class));
    }

    @Test
    void createTemplate_throwsExceptionWhenContentIsEmpty() {
        when(templateRepository.isNameUsed(validName)).thenReturn(false);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.createTemplate(validName, "")
        );

        assertEquals("Template Content cannot be null or empty", exception.getMessage());
        verify(templateRepository).isNameUsed(validName);
        verify(templateRepository, never()).save(any(Template.class));
    }

    @Test
    void createTemplate_throwsExceptionWhenContentIsAlreadyUsed() {
        when(templateRepository.isNameUsed(validName)).thenReturn(false);
        when(templateRepository.isContentUsed(validContent)).thenReturn(true);

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> service.createTemplate(validName, validContent)
        );

        assertEquals("Template Content already in use", exception.getMessage());
        verify(templateRepository).isNameUsed(validName);
        verify(templateRepository).isContentUsed(validContent);
        verify(templateRepository, never()).save(any(Template.class));
    }

    @Test
    void listAllTemplates_returnsAllTemplates() {
        Template template2 = new Template("Template 2", "Content 2");
        List<Template> expectedTemplates = List.of(template, template2);
        when(templateRepository.findAll()).thenReturn(expectedTemplates);

        Iterable<Template> result = service.listAllTemplates();

        assertNotNull(result);
        assertEquals(expectedTemplates, result);
        verify(templateRepository).findAll();
    }

    @Test
    void listAllTemplates_returnsEmptyListWhenNoTemplates() {
        List<Template> emptyList = List.of();
        when(templateRepository.findAll()).thenReturn(emptyList);

        Iterable<Template> result = service.listAllTemplates();

        assertNotNull(result);
        assertEquals(emptyList, result);
        verify(templateRepository).findAll();
    }

    @Test
    void isNameUsed_returnsTrueWhenNameExists() {
        when(templateRepository.isNameUsed(validName)).thenReturn(true);

        boolean result = service.isNameUsed(validName);

        assertTrue(result);
        verify(templateRepository).isNameUsed(validName);
    }

    @Test
    void isNameUsed_returnsFalseWhenNameDoesNotExist() {
        when(templateRepository.isNameUsed(validName)).thenReturn(false);

        boolean result = service.isNameUsed(validName);

        assertFalse(result);
        verify(templateRepository).isNameUsed(validName);
    }

    @Test
    void isContentUsed_returnsTrueWhenContentExists() {
        when(templateRepository.isContentUsed(validContent)).thenReturn(true);

        boolean result = service.isContentUsed(validContent);

        assertTrue(result);
        verify(templateRepository).isContentUsed(validContent);
    }

    @Test
    void isContentUsed_returnsFalseWhenContentDoesNotExist() {
        when(templateRepository.isContentUsed(validContent)).thenReturn(false);

        boolean result = service.isContentUsed(validContent);

        assertFalse(result);
        verify(templateRepository).isContentUsed(validContent);
    }
}