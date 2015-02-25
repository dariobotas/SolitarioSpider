/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ips.pa.model.tads.Model.jogoSolitario;

/**
 *
 * @author AnTRaX
 */
public class Date {
    
  private int dia;
    private int mes;
    private int ano;

    /**
     * Construtor da classe.
     *
     * @param dia
     * @param mes
     * @param ano
     */
    public Date(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    /**
     * Método seletor do dia.
     *
     * @return
     */
    public int getDia() {
        return dia;
    }

    /**
     * Método modificador do dia.
     *
     * @param dia
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Método seletor do mes.
     *
     * @return
     */
    public int getMes() {
        return mes;
    }

    /**
     * Método modificador do mes.
     *
     * @param mes
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Método seletor do ano.
     *
     * @return
     */
    public int getAno() {
        return ano;
    }

    /**
     * Método modificador do ano.
     *
     * @param ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Método que imprime a data.
     *
     * @return
     */
    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }
    
}

