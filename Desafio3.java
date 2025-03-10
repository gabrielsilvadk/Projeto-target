import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;

public class Desafio3 {
    public static void main(String[] args) {
        double[] fatDiario = lerFaturamentoDeArquivo("d:/Work/Projeto target/Dados.json");
        analisarFaturamento(fatDiario);
    }

    public static double[] lerFaturamentoDeArquivo(String caminhoArquivo) {
        try {
            String conteudo = new String(Files.readAllBytes(Paths.get(caminhoArquivo)));
            JSONArray jsonArray = new JSONArray(conteudo);
            double[] faturamento = new double[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                faturamento[i] = obj.getDouble("valor");
            }

            return faturamento;
        } catch (Exception e) {
            e.printStackTrace();
            return new double[0];
        }
    }

    public static void analisarFaturamento(double[] faturamento) {
        double menorFaturamento = Double.MAX_VALUE;
        double maiorFaturamento = Double.MIN_VALUE;
        double soma = 0;
        int diasComFaturamento = 0;
        int diasAcimaDaMedia = 0;

        for (double f : faturamento) {
            if (f > 0) {
                if (f < menorFaturamento) menorFaturamento = f;
                if (f > maiorFaturamento) maiorFaturamento = f;
                soma += f;
                diasComFaturamento++;
            }
        }

        if (diasComFaturamento == 0) {
            System.out.println("Nenhum dia com faturamento registrado.");
            return;
        }

        double mediaMensal = soma / diasComFaturamento;
        
        for (double f : faturamento) {
            if (f > mediaMensal) {
                diasAcimaDaMedia++;
            }
        }

        System.out.println("Menor faturamento: " + menorFaturamento);
        System.out.println("Maior faturamento: " + maiorFaturamento);
        System.out.println("Dias acima da média: " + diasAcimaDaMedia);
    }
}