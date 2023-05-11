package view;

import model.ParseModel;
import model.TableFormat;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ParsingResultFrame extends JFrame {
    ParseModel parseModel;

    private JTextField isValid;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea parsedQueryTextArea;
    private JTable resultTable;

    public ParsingResultFrame(ParseModel parseModel){
        this.parseModel = parseModel;
        initComponents();
        parsedQueryTextArea.setText(parseModel.getQuery());
        int i = 0;
        DefaultTableModel resultTableModel = (DefaultTableModel) resultTable.getModel();
        for (TableFormat tableFormat : parseModel.getTables()){
            resultTableModel.addRow(new Object[]{"", "", ""});
            resultTable.setValueAt(tableFormat.getText(), i, 0);
            resultTable.setValueAt(tableFormat.getValueLexic(), i, 1);
            resultTable.setValueAt(tableFormat.getTokenLexic(), i, 2);
            i++;
        }
    }

    private void initComponents() {
        jScrollPane2 = new javax.swing.JScrollPane();
        resultTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        parsedQueryTextArea = new javax.swing.JTextArea();
        isValid = new javax.swing.JTextField();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        resultTable.setModel(new DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Text", "Value", "Token"
                }
        ) {
            boolean[] canEdit = new boolean [] {
                    false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(resultTable);

        parsedQueryTextArea.setEditable(false);
        parsedQueryTextArea.setBackground(new Color(241, 240, 240));
        parsedQueryTextArea.setColumns(20);
        parsedQueryTextArea.setRows(5);
        jScrollPane1.setViewportView(parsedQueryTextArea);

        isValid.setEnabled(false);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1)
                                        .addComponent(isValid))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(isValid,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
    }
}
