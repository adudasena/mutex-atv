public class Trava {

    // 1 com trava, 0 sem
    private int trava= 0;

    // mét que entra na região crítica
    public void entrarNaCritica() {

        while (true) {
            if (trava == 0) {
                trava = 1;
                //trava a região crítica
                return;
            }
        }
    }
}
