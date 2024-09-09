package exercicios_n2;

public class MetalTransição implements MenuMetodos{
	private String nome;
	private int numeroAtomico;
	private float densidade;
	
	MetalTransição(String nome, int numeroAtomico, float densidade){
		this.setNome(nome);
		this.setNumeroAtomico(numeroAtomico);
		this.setDensidade(densidade);
	}
	
	void fusionar() {
		System.out.println(nome + " entra em processo de fusão");
	}
	
	void solidificar() {
		System.out.println(nome + " está se solidificando");
	}
	
	void oxidar() {
		System.out.println(nome + " começa a oxidar");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroAtomico() {
		return numeroAtomico;
	}

	public void setNumeroAtomico(int numeroAtomico) {
		this.numeroAtomico = numeroAtomico;
	}

	public float getDensidade() {
		return densidade;
	}

	public void setDensidade(float densidade) {
		this.densidade = densidade;
	}
	
	@Override
	public void menu() {
		System.out.println("Escolha o metodo a ser testado");
		System.out.println("1 - Mostrar informações");
		System.out.println("2 - Fusionar");
		System.out.println("3 - Solidificar");
		System.out.println("4 - Sair");
	}
}
