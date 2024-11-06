package br.com.cadastro.json;

import br.com.cadastro.dto.DtoEndereco;
import br.com.cadastro.model.Endereco;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonEndereco {

    public DtoEndereco buscaEndereco(String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        Gson json = new Gson();
        DtoEndereco dtoEndereco;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            dtoEndereco = json.fromJson(response.body(), DtoEndereco.class);



        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return dtoEndereco;



    }


}
