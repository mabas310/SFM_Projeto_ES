import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Caminho para o arquivo CSV dentro da pasta 'resources'
        List<Propriedade> propriedades = CarregadorCSV.carregarPropriedades("src/main/resources/Madeira-Moodle-1.1.csv");

        // Criar o grafo de propriedades
        GrafoPropriedades grafoPropriedades = new GrafoPropriedades();

        // Adicionar as propriedades ao grafo
        for (Propriedade propriedade : propriedades) {
            grafoPropriedades.adicionarPropriedade(propriedade);
        }

        // Estabelecer as conexões (adjacências) entre as propriedades
        for (int i = 0; i < propriedades.size(); i++) {
            for (int j = i + 1; j < propriedades.size(); j++) {
                Propriedade p1 = propriedades.get(i);
                Propriedade p2 = propriedades.get(j);

                // Conectar propriedades com a mesma freguesia
                if (p1.getLocalizacao().equals(p2.getLocalizacao())) {
                    grafoPropriedades.adicionarAdjacencia(p1, p2);
                }
            }
        }

        // Exibir o grafo
        grafoPropriedades.exibirGrafo();
    }
}
