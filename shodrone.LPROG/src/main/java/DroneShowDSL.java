
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import genDSL.DroneShowDSLLexer;
import genDSL.DroneShowDSLParser;
import java.io.IOException;

public class DroneShowDSL {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        DroneShowDSLLexer lexer = new DroneShowDSLLexer(CharStreams.fromFileName("sample_DSL_code_v1a.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        DroneShowDSLParser parser = new DroneShowDSLParser(tokens);
        ParseTree tree = parser.program();
        System.out.println(tree.toStringTree(parser));
        System.out.println("Done!");
    }
}