
import com.github.ydewolf.consoleScreen.classes.TreeWidget;
import com.github.ydewolf.consoleScreen.classes.WidgetScreen;
import com.github.ydewolf.consoleScreen.classes.structure.NodeTree;
import com.github.ydewolf.consoleScreen.enums.FillTypes;

public class MainTest {
    public static void main(String[] args) {
        NodeTree tree = new NodeTree();

        String[] mask = {" ", "+", "|", "=", "="};
        WidgetScreen screen = new WidgetScreen(10, 5, mask);
        TreeWidget widget = new TreeWidget(5, 3, FillTypes.BORDER);

        tree.addNode(screen);
        screen.addNode(widget);
        
        screen.mapWidgets();
        System.out.println(screen.getPrintable());
        
    }
}
