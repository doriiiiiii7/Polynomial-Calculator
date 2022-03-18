import controller.Controller;
import view.DashboardView;

public class Main {

    public static void main(String[] args) {
        DashboardView frame = new DashboardView();
        Controller controller = new Controller(frame);
        frame.setVisible(true);

    }
}
