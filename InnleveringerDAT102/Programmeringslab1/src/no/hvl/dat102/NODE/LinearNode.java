package no.hvl.dat102.NODE;

public class LinearNode <T> {

    private LinearNode<T> neste;
    private T element;

    public LinearNode() {
        neste = null;
        element = null;
    }
    public LinearNode(T elem) {
        neste = null;
        element = elem;
    }
    // GET/SET
    public LinearNode<T> getNeste() {return neste;}
    public T getElement() {return element;}
    public void setNeste(LinearNode<T> neste) {this.neste = neste;}
    public void setElement(T element) {this.element = element;}
}
