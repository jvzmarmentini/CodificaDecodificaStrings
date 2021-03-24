package Codificadores;


// Codificador e descodificador
public class Codifica20108183 implements Codifica {
    private String tabelaAlfaNumericaOriginal = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789+/";
    private String tabelaCodificada = "ZKw25zCBGDWAGhFYuI782QFgMy*"; 

    // Codifica a string de acordo com a Cifra de César
    public String codifica(String textoACodificar) {
        StringBuilder textoCodificado = new StringBuilder();
        // Transforma em maiusculo para poder comparar com ambos alfabetos
        String textoEmMaiusculo = textoACodificar.toUpperCase(); 
        for (int i = 0; i < textoEmMaiusculo.length(); i++) {
            char caractereAtual = textoEmMaiusculo.charAt(i);
            // Percorre a tabela alfa numerica procurando o digito
            for (int j = 0; i < tabelaAlfaNumericaOriginal.length(); j++) {
                char letraAtual = tabelaAlfaNumericaOriginal.charAt(j);
                if (letraAtual == caractereAtual) {
                    // Pega o indice equivalente na outra tabela
                    // O calculo do indice se baseia na diferença de caracteres em ambas tabelas
                    // multiplicado por uma constante
                    int indiceNaTabelaCodificada = Math.floorMod(((i - 11) * 2), tabelaCodificada.length());
                    char digitoCorrespondente = tabelaCodificada.charAt(indiceNaTabelaCodificada);
                    textoCodificado.append(digitoCorrespondente);
                    break;
                }
            }
        }
        return textoCodificado.toString();
    }

    public String decodifica(String textoADecodificar) {
        StringBuilder textoDecodificado = new StringBuilder();

        return textoDecodificado.toString();
    }

    public String getNomeAutor() {
        return "João Gabriel Cervo";
    }

    public String getMatriculaAutor() {
        return "20108183";
    }
}
