package Codificadores;

public class Codifica18103690 implements Codifica {
	private static String tabela = "ã zyxwvutsrqponmlkjihgfe+dcb=a-%@&!(*ç0).$#987654321:úABCDEFGHIJKLMNOPQRSTUVWXYZõâô_<>;{}[]^~/?";
	private static int deslc = 7;

	// Recebe um string e retorna o correspondente codificado
	public String codifica(String str){
		boolean encontrado = false;
		String codificada = "";
		for (char s : str.toCharArray()) {
			encontrado = false;
			for (int i = 0; i < tabela.length(); i++) {
				if (tabela.charAt(i) == s) {
					encontrado = true;
					int pos = Math.floorMod((i+deslc), tabela.length());
					codificada += tabela.charAt(pos);
				}
			}
			if (!encontrado) codificada += s;
		}

		codificada = new StringBuilder(codificada).toString();
		String codificadaReversa = new StringBuilder(codificada).reverse().toString();

		codificada = codificadaReversa.substring(codificada.length()/2) + codificada.substring(codificada.length()/2);
		return codificada;
	}

	// Recebe um string codificado e retorna o correspondente decodificado
	public String decodifica(String str){
		boolean encontrado = false;
		String decodificada = new StringBuilder(str.substring(0, str.length()/2)).reverse().toString();
		decodificada += str.substring(str.length()/2);

		char[] s = decodificada.toCharArray();

		for (int indexSub=0; indexSub<decodificada.length(); indexSub++){
			encontrado = false;
			for (int i = 0; i < tabela.length(); i++) {
				if (tabela.charAt(i) == s[indexSub]) {
					encontrado = true;
					int pos = Math.floorMod((i-deslc), tabela.length());
					s[indexSub] = tabela.charAt(pos);
				}
			}
			if(!encontrado) decodificada += s[indexSub];
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
