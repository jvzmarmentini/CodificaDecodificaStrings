package Codificadores;


// Codificador e descodificador
public class Codifica20108183 implements Codifica {
    private String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int deslocamento = 3;

    // Codifica a string de acordo com a Cifra de César
    public String codifica(String textoACodificar) {
        String textoCodificado = "";
        // Transforma em maiusculo para poder comparar com o alfabeto
        String textoEmMaiusculo = textoACodificar.toUpperCase(); 
        for (int i = 0; i < textoEmMaiusculo.length(); i++) {
            char caractereAtual = textoEmMaiusculo.charAt(i);
            if (Character.isDigit(caractereAtual)) {
                // Caso seja um digito, ou seja, 
                //não está no alfabeto, apenas insere
                textoCodificado += caractereAtual;
            } else {
                for (int j = 0; i < alfabeto.length(); j++) {
                    char letraAtual = alfabeto.charAt(j);
                    if (letraAtual == caractereAtual) {
                        // Pega a posição voltando tres indices
                        // Utiliza-se o floorMod para não sair do range do alfabeto
                        int posicaoCodificada = Math.floorMod((i - deslocamento), alfabeto.length());
                        textoCodificado += alfabeto.charAt(posicaoCodificada);
                        break;
                    }
                }
            }
        }
        return textoCodificado;
    }

    public String decodifica(String textoADecodificar) {
        String textoDecodificado = "";
        // Transforma em maiusculo para poder comparar com o alfabeto
        String textoEmMaiusculo = textoADecodificar.toUpperCase(); 
        for (int i = 0; i < textoEmMaiusculo.length(); i++) {
            char caractereAtual = textoEmMaiusculo.charAt(i);
            if (Character.isDigit(caractereAtual)) {
                // Caso seja um digito, ou seja, 
                //não está no alfabeto, apenas insere
                textoDecodificado += caractereAtual;
            } else {
                for (int j = 0; i < alfabeto.length(); j++) {
                    char letraAtual = alfabeto.charAt(j);
                    if (letraAtual == caractereAtual) {
                        // Pega a posição avançando tres indices
                        // Utiliza-se o floorMod para não sair do range do alfabeto
                        int posicaoCodificada = Math.floorMod((i + deslocamento), alfabeto.length());
                        textoDecodificado += alfabeto.charAt(posicaoCodificada);
                        break;
                    }
                }
            }
        }
        return textoDecodificado;
    }

    public String getNomeAutor() {
        return "João Gabriel Cervo";
    }

    public String getMatriculaAutor() {
        return "20108183";
    }
}
