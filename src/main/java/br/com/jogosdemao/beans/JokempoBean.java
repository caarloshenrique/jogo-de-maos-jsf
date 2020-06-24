package br.com.jogosdemao.beans;

import java.io.Serializable;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class JokempoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jogador1;
    private String itemJogador1;
    private final String imgJogador1 = "/images/player-one.png";
    private String jogador2;
    private String itemJogador2;
    private final String imgJogador2 = "/images/player-two.png";
    private String vencedor;
    private String imgVencedor;
    private String mensagem;

    public String getJogador1() {
        return jogador1;
    }

    public void setJogador1(String jogador1) {
        this.jogador1 = jogador1;
    }

    public String getItemJogador1() {
        return itemJogador1;
    }

    public void setItemJogador1(String itemJogador1) {
        this.itemJogador1 = itemJogador1;
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

    public String getItemJogador2() {
        return itemJogador2;
    }

    public void setItemJogador2(String itemJogador2) {
        this.itemJogador2 = itemJogador2;
    }

    public String getImgJogador2() {
        return imgJogador2;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String Vencedor) {
        this.vencedor = Vencedor;
    }

    public String getImgVencedor() {
        return imgVencedor;
    }

    public void setImgVencedor(String imgVencedor) {
        this.imgVencedor = imgVencedor;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String calcularResultadoJogada() {
        int ITEM_JOGADOR_1 = Integer.parseInt(getItemJogador1());
        int ITEM_JOGADOR_2 = Integer.parseInt(getItemJogador2());
        String EMPATE = "Houve empate entre as jogadas";
        String PEDRA_TESOURA = "Pedra quebra tesoura";
        String PAPEL_PEDRA = "Papel embrulha pedra";
        String TESOURA_PAPEL = "Tesoura corta papel";

        if (ITEM_JOGADOR_1 == 1 && ITEM_JOGADOR_2 == 1) {
            setMensagem(EMPATE);
            return "mensagem-jokempo";
        } else if (ITEM_JOGADOR_1 == 1 && ITEM_JOGADOR_2 == 2) {
            definirVencedor(getJogador2(), getImgJogador2());
            setMensagem(PAPEL_PEDRA);
        } else if (ITEM_JOGADOR_1 == 1 && ITEM_JOGADOR_2 == 3) {
            definirVencedor(getJogador1(), getImgJogador1());
            setMensagem(PEDRA_TESOURA);
        } else if (ITEM_JOGADOR_1 == 2 && ITEM_JOGADOR_2 == 1) {
            definirVencedor(getJogador1(), getImgJogador1());
            setMensagem(PAPEL_PEDRA);
        } else if (ITEM_JOGADOR_1 == 2 && ITEM_JOGADOR_2 == 2) {
            setMensagem(EMPATE);
            return "mensagem-jokempo";
        } else if (ITEM_JOGADOR_1 == 2 && ITEM_JOGADOR_2 == 3) {
            definirVencedor(getJogador2(), getImgJogador2());
            setMensagem(TESOURA_PAPEL);
        } else if (ITEM_JOGADOR_1 == 3 && ITEM_JOGADOR_2 == 1) {
            definirVencedor(getJogador2(), getImgJogador2());
            setMensagem(PEDRA_TESOURA);
        } else if (ITEM_JOGADOR_1 == 3 && ITEM_JOGADOR_2 == 2) {
            definirVencedor(getJogador1(), getImgJogador1());
            setMensagem(TESOURA_PAPEL);
        } else if (ITEM_JOGADOR_1 == 3 && ITEM_JOGADOR_2 == 3) {
            setMensagem(EMPATE);
            return "mensagem-jokempo";
        } else {
            setMensagem("Não foi possível calcular a jogada!");
            return "mensagem-jokempo";
        }
        return "resultado-jokempo";
    }

    public void definirVencedor(String jogador, String imgJogador) {
        this.setVencedor(jogador);
        this.setImgVencedor(imgJogador);
    }

    public String lancarJogadaRandomica() {
        int itens[] = {1, 2, 3};

        setItemJogador1("" + (new Random().nextInt(itens.length) + 1));
        setItemJogador2("" + (new Random().nextInt(itens.length) + 1));

        return calcularResultadoJogada();
    }
}
