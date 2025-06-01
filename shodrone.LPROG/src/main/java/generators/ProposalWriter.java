package generators;


import eapli.base.showProposalManagement.domain.ShowProposal;
import genShowProposal.ShowProposalLexer;
import genShowProposal.ShowProposalParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ProposalWriter {

        public String proposalWriter (ShowProposal showProposal, String templatePath) throws IOException {
            String template = Files.readString(Paths.get(templatePath));

            CharStream input = CharStreams.fromString(template);
            ShowProposalLexer lexer = new ShowProposalLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ShowProposalParser parser = new ShowProposalParser(tokens);
            ParseTree tree = parser.proposal();

            ProposalGeneratorVisitor visitor = new ProposalGeneratorVisitor(showProposal);
            return visitor.visit(tree);
        }


}
