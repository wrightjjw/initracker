package inittracker;

import javax.swing.*;

/**
 * Hello world!
 */
public final class App {
    public static void main(String[] args) {
        App app = new App();
    }

    int SIZE = 20;

    JFrame mainWindow;
    JFrame displayWindow;
    JTable table;
    InitList inits;
    Object[][] data;

    private App() {
        createMainWindow();
    }

    private void createMainWindow() {
        mainWindow = new JFrame();

        inits = new InitList();
        String[] titles = {"Init", "Name", "AC"};
        table = new JTable(initListToObjectArray(inits), titles);
        table.setBounds(SIZE*40, SIZE*20, SIZE*60, SIZE*60);
        mainWindow.add(table);

        mainWindow.setVisible(true);
        mainWindow.setSize(SIZE*100,SIZE*80);
        mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    private void addInitEntry(String name, Integer init, Integer ac) {
        inits.add(new InitBlock(name, init, ac));
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
