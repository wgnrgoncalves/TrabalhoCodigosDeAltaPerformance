package trabalhocodigosdealtaperformance;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import trabalhocodigosdealtaperformance.PilhaChar.RetornoChar;

/**
 *
 * @author g_o_n
 */
public class SalvaSenha {
	public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String senha_informada, senha_invertida = "";
        int opcao;
        do {

            System.out.println("Informe uma senha");
            senha_informada = teclado.next();
            if (!senha_informada.equals("")) {
                //segunda forma
                PilhaChar p = new PilhaChar();
                p.init();
                RetornoChar r;
                for (int i = 0; i < senha_informada.length(); i++) {
                    if (senha_informada.charAt(i) == '#' || senha_informada.charAt(i) == '_') {
                        r = p.pop();
                        while (r.sucesso) {
                            senha_invertida += r.elem;
                            r = p.pop();
                        }
                        senha_invertida += senha_informada.charAt(i);
                        p.init();
                    } else {
                        p.push(senha_informada.charAt(i));
                    }
                }
                //caso tenha dados na pilha
                r = p.pop();
                while (r.sucesso) {
                    senha_invertida += r.elem;
                    r = p.pop();
                }
                //segunda forma


                /*
                outra solução
                int posicao = 0;                
                for (int i = 0; i < senha_informada.length(); i++) {
                    if (senha_informada.charAt(i) == '#' || senha_informada.charAt(i) == '_') {
                        senha_invertida += inverte(senha_informada.substring(posicao, i)) + senha_informada.charAt(i);
                        posicao = i + 1;
                    }
                }
                if (senha_informada.length() != senha_invertida.length()) {
                    senha_invertida += inverte(senha_informada.substring(posicao));
                }
                 */
                senha_invertida
                        = senha_invertida.replace("a", "@")
                                .replace("s", "$")
                                .replace("r", "*")
                                .replace("e", "&")
                                .replace("i", "!")
                                .replace("o", "(")
                                .replace("u", "+")
                                .toUpperCase();

                System.out.printf("a senha [ %s ] foi cripografada para: [ %s ]\n", senha_informada, senha_invertida);
            } else {
//mensagem ?

            }

            //salvando text
            try {
                String pasta = new java.io.File(".").getCanonicalPath();
                FileWriter arq = new FileWriter(pasta + "\\senha.txt", true);
                PrintWriter gravarArq = new PrintWriter(arq);
                gravarArq.println(senha_invertida);
                arq.close();
            } catch (IOException ex) {
                Logger.getLogger(SalvaSenha.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("Digite:\n 1-Informar informar uma nova senha \n 0-sair\n");
            opcao = teclado.nextInt();
            senha_invertida = "";
            senha_informada = "";

        } while (opcao == 1);

        teclado.close();
    }

    static String inverte(String p) {
        RetornoChar r;
        String retorno = "";
        PilhaChar pilhaChar = new PilhaChar();
        pilhaChar.init();

        for (int i = 0; i < p.length(); i++) {
            pilhaChar.push(p.charAt(i));
        }

        r = pilhaChar.pop();
        while (r.sucesso) {
            retorno += r.elem;
            r = pilhaChar.pop();
        }

        return retorno;
    }
}
