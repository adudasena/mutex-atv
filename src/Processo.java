public class Processo extends Thread {
    private Trava trava;
    private String nome;
    private RecursoCompartilhado recursoCompartilhado;

    public Processo (Trava trava, String nome, RecursoCompartilhado recursoCompartilhado) {
        this.trava = trava;
        this.nome= nome;
        this.recursoCompartilhado = recursoCompartilhado;
    }
}
