//import javafx.embed.swing.JFXPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Peter on 16.03.18.
 */
public class GamePanel extends JPanel implements ActionListener
{
    private final int PANEL_SIZE = 600;     //константа - размер панели
    private final int TANK_SIZE = 20;       //константа - размер танка
    private final int POSITIONS =900;       //общее количество позиций танка

    private int tankX;                      //позиция танка по оси Х
    private int tankY;                      //позиция танк по оси У

    private int[] x = new int[POSITIONS];
    private int[] y = new int[POSITIONS];

    private Image shoot;
    private Image tank;
    private Timer timer ;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;
    private boolean shooting =false;
    static int t;                                                         //  Вспомогательные
    static int k;                                                         //       переменные

    public GamePanel()                                                    //конструктор
    {
    imageLoad();
        startgame();
    }

    public void startgame()                                               //метод - "начать игру"
    {
        timer = new javax.swing.Timer(50,this);
        timer.start();
        createtank();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }

     public void createtank()                                            //метод - "создать танк"
     {
    //    tankX = new Random().nextInt(580);
    //    tankY = new Random().nextInt(580);
         tankX = 290;
         tankY = 580;
     }
    protected void paintComponent(Graphics g)                            //метод отрисовки спрайта
    {
        super.paintComponent(g);
        if (inGame)
        {
            g.drawImage(tank, tankX, tankY, this);
        }

         t = tankX ;
         k = tankY;
        if (shooting)
        {

            for ( int i = t - 10  ; i > 0; i--)
            {

                    g.drawImage(shoot, t + 7, (k - 10) , this);
                try{
                    g.wait(500);}
                catch (Exception e){}
                    k -= 10;


            }
        }
    }


    public void imageLoad()                       //метод - получение картинки из файла
    {
        ImageIcon tan = new ImageIcon("tank.png");
        tank = tan.getImage();
        ImageIcon sh = new ImageIcon("shoot.png");
        shoot = sh.getImage();
    }




    @Override
    public void actionPerformed(ActionEvent e)
    {
       if (shooting == true)
       {
  //      moove();

       }
        repaint();
    }

    public void moove()
    {

        if (left)
        {
            x[0] -= POSITIONS;
        }
        if (right)
        {
            x[0] += POSITIONS;
        }
        if (up)
        {
            y[0] -= POSITIONS;
        }
        if (down)
        {
            y[0] += POSITIONS;
        }
    }
    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
//            if(key == KeyEvent.VK_LEFT && !right){
            if(key == KeyEvent.VK_LEFT ){
//                left = true;
//                up = false;
//                down = false;
                tankX -= 2;
            }
            if(key == KeyEvent.VK_RIGHT ){
//                right = true;
//                up = false;
//                down = false;
                tankX += 2;

            }

            if(key == KeyEvent.VK_UP ){
//                right = false;
//                up = true;
//                left = false;
                tankY -= 2;
            }
            if(key == KeyEvent.VK_DOWN ){
//                right = false;
//                down = true;
//                left = false;
                tankY += 2;
            }
            if (key ==KeyEvent.VK_SPACE)
            {
                shooting  = true;
//                g.drawImage(shoot, t + 7, (k - 10) , this);
            }
        }
    }
}
