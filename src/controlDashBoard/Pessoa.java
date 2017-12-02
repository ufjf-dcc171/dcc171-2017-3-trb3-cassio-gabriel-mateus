
package controlDashBoard;


public class Pessoa
{
    private String pesNome;
    private String pesEmail;
    private String pesSenha;

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

    public String getPesSenha() {
        return pesSenha;
    }

    public void setPesSenha(String pesSenha) {
        this.pesSenha = pesSenha;
    }

    public Pessoa(String pesNome, String pesEmail, String pesSenha) {
        this.pesNome = pesNome;
        this.pesEmail = pesEmail;
        this.pesSenha = pesSenha;
    }
    
    
    
    
}
