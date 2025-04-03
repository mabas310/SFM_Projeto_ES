import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Caminho para o arquivo CSV dentro da pasta 'resources'
        List<Propriedade> propriedades = CarregadorCSV.carregarPropriedades('src/main/resources/Madeira-Moodle-1.1.csv');

        // Exibir as propriedades carregadas
        for (Propriedade propriedade : propriedades) {
            System.out.println(propriedade);
        }
    }
}