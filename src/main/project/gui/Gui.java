package main.project.gui;

import main.project.controller.Player;
import main.project.five.utils.Tools;
import main.project.five.view.ChessResource;
import main.project.five.view.Desktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
/**
 * GUI.
 * 初步实现棋类(五子棋)单窗口GUI。
 * 对于之后的多棋类和不同种类Player的实现需要重新设计构建GUI
 * @author Ponecrazy
 * @version 1.0
 * @since 1.0
 */
public class Gui extends JFrame {
    /** 下棋部分的窗口组件 */
    private Desktop desktop;
    /** GUI窗口的设定 */
    private Rectangle rectangle;
    /** GUI窗口标题 */
    private String title;


    private JPanel east;
    private JPanel west;


    private JMenuBar menubar;
    private JMenu[] menu={new JMenu("棋类"),new JMenu("设置"),new JMenu("帮助")};

    private JMenuItem[] menuItemChess={new JMenuItem("五子棋")};
    private JMenuItem[] menuItemSet={new JMenuItem("重新开始")};
    private JMenuItem[] menuItemHelp={new JMenuItem("规则"),new JMenuItem("关于")};

    private MenuItemClicked menuItemClicked = new MenuItemClicked();

    /**
     * 构建窗口并初始化GUI.
     * @param playerList
     *        玩家列表
     */
    public Gui(ArrayList<Player> playerList){

        title = ChessResource.getInstance().getTitle();// 需要重新构造
        rectangle = new Rectangle(400, 200, 450, 500);
        setTitle(title);
        setBounds(rectangle);
        setResizable(false);
        this.desktop = new Desktop(playerList);
        init();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);


    }

    /**
     * 初始化GUI.
     *
     */
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


        east = new JPanel();
        west = new JPanel();
        container.add(east, "East");
        container.add(west, "West");
        container.add(desktop, "Center");
    }

    /**
     * 菜单项监听.
     * 后期需要重构
     */
    class MenuItemClicked implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem target = (JMenuItem)e.getSource();
            String actionCommand = target.getActionCommand();
            if(actionCommand.equals("Five")) {

            } else if(actionCommand.equals("Restart")) {
                desktop.reset();
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
