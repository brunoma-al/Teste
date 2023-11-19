package devandroid.bruno.teste.model;

public class Classe {

    private String primeiroNome;
    private String motivoCandidatura;


    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getMotivoCandidatura() {
        return motivoCandidatura;
    }

    public void setMotivoCandidatura(String motivoCandidatura) {
        this.motivoCandidatura = motivoCandidatura;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "primeiroNome='" + primeiroNome + '\'' +
                ", motivoCandidatura='" + motivoCandidatura + '\'' +
                '}';
    }
}
