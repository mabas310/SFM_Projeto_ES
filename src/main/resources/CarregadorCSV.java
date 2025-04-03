import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarregadorCSV {

    public static List<Propriedade> carregarPropriedades(String arquivoCSV) {
        List<Propriedade> propriedades = new ArrayList<>();

        try (CSVReader reader = new CSVReader(new FileReader(arquivoCSV))) {
            String[] linha;
            reader.readNext();  // Pula o cabeçalho (caso haja)

            while ((linha = reader.readNext()) != null) {
                // Mapeando as colunas corretas do CSV para os atributos da classe Propriedade
                String id = linha[1];  // PAR_ID
                double area = Double.parseDouble(linha[4]);  // Shape_Area
                String proprietario = linha[6];  // OWNER
                String localizacao = linha[7];  // Freguesia

                Propriedade propriedade = new Propriedade(id, area, proprietario, localizacao);
                propriedades.add(propriedade);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return propriedades;
    }
}
