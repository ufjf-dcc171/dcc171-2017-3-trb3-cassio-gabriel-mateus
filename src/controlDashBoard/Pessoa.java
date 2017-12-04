package controlDashBoard;

public class Pessoa {

    private String pesNome;
    private String pesEmail;

    public Pessoa() {
    }

    public String getPesNome() {
        return pesNome;
    }

    public void setPesNome(String pesNome) {
        this.pesNome = pesNome;
    }

    public String getPesEmail() {
        return pesEmail;
    }

    public void setPesEmail(String pesEmail) {
        this.pesEmail = pesEmail;
    }

    public Pessoa(String pesNome, String pesEmail) {
        this.pesNome = pesNome;
        this.pesEmail = pesEmail;
    }

}
