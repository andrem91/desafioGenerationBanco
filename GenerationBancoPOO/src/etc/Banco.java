package etc;

public class Banco {
	
	public static String nome = "G1 GENERATION BRASIL";
	public static String logo = "Buscando um futuro melhor";
	
	public static void mostrarLogo() {
		System.out.println(">>>>>>>>>>" + nome + "<<<<<<<<<<");
		System.out.println("\t"+ logo +"\n\n\n");
	}
	
	public static void despedida() {
		
		System.out.println("Finalizado\nAgradecemos a prefência\nVolte Sempre");
	}
}
