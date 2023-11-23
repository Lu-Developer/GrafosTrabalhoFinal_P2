package telas;

public class Configuracao {
    private String pasta;
    private String sucesso;
    private String erro;
    private boolean rotaAutomatica;

    public Configuracao(String pasta, String sucesso, String erro, boolean rotaAutomatica) {
        this.pasta = pasta;
        this.sucesso = sucesso;
        this.erro = erro;
        this.rotaAutomatica = rotaAutomatica;
    }

    public String getPasta() {
        return pasta;
    }

    public void setPasta(String pasta) {
        this.pasta = pasta;
    }

    public boolean isRotaAutomatica() {
        return rotaAutomatica;
    }

    public void setRotaAutomatica(boolean rotaAutomatica) {
        this.rotaAutomatica = rotaAutomatica;
    }

    public String getSucesso() {
        return sucesso;
    }

    public void setSucesso(String sucesso) {
        this.sucesso = sucesso;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
