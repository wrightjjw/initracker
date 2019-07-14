package inittracker;

import javax.swing.*;
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
    JTextField nameBox;
    JTextField initBox;
    JTextField acBox;
    InitList inits;
    Object[][] data;

    private App() {
        createMainWindow();
    }

    private void createMainWindow() {
        mainWindow = new JFrame("Initiative Tracker");

        inits = new InitList();
        String[] titles = {"Init", "Name", "AC"};

        JPanel top = new JPanel();
        JPanel mid = new JPanel();
        JPanel bot = new JPanel();

        table = new JTable(initListToObjectArray(inits), titles);
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
            System.out.println("Adding init entry!");
            String name = nameBox.getText();
            int init = Integer.parseInt( initBox.getText() );
            int ac = Integer.parseInt ( acBox.getText() );
            inits.add(new InitBlock(name, init, ac));
            data = initListToObjectArray(inits);
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
}
