package br.com.jogosdemao.beans;

import java.io.Serializable;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DoisOuUmBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jogador1;
    private String numeroJogador1;
    private final String imgJogador1 = "/images/player-one.png";
    private String jogador2;
    private String numeroJogador2;
    private final String imgJogador2 = "/images/player-two.png";
    private String jogador3;
    private String numeroJogador3;
    private final String imgJogador3 = "/images/player-three.png";
    private String vencedor;
    private String numeroVencedor;
    private String imgVencedor;

    public String getJogador1() {
        return jogador1;
    }

    public void setJogador1(String jogador1) {
        this.jogador1 = jogador1;
    }

    public String getNumeroJogador1() {
        return numeroJogador1;
    }

    public void setNumeroJogador1(String numeroJogador1) {
        this.numeroJogador1 = numeroJogador1;
    }

    public String getImgJogador1() {
        return imgJogador1;
    }

    public String getJogador2() {
        return jogador2;
    }

    public void setJogador2(String jogador2) {
        this.jogador2 = jogador2;
    }

    public String getNumeroJogador2() {
        return numeroJogador2;
    }

    public void setNumeroJogador2(String numeroJogador2) {
        this.numeroJogador2 = numeroJogador2;
    }

    public String getImgJogador2() {
        return imgJogador2;
    }

    public String getJogador3() {
        return jogador3;
    }

    public void setJogador3(String jogador3) {
        this.jogador3 = jogador3;
    }

    public String getNumeroJogador3() {
        return numeroJogador3;
    }

    public void setNumeroJogador3(String numeroJogador3) {
        this.numeroJogador3 = numeroJogador3;
    }

    public String getImgJogador3() {
        return imgJogador3;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

    public String getNumeroVencedor() {
        return numeroVencedor;
    }

    public void setNumeroVencedor(String numeroVencedor) {
        this.numeroVencedor = numeroVencedor;
    }

    public String getImgVencedor() {
        return imgVencedor;
    }

    public void setImgVencedor(String imgVencedor) {
        this.imgVencedor = imgVencedor;
    }

    public String calcularResultadoJogada() {
        int NUMERO_JOGADOR_1 = Integer.parseInt(getNumeroJogador1());
        int NUMERO_JOGADOR_2 = Integer.parseInt(getNumeroJogador2());
        int NUMERO_JOGADOR_3 = Integer.parseInt(getNumeroJogador3());

        if (NUMERO_JOGADOR_1 != NUMERO_JOGADOR_2 && NUMERO_JOGADOR_1 != NUMERO_JOGADOR_3) {
            definirVencedor(getJogador1(), NUMERO_JOGADOR_1, getImgJogador1());
        } else if (NUMERO_JOGADOR_2 != NUMERO_JOGADOR_1 && NUMERO_JOGADOR_2 != NUMERO_JOGADOR_3) {
            definirVencedor(getJogador2(), NUMERO_JOGADOR_2, getImgJogador2());
        } else if (NUMERO_JOGADOR_3 != NUMERO_JOGADOR_1 && NUMERO_JOGADOR_3 != NUMERO_JOGADOR_2) {
            definirVencedor(getJogador3(), NUMERO_JOGADOR_3, getImgJogador3());
        } else {
            return "empate-dois-ou-um";
        }

        return "resultado-dois-ou-um";
    }

    public void definirVencedor(String jogador, int numeroJogador, String imgJogador) {
        this.setVencedor(jogador);
        this.setNumeroVencedor("" + numeroJogador);
        this.setImgVencedor(imgJogador);
    }

    public String lancarJogadaRandomica() {
        int numeros[] = {1, 2};
        setNumeroJogador1("" + (new Random().nextInt(numeros.length) + 1));
        setNumeroJogador2("" + (new Random().nextInt(numeros.length) + 1));
        setNumeroJogador3("" + (new Random().nextInt(numeros.length) + 1));

        return calcularResultadoJogada();
    }

}
