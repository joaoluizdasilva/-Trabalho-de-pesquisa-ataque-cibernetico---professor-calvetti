import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RsaCryptographyExample {
    public static void main(String[] args) {
        try {
            // Mensagem a ser cifrada
            String mensagem = "Sua mensagem aqui";
            byte[] bMsgClara = mensagem.getBytes(StandardCharsets.ISO_8859_1);

            // Imprime mensagem de início
            System.out.println(">>> Cifrando com o algoritmo RSA...");
            System.out.println("");

            // Instancia um objeto da classe CryptoRSA
            CryptoRSA crsa = new CryptoRSA();

            // Gera as chaves criptográficas RSA (pública e privada) e os arquivos onde armazená-las
            crsa.geraParDeChaves(new File("chave.publica"), new File("chave.privada"));

            // Gera a cifra RSA da mensagem dada, usando a chave pública gerada
            crsa.geraCifra(bMsgClara, new File("chave.publica"));

            // Recebe o texto cifrado
            byte[] bMsgCifrada = crsa.getTextoCifrado();

            // Converte o texto byte[] no equivalente em string
            String sMsgCifrada = new String(bMsgCifrada, StandardCharsets.ISO_8859_1);

            // Imprime o cabeçalho da mensagem cifrada
            System.out.println("Mensagem Cifrada (hexadecimal):");
            System.out.println(prn.hexBytesToString(bMsgCifrada));
            System.out.println("");

            // Imprime o cabeçalho da mensagem cifrada como string
            System.out.println("Mensagem Cifrada (string):");
            System.out.println(sMsgCifrada);
            System.out.println("");

            // Imprime mensagem de início de decifragem
            System.out.println(">>> Decifrando com o algoritmo RSA...");
            System.out.println("");

            // Gera a decifra RSA da mensagem cifrada, usando a chave privada gerada
            crsa.geraDecifra(bMsgCifrada, new File("chave.privada"));

            // Recebe o texto decifrado
            byte[] bMsgDecifrada = crsa.getTextoDecifrado();

            // Converte o texto byte[] no equivalente em string
            String sMsgDecifrada = new String(bMsgDecifrada, StandardCharsets.ISO_8859_1);

            // Imprime o cabeçalho da mensagem decifrada
            System.out.println("Mensagem Decifrada (hexadecimal):");
            System.out.println(prn.hexBytesToString(bMsgDecifrada));
            System.out.println("");

            // Imprime o cabeçalho da mensagem decifrada como string
            System.out.println("Mensagem Decifrada (string):");
            System.out.println(sMsgDecifrada);
            System.out.println("");

        } catch (IOException e) {
            System.err.println("Erro ao acessar arquivos: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro durante o processo de criptografia: " + e.getMessage());
        }
    }
}
