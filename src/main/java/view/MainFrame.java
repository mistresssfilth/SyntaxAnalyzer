package view;

import controller.QueryController;
import model.ParseModel;
import model.ValidationModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame {
    ParseModel parseModel;
    ValidationModel validationModel;

    private JButton clearButton;
    private JTextField isValid;
    private JScrollPane jScrollPane;
    private JButton parseButton;
    private JTextArea queryTextArea;


    public MainFrame(ParseModel parseModel, ValidationModel validationModel){
        this.parseModel = parseModel;
        this.validationModel = validationModel;
        initComponents();
        isValid.setHorizontalAlignment(JTextField.CENTER);
    }

    private void initComponents() {

        jScrollPane = new JScrollPane();
        queryTextArea = new JTextArea();
        parseButton = new JButton();
        clearButton = new JButton();
        isValid = new JTextField();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        queryTextArea.setColumns(20);
        queryTextArea.setRows(5);
        jScrollPane.setViewportView(queryTextArea);

        parseButton.setText("Parse");
        parseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parseButtonAction(e);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearButtonAction(e);
            }
        });

        isValid.setDisabledTextColor(new Color(0,0,0));
        isValid.setEnabled(false);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(isValid)
                                        .addComponent(jScrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(parseButton, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(clearButton, GroupLayout.DEFAULT_SIZE,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane,GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addGap(3,3,3)
                                .addComponent(isValid,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(parseButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(clearButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())

        );

        setSize(new Dimension(416, 358));
        setLocationRelativeTo(null);
    }

    private void parseButtonAction(ActionEvent event){
        parseModel.setQuery(queryTextArea.getText());
        parseModel.startParsing();
        ParsingResultFrame parsingResultFrame = new ParsingResultFrame(parseModel);
        validationModel.setTables(parseModel.getTables());
        validationModel.validation();
        isValid.setText(validationModel.isValid());
        if (validationModel.isValid() == "VALID"){
            QueryController queryController = new QueryController(validationModel);
            queryController.SelectQuery(parseModel.getQuery());
        }
        parsingResultFrame.setDefaultCloseOperation(HIDE_ON_CLOSE);
        parseModel.setTables(new ArrayList<>());
        parsingResultFrame.setVisible(true);
    }
    private void clearButtonAction(ActionEvent event){
        queryTextArea.setText("");
        isValid.setText("");
        parseModel = new ParseModel();
    }
}
