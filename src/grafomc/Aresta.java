package grafomc;

public class Aresta 
{
    private Vertice vAtual = null;
    private Vertice vProximo = null;
    private int cost;

    public Aresta(){}

    //Link: ligacao entre v1  e v2 
    public void setLigação(Vertice v1, Vertice v2)
    {
            this.vAtual = v1;
            this.vProximo = v2;
    }


    //Cost: custo/peso da aresta
    public void setPeso(int c)
    {
            this.cost = c;
    }

    //Cost: custo/peso da aresta
    public int getPeso()
    {
            return this.cost;
    }

    public Vertice getvAtual() {
        return vAtual;
    }

    public Vertice getvProximo() {
        return vProximo;
    }

    public void setvAtual(Vertice vAtual) {
        this.vAtual = vAtual;
    }

    public void setvProximo(Vertice vProximo) {
        this.vProximo = vProximo;
    }
        
        
	
}
