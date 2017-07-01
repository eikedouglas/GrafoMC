
package grafomc;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import java.util.Scanner;

public class LeArquivo {
    
    Grafo g = new Grafo();
    File fXmlFile;
    Scanner s = new Scanner(System.in);
    
    public LeArquivo() {
        
        this.fXmlFile = new File("F:\\MATEMATICA\\GRAFO FINAL\\grafo2.xml");      
    }
        
    public void leArquivo (Grafo g){
        
    try {
        
        
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(fXmlFile);

    doc.getDocumentElement().normalize();

    System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

    NodeList nList = doc.getElementsByTagName("vertice");
//  System.out.println("----------------------------");


    for (int temp = 0; temp < nList.getLength(); temp++) {
        
        
        Node nNode = nList.item(temp);

        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) nNode;
            
            String valorvert = eElement.getElementsByTagName("valorvertice").item(0).getTextContent();
            System.out.println(valorvert);
            g.adicionaVertice(new Vertice(valorvert));              
        }
    }
    
    NodeList nListA = doc.getElementsByTagName("aresta");
    
        for (int temp = 0; temp < nListA.getLength(); temp++) {
        
        
        Node nNode = nListA.item(temp);

        System.out.println("\nCurrent Element :" + nNode.getNodeName());

        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) nNode;        
            
            String vatual = eElement.getElementsByTagName("vatual").item(0).getTextContent();
            System.out.println(vatual);
            String vprox = eElement.getElementsByTagName("vprox").item(0).getTextContent();
            System.out.println(vprox);
            String cost = eElement.getElementsByTagName("cost").item(0).getTextContent(); 
            g.conecta(vatual, vprox, cost);
            
        }
    }
    
    } catch (Exception e) {
    e.printStackTrace();
    }
}  
    
}
