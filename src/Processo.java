public class Processo extends Thread {
    private Trava trava;
    private String nome;
    private RecursoCompartilhado recursoCompartilhado;

    public Processo (Trava trava, String nome, RecursoCompartilhado recursoCompartilhado) {
        this.trava = trava;
        this.nome= nome;
        this.recursoCompartilhado = recursoCompartilhado;
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // tenta entrar na região crítica
            System.out.println("[" + nome + "] quer entrar.");
            trava.entrarNaCritica();

            // região crítica
            System.out.println("[" + nome + "] entrou na região crítica.");
            System.out.println("[" + nome + "] Contador: " + recursoCompartilhado.getContador());

            recursoCompartilhado.incrementacao();

            System.out.println("[" + nome + "] Novo: " + recursoCompartilhado.getContador());
            System.out.println("[" + nome + "] saiu da região crítica.");
            // fim da região crítica

            trava.sairDaRegiaoCritica();

            // fora da região crítica
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("[" + nome + "] terminou!");
    }
}

