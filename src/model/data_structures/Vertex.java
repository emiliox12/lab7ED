package model.data_structures;

public class Vertex <K extends Comparable<K>, V> implements Comparable<Vertex<K,V>>{

	private K key;
	private V value;
	private boolean marked;
	public ILista<Edge<K, V>> edges;

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	public void mark() {
		marked = true;
	}

	public void unmark() {
		marked = false;
	}
	
	public boolean isMarked() {
		return marked;
	}
	
	public void addEdge(Edge<K, V> edge) {
		edges.addLast(edge);
	}

	public Vertex(K key, V value) {
		this.key = key;
		this.value = value;
		
	}

	@Override
	public int compareTo(Vertex<K, V> arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void dfs(Edge<K, V> edge) {
		mark();
		for (int i = 0; i < edges.size(); i++) {
			Vertex<K, V> dest = edges.getElement(i).getDestination();
			if (!dest.isMarked()) {
				dest.dfs(edge);
			}
		}
	}

	public void bfs(Edge<K, V> edge) {
		ArregloDinamico<Vertex<K, V>> queue = new ArregloDinamico<Vertex<K,V>>(10);
		mark();
		queue.addLast(this);
		while (queue.lastElement() != null) {
			Vertex<K, V> current = queue.removeLast();
			for (int i = 0; i < edges.size(); i++) {
				Vertex<K, V> dest = current.edges.getElement(i).getDestination();
				if (!dest.isMarked()) {
					dest.mark();
					queue.addLast(dest);
				}
			}
		}
	}
}
