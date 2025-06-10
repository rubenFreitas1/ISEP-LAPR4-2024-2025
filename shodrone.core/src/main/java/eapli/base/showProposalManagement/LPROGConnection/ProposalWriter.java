package eapli.base.showProposalManagement.LPROGConnection;


import eapli.base.showProposalManagement.domain.ShowProposal;
import eapli.base.showProposalManagement.domain.Template;
import genShowProposalPlaceholder.ShowProposalPlaceholderLexer;
import genShowProposalPlaceholder.ShowProposalPlaceholderParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;



public class ProposalWriter {

        public String proposalWriter (ShowProposal showProposal, Template template){
            try{
                if (showProposal == null) {
                    System.err.println("ERROR: showProposal is null");
                    return null;
                }
                if (template == null) {
                    System.err.println("ERROR: template is null");
                    return null;
                }
                if (template.content() == null) {
                    System.err.println("ERROR: template.content() is null");
                    return null;
                }
                CharStream input = CharStreams.fromString(template.content());
                ShowProposalPlaceholderLexer lexer = new ShowProposalPlaceholderLexer(input);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                ShowProposalPlaceholderParser parser = new ShowProposalPlaceholderParser(tokens);

                parser.removeErrorListeners();
                parser.addErrorListener(new BaseErrorListener() {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                            int line, int charPositionInLine, String msg,
                                            RecognitionException e) {
                        System.err.println("PARSE ERROR at line " + line + ":" + charPositionInLine + " - " + msg);
                    }
                });
                ParseTree tree = parser.proposal();
                if (tree == null) {
                    System.err.println("ERROR: ParseTree is null");
                    return null;
                }
                ProposalGeneratorVisitor visitor = new ProposalGeneratorVisitor(showProposal);
                String result = visitor.visit(tree);
                return result;
            }catch (Exception e) {
                System.err.println("ERROR in proposalWriter: " + e.getMessage());
                e.printStackTrace();
                return null;
            }

        }


}
