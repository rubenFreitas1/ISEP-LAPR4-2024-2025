import genShowProposalRealData.ShowProposalRealDataLexer;
import genShowProposalRealData.ShowProposalRealDataParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;

public class ShowProposalRealData {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        ShowProposalRealDataLexer lexer = new ShowProposalRealDataLexer(CharStreams.fromFileName("filesLPROG/show_proposal_dados_1"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ShowProposalRealDataParser parser = new ShowProposalRealDataParser(tokens);
        ParseTree tree = parser.proposal();
        System.out.println(tree.toStringTree(parser));
        System.out.println("Done!");
    }
}
