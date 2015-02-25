package utilities;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import Interface.Stack;
import pt.ips.pa.model.tads.Model.jogoSolitario.CartaSolitaireFX;

/**
 * 
 * @author AnTRaX
 */
public class Move {

    private Stack STACK_INICIAL;
    private Stack STACK_DESTINO;
    private ArrayList<CartaSolitaireFX> MOVER_CARTAS;

    public Move(Stack STACK_INICIAL, Stack STACK_DESTINO, ArrayList<CartaSolitaireFX> MOVER_CARTAS) {
        this.STACK_INICIAL = STACK_INICIAL;
        this.STACK_DESTINO = STACK_DESTINO;
        this.MOVER_CARTAS = MOVER_CARTAS;
    }

    public void undoMove() {
        if (((this.STACK_INICIAL instanceof Stack)) && (!this.STACK_INICIAL.isEmpty())) {
//            this.STACK_INICIAL.getCartaTopo().esconderCarta();
        }
        this.STACK_INICIAL.addCartas(this.MOVER_CARTAS);
        this.STACK_DESTINO.removeCartas(this.MOVER_CARTAS);
    }
}
