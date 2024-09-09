package exercicios_n2;

public class Monstro implements MenuMetodos{
	private String nome;
	private String raça;
	private int nivel;
	
	Monstro(String nome, String raça, int nivel){
		this.setNome(nome);
		this.setRaça(raça);
		this.setNivel(nivel);
	}
	
	void defender() {
		System.out.println("O monstro se defende do ataque");
	}
	
	void atacar() {
		System.out.println("O monstro realiza um ataque fisico!");
	}
	
	void desviar() {
		System.out.println("O monstro desvia do ataque");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaça() {
		return raça;
	}

	public void setRaça(String raça) {
		this.raça = raça;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	@Override
	public void menu() {
		System.out.println("Escolha o metodo a ser testado");
		System.out.println("1 - Mostrar informações");
		System.out.println("2 - Atacar");
		System.out.println("3 - Defender");
		System.out.println("4 - Sair");
	}
}
