package Codificadores;

public class Codifica18103690 implements Codifica {
	//private String tabela = ;

    // Recebe um string e retorna o correspondente codificado
    public String codifica(String str){
		// todo
        return new StringBuilder(str).reverse().toString();
	}

    // Recebe um string codificado e retorna o correspondente decodificado
    public String decodifica(String str){
		// todo
        return new StringBuilder(str).reverse().toString();
	}

	public String getMatriculaAutor(){
		return "18103690";
	}
	public String getNomeAutor(){
		return "Guilherme da Camara Vieira";
	}
}
