package exercicios_n2;

public class Navio implements MenuMetodos{
	private String nome;
	private String classe;
	private int anoDeConstrução;
	
	Navio(String nome, String classe, int anoDeConstrução){
		this.setNome(nome);
		this.setClasse(classe);
		this.setAnoDeConstrução(anoDeConstrução);
	}
	
	void virar() {
		System.out.println("Você muda a direção do navio");
	}
	
	void navegar() {
		System.out.println("O navio começa a navegar");
	}
	
	void atirar() {
		System.out.println("Você atira com as armas principais do navio!");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public int getAnoDeConstrução() {
		return anoDeConstrução;
	}

	public void setAnoDeConstrução(int anoDeConstrução) {
		this.anoDeConstrução = anoDeConstrução;
	}
	
	@Override
	public void menu() {
		System.out.println("Escolha o metodo a ser testado");
		System.out.println("1 - Mostrar informações");
		System.out.println("2 - Navegar");
		System.out.println("3 - Atirar");
		System.out.println("4 - Sair");
	}
}
