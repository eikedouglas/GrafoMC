package grafomc;

import java.util.ArrayList;

public class Vertice {

	private String Valor;
	private int Grau;
	private ArrayList<Vertice> Listaadjacentes;
	private boolean Visitado;
	
	public Vertice(String valor) {
		Valor = valor;
		Grau = 0;
		Listaadjacentes = new ArrayList<Vertice>();
                Visitado = false;
	}

    public boolean isVisitado() {
        return Visitado;
    }

    public void setVisitado(boolean Visitado) {
        this.Visitado = Visitado;
    }
 
        public void setValor(String Valor) {
        this.Valor = Valor;
        }
	
	public String getValor(){
		return Valor;
	}

        public void setGrau(int Grau) {
                this.Grau = Grau;
        }
        
	public int getGrau(){
		return Grau;
	}
//	public boolean getSituacao(){
//		return Visitado;
//	}
	public ArrayList<Vertice> getListaadjacentes(){
		return Listaadjacentes;
	}
	public void adicionaAdjacente(Vertice v){
		Listaadjacentes.add(v);
	}
	public void removeAdjacente(Vertice v){
		Listaadjacentes.remove(v); //se v nao � encontrado retorna false
	}
	public void visitar(boolean visitar){
		Visitado = visitar;
	}
	public void limpaVertice(){
		Valor = "";
		Grau = 0;
		for(Vertice v : Listaadjacentes)
			v.removeAdjacente(this); //verificar esse this
		Listaadjacentes.clear();
		Visitado = false;
	}
        
        public void mostrarAjacentes() {
		for (Vertice a : Listaadjacentes)
			System.out.println(a.getValor());
		System.out.println("\n");
	}

}
