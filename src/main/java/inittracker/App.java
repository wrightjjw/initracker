package inittracker;

import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.FlowLayout;
import java.awt.event.*;

/**
 * Create the GUI for the InitTracker app
 */
// TODO: Create display window
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
    ArrayList<JButton> removeButtons = new ArrayList<JButton>();

    JPanel top, mid, bot, topA, topB, topC, topD;

    private App() {
        createMainWindow();
    }

    private void createMainWindow() {
        mainWindow = new JFrame("Initiative Tracker");

        JPanel top = new JPanel();
        JPanel mid = new JPanel();
        JPanel bot = new JPanel();

        topA = new JPanel();
        topA.setLayout(new BoxLayout(topA, BoxLayout.Y_AXIS));
        topB = new JPanel();
        topB.setLayout(new BoxLayout(topB, BoxLayout.Y_AXIS));
        topC = new JPanel();
        topC.setLayout(new BoxLayout(topC, BoxLayout.Y_AXIS));
        topD = new JPanel();
        topD.setLayout(new BoxLayout(topD, BoxLayout.Y_AXIS));

        top.add(topA);
        top.add(topB);
        top.add(topC);
        top.add(topD);

        model = new InitTableModel();
        table = new JTable(model);
        topC.add(table);

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

    /**
     * Action handler
     */
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        // adding table entries
        if (command == "add entry") {
            String name = nameBox.getText();
            int init = Integer.parseInt( initBox.getText() );
            int ac = Integer.parseInt ( acBox.getText() );
            model.data.add(new InitBlock(name, init, ac));
            table.updateUI();
            //TODO: Implement error handling
            //TODO: clear text boxes
            //TODO: activate on enter key

            JButton newButton = new JButton("X");
            removeButtons.add(newButton);
            updateRemoveButtons();
            topD.add(newButton);
        }

        // removing entries
        else if (command.contains("button")) {
            int index = Integer.parseInt( String.valueOf( command.charAt(7) ) );
            System.out.printf("Removing index %d\n", index);
            JButton oldButton = removeButtons.get( index );
            removeButtons.remove(oldButton);
            topD.remove(oldButton);
            updateRemoveButtons();

            model.data.remove(index);
            table.updateUI();
        }

        // Print debug on unrecognized action
        // TODO: make this an exception
        else {
            System.out.println("Action performed, but no command recognized.");
        }
    }
    /**
     * Update the commands on the remove buttons so they remove the proper init entry.
     * Should be run any time the remove button list is updated.
     */
    void updateRemoveButtons() {
        int i = 0;
        removeButtons.forEach((button) -> {
            button.setActionCommand(String.format("button %d", i));
        });
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
    /**
     * Model for the Init table.
     * @author Josh Wright
     */
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
