import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserHistory {
    private String current = null;
    private final Deque<String> back = new ArrayDeque<>();
    private final Deque<String> forward = new ArrayDeque<>();

    public void visit(String url) {
        if (current != null) back.push(current);
        current = url;
        forward.clear(); // al visitar una nueva página, se invalidan los "adelante"
        System.out.println("Visita: " + current);
    }

    public void back() {
        if (back.isEmpty()) {
            System.out.println("No hay atrás");
            return;
        }
        forward.push(current);
        current = back.pop();
        System.out.println("Atrás -> " + current);
    }

    public void forward() {
        if (forward.isEmpty()) {
            System.out.println("No hay adelante");
            return;
        }
        back.push(current);
        current = forward.pop();
        System.out.println("Adelante -> " + current);
    }

    public void status() {
        System.out.println("Actual: " + current);
        System.out.println("Back stack : " + back);
        System.out.println("Fwd stack  : " + forward);
        System.out.println("-----");
    }

    public static void main(String[] args) {
        BrowserHistory h = new BrowserHistory();
        h.visit("google.com");
        h.visit("openai.com");
        h.visit("docs.oracle.com");
        h.status();

        h.back();     // vuelve a openai.com
        h.back();     // vuelve a google.com
        h.forward();  // adelante a openai.com
        h.visit("stackoverflow.com"); // rompe "adelante"
        h.status();
    }
}
