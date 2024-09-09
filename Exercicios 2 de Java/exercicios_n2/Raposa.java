package exercicios_n2;

public class Raposa implements MenuMetodos{
	private String raça;
	private String habitat;
	private String cor;
	
	Raposa(String raça, String habitat, String cor){
		this.getRaça();
		this.getHabitat();
		this.getCor();
	}
	
	void caçar() {
		System.out.println("A " + raça + "está caçando um coelho");
	}
	
	void correr() {
		System.out.println("A raposa está correndo!");
	}
	
	void comunicar() {
		System.out.println("As raposas se comunicam entre si");
	}

	public String getRaça() {
		return raça;
	}

	public void setRaça(String raça) {
		this.raça = raça;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	@Override
	public void menu() {
		System.out.println("Escolha o metodo a ser testado");
		System.out.println("1 - Mostrar informações");
		System.out.println("2 - Caçar");
		System.out.println("3 - Correr");
		System.out.println("4 - Sair");
	}
}
