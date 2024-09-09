package exercicios_n2;

public class Heroi implements MenuMetodos{
	private int ataque;
	private int defesa;
	private int vida;
	
	Heroi(int ataque, int defesa, int vida){
		this.setAtaque(ataque);
		this.setDefesa(defesa);
		this.setVida(vida);
	}
	
	void atacar(){
		System.out.println("O heroi ataca o mostro e dá " + ataque + "de dano!");
	}
	
	void defender() {
		System.out.println("O heroi se defende do ataque");
	}
	
	void desviar() {
		System.out.println("O heroi desvia do ataque");
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
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
