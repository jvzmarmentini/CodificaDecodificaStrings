package Codificadores;


// Codificador e descodificador
public class Codifica20108183 implements Codifica {
    private String tabelaAlfaNumericaOriginal = "AÃBCÇDEÉFGHIJKLMNOPQRSTUVWXYZãabcçdeéfghijklmnopqrstuvwxyz0123456789+/";
    private String tabelaCodificada = "t+ÃéY2pMIç7FBV896ixNwqaÉCWRnUcyHJT/3kd5OrE1gAãbhvzjemDlsGÇPoS40XZQLfuK";

    // Codifica a string de acordo com comparações nas duas tabelas
    // Juntamente com uma variavel de deslocamento baseada no comprimento texto, ou seja, diferente a cada entrada
    public String codifica(String textoACodificar) {
        StringBuilder textoCodificado = new StringBuilder();
        for (int i = 0; i < textoACodificar.length(); i++) {
            char caractereAtual = textoACodificar.charAt(i);
            // Pega o digito na tabela alfa-numérica
            int indiceNaTabelaNumerica = tabelaAlfaNumericaOriginal.indexOf(caractereAtual);
            if (indiceNaTabelaNumerica == -1) {
                // Não encontrado na tabela, apenas copia
                textoCodificado.append(caractereAtual); 
                continue;
            }
            // Calcula o deslocamento na tabela
            int deslocamento = (textoACodificar.length() - 1) * 3;
            // Pega o indice equivalente na outra tabela
            int indiceCodificado = Math.floorMod(indiceNaTabelaNumerica - deslocamento, tabelaCodificada.length());
            char charCodificado = tabelaCodificada.charAt(indiceCodificado);
            textoCodificado.append(charCodificado);
        }
        return textoCodificado.toString();
    }

    public String decodifica(String textoADecodificar) {     
        StringBuilder textoDecodificado = new StringBuilder();
        for (int i = 0; i < textoADecodificar.length(); i++) {
            char caractereAtual = textoADecodificar.charAt(i);
            // Pega o digito na tabela codificada
            int indiceNaTabelaCodificada = tabelaCodificada.indexOf(caractereAtual);
            if (indiceNaTabelaCodificada == -1) {
                // Não encontrado na tabela, apenas copia
                textoDecodificado.append(caractereAtual); 
                continue;
            }
            // Calcula o deslocamento na tabela
            int deslocamento = (textoADecodificar.length() - 1) * 3;
            // Pega o indice equivalente na outra tabela
            int indiceDecodificado = Math.floorMod(indiceNaTabelaCodificada + deslocamento, tabelaAlfaNumericaOriginal.length());
            char charDecodificado = tabelaAlfaNumericaOriginal.charAt(indiceDecodificado);
            textoDecodificado.append(charDecodificado);
        }
        return textoDecodificado.toString();
    }

    public String getNomeAutor() {
        return "João Gabriel Cervo";
    }

    public String getMatriculaAutor() {
        return "20108183";
    }
}
