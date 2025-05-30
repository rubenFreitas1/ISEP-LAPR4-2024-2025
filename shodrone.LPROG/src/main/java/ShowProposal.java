import genShowProposal.ShowProposalLexer;
import genShowProposal.ShowProposalParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class ShowProposal {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        ShowProposalLexer lexer = new ShowProposalLexer(CharStreams.fromFileName("filesLPROG/show_proposal_dados_3"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ShowProposalParser parser = new ShowProposalParser(tokens);
        ParseTree tree = parser.proposal();
        System.out.println(tree.toStringTree(parser));
        System.out.println("Done!");
    }
}
