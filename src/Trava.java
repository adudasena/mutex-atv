public class Trava {

    // 1 com trava, 0 sem
    private int trava = 0;

    // mét que entra na região crítica
    public void entrarNaCritica() {

        while (true) {
            if (trava == 0) {
                trava = 1;
                //trava a região crítica
                return;
            }

            // pausa
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

        // mét pra sair da região crítica
        public void sairDaRegiaoCritica() {
            trava = 0;
        }
    }
