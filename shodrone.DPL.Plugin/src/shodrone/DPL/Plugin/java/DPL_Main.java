package shodrone.DPL.Plugin.java;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import eapli.base.droneModelManagement.application.DPLImporter;

import java.io.FileInputStream;
import java.io.InputStream;


public class DPL_Main implements DPLImporter {
    public void importer () throws Exception {
        String filename = "filesLPROG/sample_DPL_model1.txt";
        InputStream input = new FileInputStream(filename);
        final var charStream = CharStreams.fromStream(input);
        final var lexer = new DroneProgramingLanguageLexer(charStream);
        final var tokens = new CommonTokenStream(lexer);
        final var parser = new DroneProgramingLanguageParser(tokens);
        final ParseTree tree = parser.start();

        // TODO handle parsing errors

        // traverse the parsing tree
        final var listener = new DPLListener();
        ParseTreeWalker.DEFAULT.walk(listener, tree);
    }

    public static void main(String[] args) throws Exception {
        String filename = "filesLPROG/sample_DPL_model3.txt";
        InputStream input = new FileInputStream(filename);
        final var charStream = CharStreams.fromStream(input);
        final var lexer = new DroneProgramingLanguageLexer(charStream);
        final var tokens = new CommonTokenStream(lexer);
        final var parser = new DroneProgramingLanguageParser(tokens);
        final ParseTree tree = parser.start();

        // TODO handle parsing errors

        // traverse the parsing tree
        final var listener = new DPLListener();
        ParseTreeWalker.DEFAULT.walk(listener, tree);
        if (listener.isValid()) {
            System.out.println("Programa DPL válido.");
        } else {
            System.err.println("Programa DPL inválido.");
        }
    }

}