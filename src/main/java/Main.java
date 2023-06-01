import model.ParseModel;
import model.ValidationModel;
import view.MainFrame;
import view.ResultSelectFrame;

public class Main {
    public static void main(String[] args) {
        ParseModel parseModel = new ParseModel();
        ValidationModel validationModel = new ValidationModel();

        MainFrame mainFrame = new MainFrame(parseModel,validationModel);
        mainFrame.setVisible(true);


    }
}
