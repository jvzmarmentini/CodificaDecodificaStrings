package Codificadores;

public class Codifica20101121 implements Codifica {

    @Override
    public String codifica(String str) { //Codifica a string em binário

        String palavra = " ";

        for (int i = 0; i < str.length(); i++) {
            palavra += Integer.toBinaryString(str.charAt(i)); //Utilização do toBinaryString
            palavra += " ";
        }

        return palavra;
    }

    @Override
    public String decodifica(String str) { //Decodifica de binário para string novamente

        String[] palavraBin = str.split(" ");
        String palavra = " ";
        
        for (int i = 0; i < palavraBin.length; i++) {

            int dec = binToDec(palavraBin[i]);  //Utiliza função-extra que foi implementada para transformar de binário para decimal
            char letra = (char) dec;
            palavra += letra;
        }   

        return palavra;
    }
     
    //Criação de uma função extra para correta decodificação
    //Simples função que tranforma binário em deciaml
    public int binToDec (String bin){
        
        int dec = 0;
        int pos = 0;

        for(int i=bin.length()-1; i>=0; i--){

            byte digito = 1;

            if (bin.charAt(i) == '0'){
                digito = 0;
            }

            double mult = Math.pow(2, pos);
            dec += digito * mult;
            pos++;
        }
        return dec;
    }

    @Override
    public String getMatriculaAutor() {
        return "20101221";
    }

    @Override
    public String getNomeAutor() {
        return "Arthur Gil";
    }
}
