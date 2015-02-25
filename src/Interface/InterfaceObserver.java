package Interface;

import pt.ips.pa.model.tads.Model.jogoSolitario.Subject;

public interface InterfaceObserver{

// metodo para fazer update ao observador, usado pelo sujeito observado
public void update(Subject obj);
}