
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class UnisPOOExercicio3 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calcular IMC");
        frame.setSize(320, 340);

        JPanel panel = new JPanel();

        panel.setLayout(new GridBagLayout());

        JLabel labelWeight = new JLabel("Peso(g): ");
        JLabel labelHeigha = new JLabel("Altura(mm): ");
        JLabel labelIMC = new JLabel("Resultado: ");
        JTextArea labelCalc = new JTextArea("");
        labelCalc.setLineWrap(true);

        labelHeigha.setBounds(50, 40, 100, 20);
        labelWeight.setBounds(50, 80, 100, 20);
        labelIMC.setBounds(50, 160, 100, 20);
        labelCalc.setBounds(50, 190, 200, 60);

        JtextOnlyNumbers textWeinght = new JtextOnlyNumbers();
        JtextOnlyNumbers textHeight = new JtextOnlyNumbers();

        textWeinght.setMaximumCharacter(3);
        textHeight.setMaximumCharacter(3);

        textHeight.setBounds(150, 40, 100, 20);
        textWeinght.setBounds(150, 80, 100, 20);

        JButton calculateButton = new JButton("Calcular");
        calculateButton.setBounds(50, 120, 200, 20);
        calculateButton.addActionListener((ActionEvent e) -> {
            if (textWeinght.getText().isEmpty() || textHeight.getText().isEmpty()) {
                labelCalc.setText("Preencha todos os campos");
            } else {
                labelCalc.setText(calculateIMC(textWeinght.getText(), textHeight.getText()));
            }
            frame.setState(-1);
        });

        frame.add(labelWeight);
        frame.add(labelHeigha);
        frame.add(textWeinght);
        frame.add(textHeight);
        frame.add(calculateButton);
        frame.add(labelIMC);
        frame.add(labelCalc);
        frame.add(panel);
        frame.setVisible(true);

    }

    static public String calculateIMC(String weinght, String height) {
        double intWeinght = Integer.parseInt(weinght);
        double intHeight = 0.01 * Integer.parseInt(height);
        double resultIMC = (intWeinght / (intHeight * intHeight));

        if (resultIMC < 18.5) {
            return "Voce esta abaixo de seu peso. \nSeu IMC e: " + String.format("%.2f", (double) resultIMC);
        } else if (resultIMC >= 18.5 && resultIMC <= 24.9) {
            return "Parabens!!! \nVoce esta no seu peso ideal. \nSeu IMC e: " + String.format("%.2f", (double) resultIMC);
        } else if (resultIMC >= 25.0 && resultIMC <= 29.9) {
            return "Você está acima de seu peso \n(sobrepeso). \nSeu IMC e: " + String.format("%.2f", (double) resultIMC);
        } else if (resultIMC >= 30.0 && resultIMC <= 34.9) {
            return "Você está com Obesidade grau I. \nSeu IMC e: " + String.format("%.2f", (double) resultIMC);
        } else {
            return "Você está com Obesidade grau II \n(severa). \nSeu IMC e: " + String.format("%.2f", (double) resultIMC);
        }

    }

}
