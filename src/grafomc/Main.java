package grafomc;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
            mensagem("Programa de grafos");
            Grafo g = new Grafo();
            Scanner ent = new Scanner(System.in);
            mensagem(StringsRespostas.menu);

            int esc = ent.nextInt();
            while (esc != 0) {
                switch (esc) {
                case 1:
                    mensagem(StringsRespostas.adicionaVertice);
                    String valor = ent.next();
                    g.adicionaVertice(new Vertice(valor));
                    break;
                case 2:
                    mensagem(StringsRespostas.removeVertice);

                    String vARetirar = ent.next();
                    for (Vertice v : g.vertices()) {
                            if (v.getValor().equalsIgnoreCase(vARetirar)) {
                                    g.removeVertice(v);
                            break;
                            }
                    }
                    break;
                case 3:
                    mensagem(StringsRespostas.conectaVertice);   
                    String valor1 = ent.next();
                    String valor2 = ent.next();

                    System.out.println("Digite o peso da aresta\n");
                    String peso = ent.next(); 
                    g.conecta(valor1, valor2, peso);
                    break;
                case 4:
                    mensagem(StringsRespostas.desconectarVertice);
                    String val1 = ent.next();
                    String val2 = ent.next();
                    g.desconecta(val1, val2);
                    break;
                case 5:
                    mensagem(StringsRespostas.mostrarExistenciaArestaPedido);
                    String va1 = ent.next();
                    String va2 = ent.next();

                    boolean r = g.existeAresta(va1, va2);
                    if (r == true){
                        System.out.println("Existe aresta entre os vertices\n");
                    }else{
                        System.out.println("Não existe aresta\n");
                    }
                    break;    
                case 6:
                    mensagem(StringsRespostas.mostrarVerticesAdjacentesPedido);
                    String v1 = ent.next();
                    g.obterAdjacentes(v1);
                    break;
                case 7:
                    mensagem(StringsRespostas.grauVerticePedido);
                    String vert = ent.next();
                    g.grau(vert);
                    break;
                case 8:
                    g.grauMinMedMax();
                    break;
                case 9:
                    if (g.eConexo() == true) {
                            mensagem(StringsRespostas.grafoEConexo);
                    }else{
                        mensagem(StringsRespostas.grafoNaoConexo);
                    }
                    break;
                case 10:
                    boolean n = g.euler();
                    break;                           
                case 11:
                    g.matrizAdjacencia();
                    break;                            
                case 12:
                    int m[][] = g.matrizAdjacenciaDirecionada();
                    break;
                case 13:
                    g.matrizAcessibilidade();
                    break;
                case 14://ler do arquivo
                    LeArquivo le = new LeArquivo();
                    le.leArquivo(g);
                    break;

                case 15://caminho minimo
                    mensagem(StringsRespostas.caminhoMinimo);   
                    int x = ent.nextInt();
                    int y = ent.nextInt();
                    g.dijkstraCaminhoMinimo(x, y);
                    break;
                case 16://bellmanFord

                    g.bellmanFord(ent.nextInt());
                        break;
                case 17://floyd   

                    int mat[][] = g.floyd();
                    g.imprimeMatriz(mat);
                        break;
                case 18://termos conectados   

                    //int Qtermos = 
                            g.termosConectados();
                   // System.out.println("Componentes conectados: "+Qtermos);
                        break;
                case 55:
//                    int [][] map = g.matrizAdjacenciaPeso();
//                    g.imprimeMatriz(map);
                    g.mostrarVertices();
                    break;
                }
                mensagem(StringsRespostas.menu);
                esc = ent.nextInt();
            }
            System.out.println("Finalizado");

    }

	private static void mensagem(String mensagem) {
		System.out.println(mensagem + "\n");
	}

}
