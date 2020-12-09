import java.util.ArrayList;
import java.util.Random;

public class LogicBot {
    public static void main(String[] args) {
        System.out.println(generateWFF(4));
    }

    public static String[] functions = {"∧", "∨", "¬", "⊻", "⇒", "⇔"};
    public static Integer[] arities = {2, 2, 1, 2, 2, 2};
    public static String[] variables = {"P", "Q", "R"};

    public static String generateWFF(int depth) {
        if (depth == 1)
            return variables[new Random().nextInt(variables.length)];
        else {
            int j = new Random().nextInt(functions.length);
            ArrayList<String> extensions = new ArrayList<>();
            extensions.add(functions[j]);
            for (int i = 0; i < arities[j]; i++) {
                extensions.add(generateWFF(depth - 1));
            }
            return extensions.toString();
        }
    }
}