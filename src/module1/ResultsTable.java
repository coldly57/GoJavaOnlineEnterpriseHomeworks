package module1;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResultsTable extends JFrame {

    JTable resultsTable;
    JButton saveButton;

    int elements10k = 10000;
    int elements100k = 100000;
    int elements1000k = 1000000;

    int listTestValue = 5000;

    String[] columnNames = {" ", "add", "get", "remove", "contains", "populate", "iterator.add", "iterator.remove"};
    Object[][] tableData = new Object[12][8];

    public ResultsTable() {
        super("Collections comparison");
        fillTable();
        resultsTable = new JTable(tableData, columnNames);
        JScrollPane js = new JScrollPane(resultsTable);
        js.setBounds(0, 0, 700, 400);

        saveButton = new JButton("Save values to file");
        saveButton.setBounds(123, 300, 250, 30);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File("C:\\Coldly\\Java\\GoIT\\Files\\Text.xls");
                    if (!file.exists()) {
                        file.createNewFile();
                    }

                    FileWriter excel = new FileWriter(file.getAbsoluteFile());
                    TableModel model = resultsTable.getModel();

                    for (int i = 0; i < model.getColumnCount(); i++) {
                        excel.write(model.getColumnName(i) + "\t");
                    }

                    excel.write("\n");

                    for (int i = 0; i < resultsTable.getRowCount(); i++) {
                        for (int j = 0; j < resultsTable.getColumnCount(); j++) {
                            excel.write(model.getValueAt(i, j) + "\t");
                        }
                        excel.write("\n");
                    }
                    excel.close();

                    JOptionPane.showMessageDialog(null, "Data Exported");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(saveButton);
        add(js);
        setLayout(null);
        setSize(500, 500);
        getContentPane().setBackground(Color.decode("#bdb76b"));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void fillTable(){

        tableData[0][0] = "ArrayList10k";
        tableData[1][0] = "ArrayList100k";
        tableData[2][0] = "ArrayList1000k";

        tableData[3][0] = "LinkedList10k";
        tableData[4][0] = "LinkedList100k";
        tableData[5][0] = "LinkedList1000k";

        tableData[6][0] = "HashSet10k";
        tableData[7][0] = "HashSet100k";
        tableData[8][0] = "HashSet1000k";

        tableData[9][0] = "TreeSet10k";
        tableData[10][0] = "TreeSet100k";
        tableData[11][0] = "TreeSet1000k";

        addArrayListResultsToTable();
        addLinkedListResultsToTable();
        addHashSetResultsToTable();
        addTreeSetResultsToTable();
    }

    private void addArrayListResultsToTable(){
        ArrayListTest arrayList10k = new ArrayListTest(elements10k);
        ArrayListTest arrayList100k = new ArrayListTest(elements100k);
        ArrayListTest arrayList1000k = new ArrayListTest(elements1000k);

        tableData[0][1] = String.format("%.3f", arrayList10k.testAdd(listTestValue));
        tableData[0][2] = String.format("%.3f", arrayList10k.testGet(listTestValue));
        tableData[0][3] = String.format("%.3f", arrayList10k.testRemove(listTestValue));
        tableData[0][4] = String.format("%.3f", arrayList10k.testContains(listTestValue));
        tableData[0][5] = String.format("%.3f", arrayList10k.testPopulate(elements10k));
        tableData[0][6] = String.format("%.3f", arrayList10k.testIteratorAdd());
        tableData[0][7] = String.format("%.3f", arrayList10k.testIteratorRemove());

        tableData[1][1] = String.format("%.3f", arrayList100k.testAdd(listTestValue));
        tableData[1][2] = String.format("%.3f", arrayList100k.testGet(listTestValue));
        tableData[1][3] = String.format("%.3f", arrayList100k.testRemove(listTestValue));
        tableData[1][4] = String.format("%.3f", arrayList100k.testContains(listTestValue));
        tableData[1][5] = String.format("%.3f", arrayList100k.testPopulate(elements100k));
        tableData[1][6] = String.format("%.3f", arrayList100k.testIteratorAdd());
        tableData[1][7] = String.format("%.3f", arrayList100k.testIteratorRemove());

        tableData[2][1] = String.format("%.3f", arrayList1000k.testAdd(listTestValue));
        tableData[2][2] = String.format("%.3f", arrayList1000k.testGet(listTestValue));
        tableData[2][3] = String.format("%.3f", arrayList1000k.testRemove(listTestValue));
        tableData[2][4] = String.format("%.3f", arrayList1000k.testContains(listTestValue));
        tableData[2][5] = String.format("%.3f", arrayList1000k.testPopulate(elements1000k));
        tableData[2][6] = String.format("%.3f", arrayList1000k.testIteratorAdd());
        tableData[2][7] = String.format("%.3f", arrayList1000k.testIteratorRemove());
    }

    private void addLinkedListResultsToTable(){
        LinkedListTest linkedListTest10k = new LinkedListTest(elements10k);
        LinkedListTest linkedListTest100k = new LinkedListTest(elements100k);
        LinkedListTest linkedListTest1000k = new LinkedListTest(elements1000k);

        tableData[3][1] = String.format("%.3f", linkedListTest10k.testAdd(listTestValue));
        tableData[3][2] = String.format("%.3f", linkedListTest10k.testGet(listTestValue));
        tableData[3][3] = String.format("%.3f", linkedListTest10k.testRemove(listTestValue));
        tableData[3][4] = String.format("%.3f", linkedListTest10k.testContains(listTestValue));
        tableData[3][5] = String.format("%.3f", linkedListTest10k.testPopulate(elements10k));
        tableData[3][6] = String.format("%.3f", linkedListTest10k.testIteratorAdd());
        tableData[3][7] = String.format("%.3f", linkedListTest10k.testIteratorRemove());

        tableData[4][1] = String.format("%.3f", linkedListTest100k.testAdd(listTestValue));
        tableData[4][2] = String.format("%.3f", linkedListTest100k.testGet(listTestValue));
        tableData[4][3] = String.format("%.3f", linkedListTest100k.testRemove(listTestValue));
        tableData[4][4] = String.format("%.3f", linkedListTest100k.testContains(listTestValue));
        tableData[4][5] = String.format("%.3f", linkedListTest100k.testPopulate(elements100k));
        tableData[4][6] = String.format("%.3f", linkedListTest100k.testIteratorAdd());
        tableData[4][7] = String.format("%.3f", linkedListTest100k.testIteratorRemove());

        tableData[5][1] = String.format("%.3f", linkedListTest1000k.testAdd(listTestValue));
        tableData[5][2] = String.format("%.3f", linkedListTest1000k.testGet(listTestValue));
        tableData[5][3] = String.format("%.3f", linkedListTest1000k.testRemove(listTestValue));
        tableData[5][4] = String.format("%.3f", linkedListTest1000k.testContains(listTestValue));
        tableData[5][5] = String.format("%.3f", linkedListTest1000k.testPopulate(elements1000k));
        tableData[5][6] = String.format("%.3f", linkedListTest1000k.testIteratorAdd());
        tableData[5][7] = String.format("%.3f", linkedListTest1000k.testIteratorRemove());
    }

    private void addHashSetResultsToTable(){
        HashSetTest hashSetTest10k = new HashSetTest(elements10k);
        HashSetTest hashSetTest100k = new HashSetTest(elements100k);
        HashSetTest hashSetTest1000k = new HashSetTest(elements1000k);

        tableData[6][1] = String.format("%.3f", hashSetTest10k.testAdd(1000005));
        tableData[6][2] = "N/A";
        tableData[6][3] = String.format("%.3f", hashSetTest10k.testRemove(100));
        tableData[6][4] = String.format("%.3f", hashSetTest10k.testContains(100));
        tableData[6][5] = String.format("%.3f", hashSetTest10k.testPopulate(elements10k));
        tableData[6][6] = "N/A";
        tableData[6][7] = "N/A";

        tableData[7][1] = String.format("%.3f", hashSetTest100k.testAdd(1000005));
        tableData[7][2] = "N/A";
        tableData[7][3] = String.format("%.3f", hashSetTest100k.testRemove(100));
        tableData[7][4] = String.format("%.3f", hashSetTest100k.testContains(100));
        tableData[7][5] = String.format("%.3f", hashSetTest100k.testPopulate(elements10k));
        tableData[7][6] = "N/A";
        tableData[7][7] = "N/A";

        tableData[8][1] = String.format("%.3f", hashSetTest1000k.testAdd(1000005));
        tableData[8][2] = "N/A";
        tableData[8][3] = String.format("%.3f", hashSetTest1000k.testRemove(100));
        tableData[8][4] = String.format("%.3f", hashSetTest1000k.testContains(100));
        tableData[8][5] = String.format("%.3f", hashSetTest1000k.testPopulate(elements10k));
        tableData[8][6] = "N/A";
        tableData[8][7] = "N/A";
    }

    private void addTreeSetResultsToTable(){
        TreeSetTest treeSetTest10k = new TreeSetTest(elements10k);
        TreeSetTest treeSetTest100k = new TreeSetTest(elements100k);
        TreeSetTest treeSetTest1000k = new TreeSetTest(elements1000k);

        tableData[9][1] = String.format("%.3f", treeSetTest10k.testAdd(1000005));
        tableData[9][2] = "N/A";
        tableData[9][3] = String.format("%.3f", treeSetTest10k.testRemove(100));
        tableData[9][4] = String.format("%.3f", treeSetTest10k.testContains(100));
        tableData[9][5] = String.format("%.3f", treeSetTest10k.testPopulate(elements10k));
        tableData[9][6] = "N/A";
        tableData[9][7] = "N/A";

        tableData[10][1] = String.format("%.3f", treeSetTest100k.testAdd(1000005));
        tableData[10][2] = "N/A";
        tableData[10][3] = String.format("%.3f", treeSetTest100k.testRemove(100));
        tableData[10][4] = String.format("%.3f", treeSetTest100k.testContains(100));
        tableData[10][5] = String.format("%.3f", treeSetTest100k.testPopulate(elements10k));
        tableData[10][6] = "N/A";
        tableData[10][7] = "N/A";

        tableData[11][1] = String.format("%.3f", treeSetTest1000k.testAdd(1000005));
        tableData[11][2] = "N/A";
        tableData[11][3] = String.format("%.3f", treeSetTest1000k.testRemove(100));
        tableData[11][4] = String.format("%.3f", treeSetTest1000k.testContains(100));
        tableData[11][5] = String.format("%.3f", treeSetTest1000k.testPopulate(elements10k));
        tableData[11][6] = "N/A";
        tableData[11][7] = "N/A";
    }
}
