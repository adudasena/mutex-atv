public class Main {
    public static void main(String[] args) {
        System.out.println("=== Teste Mutex com variável trava ===\n");

        // início
        Trava trava = new Trava();
        RecursoCompartilhado recurso = new RecursoCompartilhado();

        // cria 5 processos
        Processo p1 = new Processo(trava, "1", recurso);
        Processo p2 = new Processo(trava, "2", recurso);
        Processo p3 = new Processo(trava, "3", recurso);
        Processo p4 = new Processo(trava, "4", recurso);
        Processo p5 = new Processo(trava, "5", recurso);

        // inicializando todos
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();

        // aguardando o término
        try {
            p1.join();
            p2.join();
            p3.join();
            p4.join();
            p5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\n=== FIM ===");
        System.out.println("Contador final: " + recurso.getContador());
        System.out.println("5 processos e 10 incrementos");
    }
}