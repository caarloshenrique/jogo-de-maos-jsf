package br.com.jogosdemao.beans;

import java.io.Serializable;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ParOuImparBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String jogador1;
    private String grupoNumeros1;
    private String jogada1;
    private final String imgJogador1 = "/images/player-one.png";
    private String jogador2;
    private String grupoNumeros2;
    private String jogada2;
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

    public String getGrupoNumeros1() {
        return grupoNumeros1;
    }

    public void setGrupoNumeros1(String grupoNumeros1) {
        this.grupoNumeros1 = grupoNumeros1;
    }

    public String getJogada1() {
        return jogada1;
    }

    public void setJogada1(String jogada1) {
        this.jogada1 = jogada1;
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

    public String getGrupoNumeros2() {
        return grupoNumeros2;
    }

    public void setGrupoNumeros2(String grupoNumeros2) {
        this.grupoNumeros2 = grupoNumeros2;
    }

    public String getJogada2() {
        return jogada2;
    }

    public void setJogada2(String jogada2) {
        this.jogada2 = jogada2;
    }

    public String getImgJogador2() {
        return imgJogador2;
    }

    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
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
        String GRUPO2 = "2";
        String GRUPO1 = "1";

        if (validarCampos()) {
            int jogadaUm = Integer.parseInt(getJogada1());
            int jogadaDois = Integer.parseInt(getJogada2());
            int soma = jogadaUm + jogadaDois;

            if (soma % 2 == 0) {
                definirVencedor(GRUPO2);
                return "par";
            } else {
                definirVencedor(GRUPO1);
                return "impar";
            }
        }

        setMensagem("É preciso selecionar grupos de números distintos para os jogadores!");

        if (getJogada1().equals("") || getJogada2().equals("")) {
            setMensagem("É preciso inserir uma jogada para os jogadores!");
        }

        return "validacao";
    }

    public boolean validarCampos() {
        if (Integer.parseInt(getGrupoNumeros1()) == 2 && Integer.parseInt(getGrupoNumeros2()) == 2) {
            return false;
        }

        if (Integer.parseInt(getGrupoNumeros1()) == 1 && Integer.parseInt(getGrupoNumeros2()) == 1) {
            return false;
        }

        return !(getJogada1().equals("") || getJogada2().equals(""));
    }

    public void definirVencedor(String grupo) {
        int GRUPO1 = Integer.parseInt(getGrupoNumeros1());
        int GRUPO_PARAMETRO = Integer.parseInt(grupo);

        if (GRUPO1 == GRUPO_PARAMETRO) {
            this.setVencedor(getJogador1());
            this.setImgVencedor(getImgJogador1());
        } else {
            this.setVencedor(getJogador2());
            this.setImgVencedor(getImgJogador2());
        }
    }

    public String lancarJogadaRandomica() {
        setJogada1("" + (new Random().nextInt(100) + 1));
        setJogada2("" + (new Random().nextInt(100) + 1));

        return calcularResultadoJogada();
    }
}
