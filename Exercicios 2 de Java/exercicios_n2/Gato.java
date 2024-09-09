package exercicios_n2;

public class Gato implements MenuMetodos{
	private String raça;
	private String nome;
	private int idade;
	
	Gato(String raça, String nome, int idade){
		this.setRaça(raça);
		this.setNome(nome);
		this.setIdade(idade);
	}
	
	void andar() {
		System.out.println(nome + " está andando");
	}
	
	void comer() {
		System.out.println(nome + " começou a comer");
	}
	
	void dormir() {
		System.out.println("shhh " + nome + "está dormindo");
	}

	public String getRaça() {
		return raça;
	}

	public void setRaça(String raça) {
		this.raça = raça;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public void menu() {
		System.out.println("Escolha o metodo a ser testado");
		System.out.println("1 - Mostrar informações");
		System.out.println("2 - Andar");
		System.out.println("3 - Dormir");
		System.out.println("4 - Sair");
	}
}
