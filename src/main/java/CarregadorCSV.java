import com.opencsv.CSVReader;
import com.opencsv.CSVReaderHeaderAware;
import com.opencsv.exceptions.CsvValidationException;

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

            // Troque o readNext() por nextRecord(), se for a versão 5.x ou superior
            while ((linha = reader.readNext()) != null) {
                if (linha.length >= 8) {
                    try {
                        String id = linha[1];  // PAR_ID
                        double area = 0;
                        try {
                            area = Double.parseDouble(linha[4]);  // Shape_Area
                        } catch (NumberFormatException e) {
                            System.out.println("Erro ao converter área para número: " + linha[4]);
                        }
                        String proprietario = linha[6];  // OWNER
                        String localizacao = linha[7];  // Freguesia

                        // Verifique se os dados essenciais estão preenchidos
                        if (id != null && !id.isEmpty() && proprietario != null && !proprietario.isEmpty()) {
                            Propriedade propriedade = new Propriedade(id, area, proprietario, localizacao);
                            propriedades.add(propriedade);
                        } else {
                            System.out.println("Propriedade com dados incompletos: " + linha[0]);
                        }
                    } catch (Exception e) {
                        System.out.println("Erro ao processar linha: " + String.join(",", linha));
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Linha com número de colunas inesperado: " + String.join(",", linha));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo CSV: " + e.getMessage());
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return propriedades;
    }
}
