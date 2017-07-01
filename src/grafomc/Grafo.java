package grafomc;

import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.ArrayList;
import java.util.Scanner;

public class Grafo {

	private ArrayList<Vertice> ListaVertices;
        private ArrayList<Aresta> ListaArestas;
        
        Scanner ent = new Scanner(System.in);


	public Grafo() {
		ListaVertices = new ArrayList<Vertice>();
                ListaArestas = new ArrayList<Aresta>();
	}

	public void adicionaVertice(Vertice v) {
		// "Adiciona um novo v�rtice em G"
		ListaVertices.add(v);
	}

	public void removeVertice(Vertice v) {
		// "Remove um  v�rtice de G, juntamente com todas as conex�es"
		v.limpaVertice();
		ListaVertices.remove(v);
	}

	public void conecta(String valor1, String valor2, String Peso) {
		// "Conecta os v�rtices v1 e v2 em G"
		for(int i = 0; i < ListaVertices.size(); i++) {
			if (ListaVertices.get(i).getValor().equals(valor1)){
                            for(int j = 0; j < ListaVertices.size(); j++){
                                if (ListaVertices.get(j).getValor().equals(valor2)){
                                
                                ListaVertices.get(i).adicionaAdjacente(ListaVertices.get(j));
                                int graude1 = ListaVertices.get(i).getGrau();
                                graude1++;
                                ListaVertices.get(i).setGrau(graude1);  
                                
                                
                                ListaVertices.get(j).adicionaAdjacente(ListaVertices.get(i));
                                int graude2 = ListaVertices.get(j).getGrau();
                                graude2++;
                                ListaVertices.get(j).setGrau(graude2);
                                
                                Aresta a = new Aresta();
                                a.setLigação(ListaVertices.get(i), ListaVertices.get(j));
                                a.setPeso(Integer.parseInt(Peso));
                                ListaArestas.add(a);
                                
                                //System.out.println("Adjacente do segundo");
                                //ListaVertices.get(j).mostrarAjacentes();
                                }
                            }
			}
		}
                
	}

	public void desconecta(String valor1, String valor2) {
		// "Desconecta os v�rtices v1 e v2 em G"
                for(int i = 0; i < ListaVertices.size(); i++) {
			if (ListaVertices.get(i).getValor().equals(valor1)){ //testa se vertice ja foi percorrido
                            for(int j = 0; j < ListaVertices.size(); j++){
                                if (ListaVertices.get(j).getValor().equals(valor2)){
                                ListaVertices.get(i).removeAdjacente(ListaVertices.get(j));
                                int graude1 = ListaVertices.get(i).getGrau();
                                graude1--;
                                ListaVertices.get(i).setGrau(graude1);
                                

                                //System.out.println("Adjacente do primeiro");
                                //ListaVertices.get(i).mostrarAjacentes();
                                
                                ListaVertices.get(j).removeAdjacente(ListaVertices.get(i));
                                int graude2 = ListaVertices.get(j).getGrau();
                                graude2--;
                                ListaVertices.get(j).setGrau(graude2);

                                //System.out.println("Adjacente do segundo");
                                //ListaVertices.get(j).mostrarAjacentes();
                                }
                            }
			}
		}	
            
	}

	public int ordem() {
		return ListaVertices.size();
	}

	public ArrayList<Vertice> vertices() {
		// "Retorna um conjunto contendo os v�rtices de G"
		return ListaVertices;
	}

	public Vertice umVertice() {
		// "Retorna um v�rtice qualquer de G"
		int random = (int) Math.random() * (ListaVertices.size() - 1);
		//System.out.println(random);
		return ListaVertices.get((random + 1));
	}

	public ArrayList<Vertice> adjacentes(Vertice v) {
		// "Retorna um conjunto contendo os v�rtices adjacentes a v em G"
		return v.getListaadjacentes();
	}
        
        public void obterAdjacentes(String valor) {
		for(int i = 0; i < ListaVertices.size(); i++){
                    if (ListaVertices.get(i).getValor().equals(valor)){
                    ListaVertices.get(i).mostrarAjacentes();
                    //System.out.println("Adjacente do primeiro");
                    }
                }
	}
        public boolean existeAresta(String valor1, String valor2) {
		for(int i = 0; i < ListaVertices.size(); i++){
                    if (ListaVertices.get(i).getValor().equals(valor1)){
                        Vertice v = ListaVertices.get(i);
                        for(int j = 0; j < v.getListaadjacentes().size(); j++){
                            if(v.getListaadjacentes().get(j).getValor().equals(valor2)){
                                
                                return true;
                            }
                        } 
                        
                    }
                }
               
                return false;
                
	}
        
        public boolean existeArestaDirecionada(String valor1, String valor2) {
            for(int i = 0; i < ListaArestas.size(); i++){
                if ((ListaArestas.get(i).getvAtual().getValor().equals(valor1)) &&
                        (ListaArestas.get(i).getvProximo().getValor().equals(valor2))){
                        return true;   
                    }  
            }
            return false;
        }

	public void grau(String valor) {
            for(int i = 0; i < ListaVertices.size(); i++){
                if (ListaVertices.get(i).getValor().equals(valor)){
                System.out.println("O grau do vertice é:" + ListaVertices.get(i).getGrau());
                }
            }
		
	}
        public int pesoAresta(String valor1, String valor2) {
            for(int i = 0; i < ListaArestas.size(); i++){
                if ((ListaArestas.get(i).getvAtual().getValor().equals(valor1)) &&
                        (ListaArestas.get(i).getvProximo().getValor().equals(valor2)) ){    
                    return ListaArestas.get(i).getPeso();
                    }   
                if ((ListaArestas.get(i).getvAtual().getValor().equals(valor2)) &&
                        (ListaArestas.get(i).getvProximo().getValor().equals(valor1)) ){    
                    return ListaArestas.get(i).getPeso();
                } 
            }
            return 0;
	}
        
        public void grauMinMedMax (){
            int     
                menor = 0,
                soma  = 0,    
                maior = 0;
            float 
                medio = 0;
            
            for(int i = 0; i < ListaVertices.size(); i++){
                soma = soma + ListaVertices.get(i).getGrau();
                if (ListaVertices.get(i).getGrau() >= maior){
                    maior = ListaVertices.get(i).getGrau();
                }
            }
            
            for(int i = 0; i < ListaVertices.size(); i++){
                if (ListaVertices.get(i).getGrau() < maior){
                    menor = ListaVertices.get(i).getGrau();

                }
            }
            
            medio = (float) soma / ListaVertices.size();
                        
            System.out.println("O grau minimo é: "+menor);
            System.out.println("O grau medio é: " +medio);
            System.out.println("O grau maximo é: "+maior);
        }

	// ACOES DERIVADAS

	public void desmarcaVertices() {
		// marca todos vertices do grafo como nao percorridos/visitados
		for(int i = 0; i < ListaVertices.size();i++){
			ListaVertices.get(i).setVisitado(false);
		}				
	}
        
        public void marcaVerticesVisitados(ArrayList<Vertice> lista) {
		// marca todos vertices do grafo como nao percorridos/visitados
		for(int i = 0; i < lista.size();i++){
			lista.get(i).visitar(true);
		}				
	}
	
	
	public void percorreGrafo(String valor) {
            // Percorre o grafo a partir de um vértice e vai marcando os vertices ja visitados
            //Espera-se que todos estejam marcados como nao percorridos ao inicio
            
            for(int i = 0; i < ListaVertices.size(); i++){
                if (ListaVertices.get(i).getValor().equals(valor)){
                    	Vertice v = ListaVertices.get(i);
                        for(int j = 0; j < v.getListaadjacentes().size(); j++) {
                            if (v.getListaadjacentes().get(j).isVisitado() == false){
				v.getListaadjacentes().get(j).setVisitado(true);
				percorreGrafo(v.getListaadjacentes().get(j).getValor());
                            }				
                        }  
                }
            }
	}
	public int buscaConecatdos(String valor) {           
            int qntAdj = 0;
            for(int i = 0; i < ListaVertices.size(); i++){
                if (ListaVertices.get(i).getValor().equals(valor)){
                    	Vertice v = ListaVertices.get(i);
                        qntAdj = v.getListaadjacentes().size();
                        for(int j = 0; j < ListaVertices.get(i).getListaadjacentes().size(); j++) {
                            if (ListaVertices.get(i).getListaadjacentes().get(j).isVisitado() == false){
				ListaVertices.get(i).getListaadjacentes().get(j).setVisitado(true);
                                
				percorreGrafo(ListaVertices.get(i).getListaadjacentes().get(j).getValor());
                            }				
                        }  
                }
            }
            return qntAdj;
	}
        
	public ArrayList<Vertice> fechoTransitivo(String valor) {
		// "Retorna um conjunto contendo todos os v�rtices de G que
		// s�o transitivamente alcanc�veis partindo-se de v"
		desmarcaVertices(); //garante que nenhum vertice esteja marcado como visitado		
		ArrayList<Vertice> fecho = new ArrayList<Vertice>(ListaVertices.size()); //arraylist base 
		percorreGrafo(valor); 
		for(int i = 0; i < ListaVertices.size(); i++) {
			if (ListaVertices.get(i).isVisitado() == true){ //testa se vertice ja foi percorrido
				Vertice v = ListaVertices.get(i);
                                fecho.add(v);				
			}				
		}
		return fecho;
	}
	
	public boolean eConexo() {
		// "Verifica se existe pelo menos um caminho que entre
		// cada par de vértices de G"
		Vertice v = umVertice(); //pega um vertice aleatorio para percorrer
		for(int i = 0; i < ListaVertices.size(); i++){
			if(fechoTransitivo(v.getValor()).contains(ListaVertices.get(i)) == false){
				//se algum dos vertices do grafo não estiver contido no fecho transitivo de v
				//retorna falso para eConexo
				return false;
			}
		}
		return true;
	}
	
	public void mostrarVertices() {
		for (Vertice v : ListaVertices)
			System.out.println(v.getValor());
		System.out.println("\n");
	}
        
        public boolean euler (){
            int grau = 0;
            if (eConexo()== false){
                System.out.println("Não existe caminho de Euler");
                return false;
                
            }
            for (Vertice v : ListaVertices){
                v.getGrau();
                if(v.getGrau()%2 != 0){
                    grau++;
                    if(grau > 2){
                        System.out.println("Não existe caminho de Euler");
                        return false;
                    }
                }
                
            }
        
        
        System.out.println("Há caminho de Euler");
        return true;
        
        }
        
        public void imprimeMatriz(int Mat[][]){
	   
            for(int i = 0; i < ListaVertices.size(); i++){
    		for(int j = 0; j < ListaVertices.size(); j++){
    			System.out.print(Mat[i][j] + " ");
    		}
    		System.out.println();
            }
        }
        
        public void matrizAdjacencia(){
            
            
            int n = ordem();
            int matriz[][] = new int[n][n];
            
            for (int i = 0; i < n; i++)
            {
                System.out.println("");
                for (int j = 0; j < n; j++)
                {
                        if (existeAresta(ListaVertices.get(i).getValor(), ListaVertices.get(j).getValor()) == true)
                        {
                            matriz[i][j] = 1;
                            System.out.print(matriz[i][j]);
                        }else{
                            matriz[i][j] = 0;
                            System.out.print(matriz[i][j]);
                        }
                }
            }
            System.out.println("");
        }
        
        public int[][] matrizAdjacenciaDirecionada(){
            int n = ordem();
            int matriz[][] = new int[n][n];
            
            for (int i = 0; i < n; i++)
            {
                System.out.println("");
                for (int j = 0; j < n; j++)
                {
                        if (existeArestaDirecionada(ListaVertices.get(i).getValor(), ListaVertices.get(j).getValor()) == true)
                        {
                            matriz[i][j] = 1;
                            System.out.print(matriz[i][j]);
                        }else{
                            matriz[i][j] = 0;
                            System.out.print(matriz[i][j]);
                        }
                }
            }
            
            System.out.println("");
            return matriz;
        }
        
        public void matrizAcessibilidade(){
          
            int n = ordem();
            System.out.println(n);
            int matriz[][] =     matrizAdjacenciaDirecionada(); //new int[n][n];
            
            for(int k=0; k < n; k++){
                System.out.println("\n");
                for (int i = 0; i < n; i++)
                {
                    System.out.println("");
                    for (int j = 0; j < n; j++)
                    {
                        matriz[i][j] = Math.max(matriz[i][j], (Math.min(matriz[i][k], matriz[k][j])));
                        System.out.print(matriz[i][j]);
                    }
                }
            }
            System.out.println("");
        }
        public int[][] matrizAdjacenciaPeso(){
           
            int n = ordem();
            int matriz[][] = new int[n][n];
            
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    if (ListaVertices.get(i).getValor().equals(ListaVertices.get(j).getValor())){
                        matriz[i][j] = 0;
                    }else{if (existeAresta(ListaVertices.get(i).getValor(), ListaVertices.get(j).getValor()) == true)
                        {
                            int p = pesoAresta(ListaVertices.get(i).getValor(), ListaVertices.get(j).getValor());
                            matriz[i][j] = p;
                        }else{
                            matriz[i][j] = 99;
                        }
                    }
                }
            }            
            return matriz;
        }
        public void dijkstraCaminhoMinimo(int x, int y){
            int MatPeso[][] = matrizAdjacenciaPeso();
            int n = ordem();
            int d[] =  new int[n];
            int s[] = new int[n];
            ArrayList<Integer> IN = new ArrayList();
            IN.add(x);
            int pos = 0;
            //achar posicao de x 
            for(int i = 0; i < ListaVertices.size(); i++){
                    if (ListaVertices.get(i).getValor().equals(Integer.toString(x))){
                    pos = i;
                    }
            }

            for(int i=0; i<n; i++){
                d[i] = MatPeso[pos][i];
                System.out.println("d :"+ d[i]);
                s[i] = x;
            }
            for(int i=0; i<n; i++){
                System.out.println("s :"+ s[i]);
            }
            
            int p = 0; int dminima=9999; int danterior;
            
            while(IN.contains(y) == false){
                dminima = 9999;
                for(int i=0; i<n; i++){
                    if(IN.contains(Integer.parseInt(ListaVertices.get(i).getValor())) == false){
                        
                        System.out.println("Vetices analizados:" + ListaVertices.get(i).getValor());
                        
                        if(d[i] < dminima){
                         dminima = d[i];
                         p = i;
                            
                        }
                    }
                }
                System.out.println("p :"+ p);
                System.out.println("dmin :"+ dminima);

                IN.add(Integer.parseInt(ListaVertices.get(p).getValor()));
                
                for(int i=0; i<n; i++){
                    if(IN.contains(Integer.parseInt(ListaVertices.get(i).getValor())) == false){
                        danterior = d[i];
                        d[i] = Math.min(d[i], (d[p]+MatPeso[p][i]));
                        if(d[i] != danterior){
                            s[i] = p;
                        }
                    }
                }
                for(int i=0; i<n; i++){
                System.out.println("d :"+ d[i]);
                
                }
                for(int i=0; i<n; i++){
                
                System.out.println("s :"+ s[i]);
                }     
            }  
            System.out.print("Caminho: ");
            for(int i=1; i<s.length; i++){
                System.out.print(s[i]);
            }
            System.out.println(y);
            
        }
        
        public void bellmanFord(int x){
            
            int n = ordem();
            int mat[][] = matrizAdjacenciaPeso();
            int distanciaAnterior;
            int d[] = new int[n];
            int s[] = new int[n];
            
            int pos;
            //achar posicao de x 
//            System.out.println("x antes:"+x);
            
            for(int i = 0; i < ListaVertices.size(); i++){
                if (ListaVertices.get(i).getValor().equals(Integer.toString(x))){
                    pos = i;
                    for(int j=0; j<n; j++){
                        d[j] = mat[pos][j];
                        System.out.println("d :"+ d[j]);
                        s[j] = x;  
                    }
                }
            }

            for(int i = 1; i < n; i++){	
                for(int u = 0; u < n; u++){
                    for(int v = 0; v < n; v++){
                        distanciaAnterior = d[v];
			d[v] = Math.min(d[v], (d[u] + mat[u][v]));
                            if(d[v] != distanciaAnterior ){
                                s[v] = u;
                            }
                    }
                }
            }
            
            for(int i=0; i<d.length; i++){
                System.out.print(d[i]+" ");
            }
            System.out.println("\n");
   
        }

        public int[][] floyd(){
        int[][]mat = matrizAdjacenciaPeso();
        int n = ordem();
        for(int k=0;k<n;k++){	
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                        if((mat[i][k] + mat[k][j]) < mat[i][j]){
                            mat[i][j] = mat[i][k] + mat[k][j];
                        }
                }
            }
        }
        return mat;
        }
        
        public void imprimeVetor(int v[]){
            for(int i=0;i<v.length ;i++){
                System.out.print(v[i]);
            }
            System.out.println("");
        }
        
        public int termosConectados(){
            int termos = 0; 
            int contVertices = 0;
            int maior = 0;
            if (eConexo() == true){
                termos = 1;
                //System.out.println("NÃO!!!");
            }else{
                desmarcaVertices();
                for(int i=0; i<ListaVertices.size(); i++){
                    if(ListaVertices.get(i).isVisitado() == false){                       
                        contVertices = 1 + buscaConecatdos(ListaVertices.get(i).getValor());
                            if(contVertices > maior){
                                maior = contVertices;
                            }
                        //System.out.println("VEZ");
                        termos++; 
                    }
                }       
            }
	    System.out.println("Termos: "+termos);
            System.out.println("Maior : "+ maior);
            return termos;           
        }   
}