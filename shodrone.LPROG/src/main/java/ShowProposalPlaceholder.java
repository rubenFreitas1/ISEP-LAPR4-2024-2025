import genShowProposalPlaceholder.ShowProposalPlaceholderLexer;
import genShowProposalPlaceholder.ShowProposalPlaceholderParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class ShowProposalPlaceholder {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        ShowProposalPlaceholderLexer lexer = new ShowProposalPlaceholderLexer(CharStreams.fromFileName("filesLPROG/show_proposal_PT_V1.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ShowProposalPlaceholderParser parser = new ShowProposalPlaceholderParser(tokens);
        ParseTree tree = parser.proposal();
        System.out.println(tree.toStringTree(parser));
        System.out.println("Done!");
    }
}
