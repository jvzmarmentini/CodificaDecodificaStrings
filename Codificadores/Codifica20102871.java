package Codificadores;

public class Codifica20102871 implements Codifica{
private String Alfabeto_Normal = "abcdefghijklmnopqrstuvwxyz";
private String Novo_Alfabeto = "pqowieurytlaksjdhfgmznxbcv";

    @Override
    public String codifica(String str) {
        String saida = "";
        for(int i = 0; i < str.length(); i++ ){
            int Caracteres = Novo_Alfabeto.indexOf(i);
            if (Caracteres == -1){
                saida += str.charAt(i);
            }
            else
            saida += Alfabeto_Normal.charAt(Caracteres);
        }
        return saida;
    }

    @Override
    public String decodifica(String str) {
        String saida = "";
        for(int i = 0; i < str.length(); i++ ){
            int Caracteres = Alfabeto_Normal.indexOf(i);
            if (Caracteres == -1){
                saida += str.charAt(i);
            }
            else
            saida += Novo_Alfabeto.charAt(Caracteres);
        }
        return saida;
    }

    @Override
    public String getNomeAutor() {
        return "Gabriel Leoncio Verdi";
    }

    @Override
    public String getMatriculaAutor() {
        return "20102871";
    }    
}