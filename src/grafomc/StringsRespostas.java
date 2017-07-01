package grafomc;

public class StringsRespostas {
    
    public static final String adicionaVertice = "Digite o valor do vertice que voce deseja adicionar: ";
    public static final String caminhoMinimo = "Digite os vertices de origem e destino para obter o caminho minimo: ";
    public static final String removeVertice = "Digite o valor do vertice que voce deseja remover: ";
    public static final String conectaVertice = "Digite o valor dos vertices que voce deseja conectar: ";
    public static final String desconectarVertice = "Digite o valor dos vertices que voce deseja desconectar: ";
    public static final String mostrarVerticesAdjacentesPedido = "Digite o valor do vertice ao qual voce quer verificar os adjacentes: ";
    public static final String mostrarExistenciaArestaPedido = "Digite o valor dos vertices que voce quer verificar a existencia de aresta: ";
    public static final String mostrarVerticesAdjacentesResposta = "Os vertices adjacentes sao: ";
    public static final String grauVerticePedido = "Digite o valor do vertice ao qual deseja obter o grau: ";
    public static final String grauVerticeResposta = "O grau do vertice é: ";
    public static final String grafoEConexo = "O grafo é conexo";
    public static final String grafoNaoConexo = "O grafo nao é conexo";


	public static final String erroVerticeIncorreto = "Nao há vertice com este valor";
	public static final String duvidaRemoveVertice = "Deseja obter uma lista dos vertices do seu grafo?";
	
	public static final String menu = "Escolha o que voce deseja fazer:\n1-Adicionar vertice\n2-Remover vertice\n"
			+ "3-Inserir aresta\n4-Remover aresta\n5-Verificar existencia de aresta\n"
			+ "6-Mostrar os vertices adjacentes de um vertice do grafo\n7-Retornar o grau de um vertice do grafo\n"
			+ "8-Obter grau minimo, medio e maximo\n9-Verificar se o grafo e conexo\n10-Verificar se existe caminho de Euler\n"
                        + "11-Exibir Matriz de Adjacências\n12-Exibir Matriz de Adjacências Direcionada\n13-Exibir Matriz de Acessibilidade\n"    
                        + "14-Ler do arquivo\n15-Caminho Minimo\n16-Vetor de todos caminhos minimos de um vertice para os demais\n17-Floyd\n"
                        + "18-Conta termos conectados\n0-Fechar";  
}