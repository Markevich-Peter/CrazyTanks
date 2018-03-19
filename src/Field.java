import javax.swing.*;

/**
 * Created by Peter on 16.03.18.
 */
public class Field extends JFrame

{
    public Field()
    {
        super("Crazy Tanks");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 650);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        add( new GamePanel());


    }

    public static void main(String[] args)


    {
       Field field = new Field();
    }

}
