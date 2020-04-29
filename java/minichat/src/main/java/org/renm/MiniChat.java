import javax.swing.*;

public class MiniChat {
    public static void main(String[] args) {
        JFrame frame = new JFrame("miniChat");
        JLabel lable = new JLabel("lab");
        frame.add(lable);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 700);
        frame.setVisible(true);
    }
}
