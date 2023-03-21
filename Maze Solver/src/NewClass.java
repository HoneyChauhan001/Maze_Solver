import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class NewClass extends JFrame{

    //design grid(maze) for maze solver
    private final int[][] maze =
            {{1,1,1,1,1,1,1,1,1,1,1,1,1},
                    {1,0,1,0,1,0,1,0,0,0,0,0,1},
                    {1,0,1,0,0,0,1,0,1,1,1,0,1},
                    {1,0,1,1,1,1,1,0,0,0,0,0,1},
                    {1,0,0,1,0,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,0,0,1},
                    {1,0,1,0,1,0,0,0,1,1,1,0,1},
                    {1,0,1,0,1,1,1,0,1,0,1,0,1},
                    {1,0,0,0,0,0,0,0,0,0,1,9,1},
                    {1,1,1,1,1,1,1,1,1,1,1,1,1}
            }; // 1->boundary and block 0->space to move 9-> destination point

    public List<Integer> path = new ArrayList<>();//for storing the path

    //constructor
    public NewClass() {
        /*
        this constructor is defined to build UI of the application
         */

        JLabel label1 = new JLabel("<html><font size = '6' >  - - >   BLOCKS </font>");
        label1.setBounds(218,453,500,20);
        label1.setForeground(Color.BLACK);
        this.add(label1);

        JLabel label2 = new JLabel("<html><font size = '6' >  - - >   SPACE TO MOVE </font>");
        label2.setBounds(218,513,500,20);
        label2.setForeground(Color.BLACK);
        this.add(label2);

        JLabel label3 = new JLabel("<html><font size = '6' >  - - >   DESTINATION </font>");
        label3.setBounds(218,573,500,20);
        label3.setForeground(Color.BLACK);
        this.add(label3);

        JLabel label4 = new JLabel("<html><font size = '6' >  - - >   PATH </font>");
        label4.setBounds(218,633,500,20);
        label4.setForeground(Color.BLACK);
        this.add(label4);

        this.setLayout(null);
        this.setTitle("Maze Solver");//setting title of frame
        this.setSize(640,750);//setting size of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//setting default close operation as closing the window
        this.getContentPane().setBackground(Color.WHITE);
        this.setVisible(true);
        DepthFirst.searchPath(maze,1,1,path);//calling searchPath function from depthFirst class which will find the path
        //System.out.print(path);
    }


    @Override
    /*
    overriding paint function of JFrame (parent) class,
    all the designing like setting color of maze, boundaries, structure of maze,
    will be done with the help of Graphics g object
     */

    public void paint(Graphics g){
        super.paint(g);//*** 

        g.translate(60,60);//shifting the origin of object g

        /*
        Below block of code is designing structure of maze using above define maze matrix
         */
        for(int i=0; i< maze.length; i++){
            for(int j=0; j<maze[0].length; j++){
                Color color; //defining color object
                switch (maze[i][j]){
                    case 1: color = Color.black;
                    break;
                    case 9: color = Color.red;
                    break;
                    default: color = Color.GRAY;
                }
                g.setColor(color);//seting color of g
                g.fillRect(40*j,40*i,40,40);//filling rectangle with color(according to gird positions and values)
                g.setColor(Color.RED);
                g.drawRect(40*j,40*i,40,40);//drawing boundary of red color to separate cells
            }
        }


        g.setColor(Color.black);
        g.fillRect(115,30*14,30,30);

        g.setColor(Color.GRAY);
        g.fillRect(115,30*16,30,30);

        g.setColor(Color.RED);
        g.fillRect(115,30*18,30,30);

        g.setColor(Color.GREEN);
        g.fillRect(115,30*20,30,30);

        g.setColor(Color.black);
        g.drawRect(108, 410,310,245);

        /*
        below block of code is designing/filing the path in the maze
         */
        for(int i=0; i<path.size(); i+=2){
            int pathx = path.get(i);//x coordinate
            int pathy = path.get(i+1);//y coordinate

            System.out.println(pathy + " , " + pathx );// printing path in console

            g.setColor(Color.green);
            g.fillRect(40*pathx,40*pathy,30,30);//filling path
            g.setColor(Color.RED);
            g.drawRect(40*pathx,40*pathy,40,40);//drawing boundary of red color to separate cells
        }
    }

    public static void main(String[] args) {
        NewClass view = new NewClass();

    }



}
