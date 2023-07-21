import java.util.LinkedList;
import java.util.Queue;

public class PilhaComFilas {

  // Atributos
  private Queue<String> fila1;
  private Queue<String> fila2;

  // Construtor
  public PilhaComFilas() {
    fila1 = new LinkedList<>();
    fila2 = new LinkedList<>();
  }

  // Método empilhar
  public void empilhar(String content) {
    // Adicionar o elemento na fila 1
    fila1.add(content);
  }

  // Método imprimir
  public void imprimir() {
    // Imprimir os elementos da fila 1
    System.out.println("Pilha:");
    for (String content : fila1) {
      System.out.println(content);
    }
  }

  // Método desempilhar
  public String desempilhar() {
    // Transferir os elementos da fila 1 para a fila 2, exceto o último elemento
    while (fila1.size() > 1) {
      fila2.add(fila1.remove());
    }

    // Remover e retornar o último elemento da fila 1 (o elemento do topo da pilha)
    String removedItem = fila1.remove();

    // Trocar as referências das filas para manter a estrutura correta da pilha
    Queue<String> temp = fila1;
    fila1 = fila2;
    fila2 = temp;

    return removedItem;
  }

  // Método principal
  public static void main(String[] args) {
    // Cria uma nova pilha
    PilhaComFilas pilha = new PilhaComFilas();

    // Adiciona os elementos à pilha (fila1)
    pilha.empilhar("Elemento 1");
    pilha.empilhar("Elemento 2");
    pilha.empilhar("Elemento 3");

    // Imprime a pilha
    pilha.imprimir();

    // Remove um elemento da pilha
    String desempilhado = pilha.desempilhar();
    System.out.println("Desempilhado: " + desempilhado);

    // Adiciona um novo elemento à pilha
    pilha.empilhar("Elemento 4");

    // Imprime a pilha novamente
    pilha.imprimir();
  }
}