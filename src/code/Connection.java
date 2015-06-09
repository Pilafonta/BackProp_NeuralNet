/**
 * @author Peter LaFontaine 
 * date 2/20/15
 * 
 */



public class Connection {
    
    public Connection(Node from, Node to, double weight) {
        m_from = from;
        m_to = to;
        m_weight = weight;
    }
    
    public Node getFromNode() {
        return m_from;
    }
    
    public Node getToNode() {
        return m_to;
    }
    
    public double getWeight() {
        return m_weight;
    }
    public double addWeight(double weight){
        return m_weight += weight;
    }
    
    private double m_weight;
    private double m_deltaw;

    private Node m_from;
    private Node m_to;

}