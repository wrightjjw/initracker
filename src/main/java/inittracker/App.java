package inittracker;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.*;

/**
 * Hello world!
 */
public final class App implements ActionListener {
    public static void main(String[] args) {
        App app = new App();
    }

    int SIZE = 10;

    JFrame mainWindow;
    JFrame displayWindow;
    JTable table;
    InitTableModel model;
    JTextField nameBox;
    JTextField initBox;
    JTextField acBox;

    private App() {
        createMainWindow();
    }

    private void createMainWindow() {
        mainWindow = new JFrame("Initiative Tracker");

        JPanel top = new JPanel();
        JPanel mid = new JPanel();
        JPanel bot = new JPanel();

        model = new InitTableModel();
        table = new JTable(model);
        mid.add(table);

        JLabel nameLabel = new JLabel("Name:");
        bot.add(nameLabel);

        nameBox = new JTextField(10);
        bot.add(nameBox);

        JLabel initLabel = new JLabel("Init:");
        bot.add(initLabel);

        initBox = new JTextField(2);
        bot.add(initBox);

        JLabel acLabel = new JLabel("AC:");
        bot.add(acLabel);

        acBox = new JTextField(2);
        bot.add(acBox);

        JButton addInitButton = new JButton("Add Entry");
        bot.add(addInitButton);
        addInitButton.setActionCommand("add entry");
        addInitButton.addActionListener(this);


        mainWindow.getContentPane().add("North", top);
        mainWindow.getContentPane().add("Center", mid);
        mainWindow.getContentPane().add("South", bot);
        mainWindow.setVisible(true);
        mainWindow.setSize(SIZE*100,SIZE*80);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command == "add entry") {
            String name = nameBox.getText();
            int init = Integer.parseInt( initBox.getText() );
            int ac = Integer.parseInt ( acBox.getText() );
            model.data.add(new InitBlock(name, init, ac));
            table.updateUI();
            //TODO: Implement error handling
        }
        else {
            System.out.println("Action performed, but no command recognized.");
        }
    }

    static Object[][] initListToObjectArray(InitList il) {
        int s = il.getSize();
        Object[][] o = new Object[s][];
        for (int i = 0; i < s; i++) {
            Object[] array = {il.get(i).init, il.get(i).name, il.get(i).ac};
            o[i] = array;
        }
        return o;
    }
    class InitTableModel extends AbstractTableModel {

        private static final long serialVersionUID = 1L;

        private String[] columnNames = {"Init", "Name", "AC"};
        public InitList data = new InitList();

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public int getRowCount() {
            return data.getSize();
        }

        @Override
        public Object getValueAt(int x, int y) {
            InitBlock it = data.get(x);
            switch (y) {
                case 0: return it.init;
                case 1: return it.name;
                case 2: return it.ac;
                default: throw new IllegalArgumentException("InitTableModel.getValueAt(): invalid y value");
            }
        }
    }
}
