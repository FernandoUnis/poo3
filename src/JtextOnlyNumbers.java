
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public final class JtextOnlyNumbers extends JTextField {

    private int maximumCharacter = -1;

    public JtextOnlyNumbers() {
        super();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
    }

    private void jTextFieldKeyTyped(KeyEvent evt) {

        String caracteres = "0987654321";// lista de caracters que não devem ser aceitos
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            // se o caracter que gerou o   evento estiver não estiver na lista
            evt.consume();//aciona esse propriedade para eliminar a ação do evento
        }
        if ((getText().length() >= getMaximumCharacter()) && (getMaximumCharacter() != -1)) {
            //if para saber se precisa verificar também o tamanho da string do campo
            // maior ou igual ao tamanho máximo, cancela e nao deixa inserir mais
            evt.consume();
            setText(getText().substring(0, getMaximumCharacter()));
            // esta linha acima é para remover os caracters inválidos caso o usuário tenha copiado o 
            //conteúdo de algum lugar, ou seja, com tamanho maior que o definido
        }

    }

    public int getMaximumCharacter() {
        return maximumCharacter;
    }

    public void setMaximumCharacter(int maximumCharacter) {
        this.maximumCharacter = maximumCharacter;
    }
}
