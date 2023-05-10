
import java.util.ArrayList;
import java.util.List;

public class RegistroPresenze {
    private List<Presenza> presenze;

    public RegistroPresenze() {
        presenze = new ArrayList<>();
    }

    public void aggiungiPresenza(String nome, int giorni) {
        presenze.add(new Presenza(nome, giorni));
    }

    public List<Presenza> getPresenze() {
        return presenze;
    }

    public static RegistroPresenze fromString(String s) {
        RegistroPresenze registro = new RegistroPresenze();

        String[] presenzeStr = s.split("#");
        for (String presenzaStr : presenzeStr) {
            String[] tokens = presenzaStr.split("@");
            String nome = tokens[0].trim();
            int giorni = Integer.parseInt(tokens[1].trim());
            registro.aggiungiPresenza(nome, giorni);
        }

        return registro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Presenza presenza : presenze) {
            sb.append(presenza.getNome()).append(" @ ").append(presenza.getGiorni()).append("#");
        }

        return sb.toString();
    }

    public static class Presenza {
        private String nome;
        private int giorni;

        public Presenza(String nome, int giorni) {
            this.nome = nome;
            this.giorni = giorni;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getGiorni() {
            return giorni;
        }

        public void setGiorni(int giorni) {
            this.giorni = giorni;
        }
    }
}


