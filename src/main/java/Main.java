import java.util.List;

public class Main {
    public static void main(String[] args) {
        String caminho = "src/main/Madeira-Moodle.csv";  // Caminho relativo a partir da raiz do projeto
        List<Propriedade> propriedades = CarregadorCSV.carregarPropriedades(caminho);

        // Exibe as propriedades carregadas
        for (Propriedade p : propriedades) {
            System.out.println(p);
        }
    }
}
