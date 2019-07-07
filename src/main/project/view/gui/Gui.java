package main.project.view.gui;

import main.project.five.view.Desktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends JFrame {
    private ImageIcon map;				//棋盘背景位图
    private ImageIcon blackchess;		//黑子位图
    private ImageIcon whitechess;		//白子位图
    private Desktop desktop;
    private Rectangle rectangle;
    private String title;

    private JPanel east;
    private JPanel west;

    private JMenuBar menubar;
    private JMenu[] menu={new JMenu("棋类"),new JMenu("设置"),new JMenu("帮助")};

    private JMenuItem[] menuItemChess={new JMenuItem("五子棋")};
    private JMenuItem[] menuItemSet={new JMenuItem("重新开始")};
    private JMenuItem[] menuItemHelp={new JMenuItem("规则"),new JMenuItem("关于")};

    private MenuItemClicked menuItemClicked = new MenuItemClicked();

    public Gui(){
        title = "Five";
        rectangle = new Rectangle(400, 200, 450, 500);
        setTitle(title);
        setBounds(rectangle);
        setResizable(false);
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void init() {
        // map=new ImageIcon(getClass().getResource("resource\\bg.jpg"));
        // blackchess=new ImageIcon(getClass().getResource("resource\\blackchess.gif"));
        // whitechess=new ImageIcon(getClass().getResource("resource\\whitechess.gif"));


        menubar=new JMenuBar();
        menuItemChess[0].setActionCommand("Five");
        for(int i=0; i<menuItemChess.length; i++) {
            menu[0].add(menuItemChess[i]);
            menuItemChess[i].addActionListener(menuItemClicked);
        }

        menuItemSet[0].setActionCommand("Restart");
        for(int i=0; i<menuItemSet.length; i++) {
            menu[1].add(menuItemSet[i]);
            menuItemSet[i].addActionListener(menuItemClicked);
        }

        menuItemHelp[0].setActionCommand("Rule");
        menuItemHelp[1].setActionCommand("About");
        for(int i=0; i<menuItemHelp.length; i++) {
            menu[2].add(menuItemHelp[i]);
            menuItemHelp[i].addActionListener(menuItemClicked);
        }

        for (int i=0; i<menu.length; i++) {
            menubar.add(menu[i]);
        }
        setJMenuBar(menubar);

        Container container = getContentPane();

        desktop =new Desktop();
        east = new JPanel();
        west = new JPanel();
        container.add(east, "East");
        container.add(west, "West");
        container.add(desktop, "Center");
    }

    class MenuItemClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem target = (JMenuItem)e.getSource();
            String actionCommand = target.getActionCommand();
            if(actionCommand.equals("Five")) {

            } else if(actionCommand.equals("Restart")) {

            } else if(actionCommand.equals("Rule")) {
                JOptionPane.showConfirmDialog(null,
                        "五子棋"
                        ,"规则",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);

            } else if(actionCommand.equals("About")) {
                JOptionPane.showConfirmDialog(null,
                        "Author:Ponecrazy<394129161@163.com>\n" +
                                 "Github:https://github.com/394129161/Chess\n"
                        ,"关于",JOptionPane.CLOSED_OPTION,JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

}
