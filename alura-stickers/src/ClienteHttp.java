import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class ClienteHttp {

    public String buscaDados(String url){

        try {

            // fazer uma conexão HTTP e buscar os top 250 conteudos
            //String imdbKey = System.getenv("IMDB_API_KEY");
            URI endereco = URI.create(url);
            var client = HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(endereco).GET().build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String body = response.body();
            return body;
            // System.out.println(body);
            
        } catch (IOException | InterruptedException ex) {
            throw new ClienteHttoException("Erro ao consultar a URL :(");
        }
        
    }
    
}
