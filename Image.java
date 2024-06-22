import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class Image {

    public static void operate(int key)
    {

        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();

        //file FileInputStream
        try
        {

            FileInputStream fis=new FileInputStream(file);

            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        System.out.println("Loading....");

        JFrame f = new JFrame();
        f.setTitle("Image Operation");
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font = new Font("times new roman", Font.BOLD, 15);
        //creating button

        JButton button1 = new JButton("key");
        button1.setFont(font);

        JButton button = new JButton();
        button.setText("encrypt / decrypt Image");
        button.setFont(font);



        //creating text field

        JTextField textField = new JTextField(10);
        textField.setFont(font);


        button.addActionListener(e -> {
            System.out.println("button clicked");
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });

        f.setLayout(new FlowLayout());


        f.add(button1);
        f.add(textField);
        f.add(button);
        f.setVisible(true);
    }}
