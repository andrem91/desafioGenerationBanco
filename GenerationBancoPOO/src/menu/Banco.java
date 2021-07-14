package menu;

public class Banco {
	
	public static String nome = "   ___ _    ___ ___ _  _ ___ ___   _ _____ ___ ___  _  _   ___ ___   _   ___ ___ _    \r\n"
			+ "  / __/ |  / __| __| \\| | __| _ \\ /_|_   _|_ _/ _ \\| \\| | | _ | _ \\ /_\\ / __|_ _| |   \r\n"
			+ " | (_ | | | (_ | _|| .` | _||   // _ \\| |  | | (_) | .` | | _ |   // _ \\\\__ \\| || |__ \r\n"
			+ "  \\___|_|  \\___|___|_|\\_|___|_|_/_/ \\_|_| |___\\___/|_|\\_| |___|_|_/_/ \\_|___|___|____|\r\n"
			+ "                                                                                      ";
	public static String slogan = "Buscando um futuro melhor";
	
	public static void mostrarLogo() {
		System.out.println(nome);
		System.out.println("\t\t\t\t"+ slogan +"\n");
	}
	
	public static void despedida() {
		
		System.out.println("Finalizado\nAgradecemos a prefência\nVolte Sempre");
	}
}
