package exercicios_n2;

public class Elemento implements MenuMetodos{
	private String tipo;
	private int grau;
	private String foco;
	
	Elemento(String tipo, int grau, String foco){
		this.setTipo(tipo);
		this.setGrau(grau);
		this.setFoco(foco);
	}
	
	void imbuir() {
		System.out.println("Você imbui sua arma em" + tipo);
	}
	
	void evocar() {
		System.out.println("Você evoca o elemento" + tipo + "de grau" + grau);
	}
	
	void atacar() {
		System.out.println("Você invoca uma magia de" + tipo + "de grau" + grau + "focada em" + foco);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getGrau() {
		return grau;
	}

	public void setGrau(int grau) {
		this.grau = grau;
	}

	public String getFoco() {
		return foco;
	}

	public void setFoco(String foco) {
		this.foco = foco;
	}

	@Override
	public void menu() {
		System.out.println("Escolha o metodo a ser testado");
		System.out.println("1 - Mostrar informações");
		System.out.println("2 - Imbuir");
		System.out.println("3 - Evocar");
		System.out.println("4 - Sair");
	}
}
