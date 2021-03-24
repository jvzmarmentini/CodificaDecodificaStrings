package Codificadores;

public class Codifica18103690 implements Codifica {
    private static String tabela = "ã zyxwvutsrqponmlkjihgfedcba:ç0987654321úABCDEFGHIJKLMNOPQRSTUVWXYZõâõô";
    private static int deslc = 8;

    // Recebe um string e retorna o correspondente codificado
    public String codifica(String str){
        String codificada = "";
		for (char s : str.toCharArray()) {
			for (int i = 0; i < tabela.length(); i++) {
				if (tabela.charAt(i) == s) {
					int pos = Math.floorMod((i+deslc), tabela.length());
					codificada += tabela.charAt(pos);
				}
			}
		}

		codificada = new StringBuilder(codificada).reverse().toString();

        return codificada;
	}

    // Recebe um string codificado e retorna o correspondente decodificado
    public String decodifica(String str){
        String decodificada = new StringBuilder(str).reverse().toString();

		char[] s = decodificada.toCharArray();

		for (int indexSub=0; indexSub<decodificada.length(); indexSub++){
			for (int i = 0; i < tabela.length(); i++) {
				if (tabela.charAt(i) == s[indexSub]) {
					int pos = Math.floorMod((i-deslc), tabela.length());
					s[indexSub] = tabela.charAt(pos);
				}
			}
		}
		decodificada = new String(s);
        return decodificada;
	}

	public String getMatriculaAutor(){
		return "18103690";
	}
	public String getNomeAutor(){
		return "Guilherme da Camara Vieira";
	}
}
