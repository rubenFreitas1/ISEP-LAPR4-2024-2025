package eapli.base.showProposalManagement.LPROGConnection.plugins;

import genShowProposalPlaceholder.ShowProposalPlaceholderLexer;
import genShowProposalPlaceholder.ShowProposalPlaceholderParser;
import genShowProposalRealData.ShowProposalRealDataLexer;
import genShowProposalRealData.ShowProposalRealDataParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.tree.ParseTree;

public class ShowProposalValidator {

    public static boolean validateShowProposalPlaceholders(String input){
        ShowProposalPlaceholderLexer lexer = new ShowProposalPlaceholderLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ShowProposalPlaceholderParser parser = new ShowProposalPlaceholderParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(ConsoleErrorListener.INSTANCE);

        ParseTree tree = parser.proposal();

        if(parser.getNumberOfSyntaxErrors() > 0){
            return false;
        }
        return true;
    }


    public boolean validateShowProposalRealData(String input){
        ShowProposalRealDataLexer lexer = new ShowProposalRealDataLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ShowProposalRealDataParser parser = new ShowProposalRealDataParser(tokens);

        parser.removeErrorListeners();
        parser.addErrorListener(ConsoleErrorListener.INSTANCE);

        ParseTree tree = parser.proposal();

        if(parser.getNumberOfSyntaxErrors() > 0){
            return false;
        }
        return true;
    }

}
