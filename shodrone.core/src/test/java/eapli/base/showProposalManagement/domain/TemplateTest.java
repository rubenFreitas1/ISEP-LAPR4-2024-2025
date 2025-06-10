package eapli.base.showProposalManagement.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemplateTest {

    @Test
    void constructor_shouldCreateTemplateCorrectly() {
        String name = "ProposalTemplate1";
        String content = "Dear {{customer}}, we are pleased to offer you...";

        Template template = new Template(name, content);

        assertEquals(name, template.name());
        assertEquals(content, template.content());
    }

    @Test
    void name_shouldReturnTemplateName() {
        Template template = new Template("Intro", "Hello {{name}}");
        assertEquals("Intro", template.name());
    }

    @Test
    void content_shouldReturnTemplateContent() {
        Template template = new Template("Intro", "Hello {{name}}");
        assertEquals("Hello {{name}}", template.content());
    }

    @Test
    void identity_shouldReturnTemplateId() {
        Template template = new Template("Test", "Some content");
        assertNull(template.identity(), "ID should be null before persistence");
    }

    @Test
    void sameAs_shouldReturnFalseForNow() {
        Template t1 = new Template("T1", "Content");
        Template t2 = new Template("T2", "Different Content");

        assertFalse(t1.sameAs(t2));
    }
}
