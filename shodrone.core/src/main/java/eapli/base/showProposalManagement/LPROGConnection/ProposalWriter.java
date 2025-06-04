package eapli.base.showProposalManagement.LPROGConnection;


import eapli.base.showProposalManagement.domain.ShowProposal;
import genShowProposalPlaceholder.ShowProposalPlaceholderLexer;
import genShowProposalPlaceholder.ShowProposalPlaceholderParser;
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
            ShowProposalPlaceholderLexer lexer = new ShowProposalPlaceholderLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            ShowProposalPlaceholderParser parser = new ShowProposalPlaceholderParser(tokens);
            ParseTree tree = parser.proposal();

            ProposalGeneratorVisitor visitor = new ProposalGeneratorVisitor(showProposal);
            return visitor.visit(tree);
        }


}
