import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TP05 {
    private JPanel panel1;
    private JTextField textMaximo;
    private JButton iniciarButton;
    private JButton limparButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JTextField textPrioridade1;
    private JTextField textPrioridade2;

    public TP05(){

        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea1.setText("");
                textArea2.setText("");
            }
        });

        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread t1 = new Thread(run(Integer.parseInt(textMaximo.getText()), 1));
                t1.setPriority(Integer.parseInt(textPrioridade1.getText()));
                t1.start();
                Thread t2 = new Thread(run(Integer.parseInt(textMaximo.getText()), 2));
                t2.setPriority(Integer.parseInt(textPrioridade2.getText()));
                t2.start();

            }
        });
    }
    public static void main(String[] args){
        JFrame frame = new JFrame("TPO5");
        frame.setContentPane(new TP05().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Runnable run(int max, int list) {
        for (int i = 0; i < max; i++) {
            if(list == 1){
                this.textArea1.setText(this.textArea1.getText() + "\n" + i);
            }
            if(list == 2){
                this.textArea2.setText(this.textArea2.getText() + "\n" + i);
            }

        }
        return null;
    }

}
