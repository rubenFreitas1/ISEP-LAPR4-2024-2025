package eapli.base.figureManagement.LPOGConnection.plugins;

import genDSL.DroneShowDSLLexer;
import genDSL.DroneShowDSLParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;

public class FigureValidator {

    public static boolean validateFigureRealData(String input){
        DroneShowDSLLexer lexer = new DroneShowDSLLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DroneShowDSLParser parser = new DroneShowDSLParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(ConsoleErrorListener.INSTANCE);

        ParseTree tree = parser.start();

        if(parser.getNumberOfSyntaxErrors() > 0){
            return false;
        }
        return true;
    }
}
