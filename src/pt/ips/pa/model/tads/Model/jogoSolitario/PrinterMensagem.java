package pt.ips.pa.model.tads.Model.jogoSolitario;

//CLASSE QUE IMPLEMENTA OBSERVER*****

import Interface.InterfaceObserver;


public class PrinterMensagem implements InterfaceObserver{

    private int numJogadas;

@Override
public void update(Subject sub){
    int aux;
    aux=numJogadas+1;
    //String msg = ((GestorMensagem) sub).getMsg();
System.out.println("Numero de Jogadas realizadas" + aux);
}

}