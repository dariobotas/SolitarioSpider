package Interface;

public interface InterfaceSubject{

// metodos para adicionar e remover observadores
public void add(InterfaceObserver obj);

public void remove(InterfaceObserver obj);

//metodo para notificar observadores da mudança de estado
public void notifyObservers();
}
