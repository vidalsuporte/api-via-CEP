package br.com.cadastro.principal;

import br.com.cadastro.json.JsonEndereco;
import br.com.cadastro.model.Cliente;
import br.com.cadastro.model.Endereco;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        List<Cliente> clientes = new ArrayList<>();
        int menu = 0;
        do {

            JsonEndereco jsonEndereco =new JsonEndereco();
            Scanner leitura = new Scanner(System.in);
            System.out.println("Digite a opção desejada: ");
            System.out.println("1 - Cadastro Cliente:");
            System.out.println("2 - Pesquisa Endereço");
            System.out.println("0 - Para Finalizar o programa");
            menu = leitura.nextInt();

            if(menu == 1){



                System.out.println("Digite o nome do Cliente: ");
                cliente.setNome(leitura.next());
                System.out.println("Digite a Idade o Cliente: ");
                cliente.setIdade(leitura.nextInt());
                System.out.println("Digite o CEP:");
                String cep = leitura.next();
                Endereco endereco = new Endereco(jsonEndereco.buscaEndereco(cep));
                System.out.println("Digite o Número:");
                String numero = leitura.next();
                endereco.setUnidade(numero);
                System.out.println("Digite o Complemento:");
                String complemento = leitura.next();
                endereco.setComplemento(complemento);
                cliente.setEndereco(endereco);
                System.out.println(cliente);

                System.out.println("deseja salvar cliente?");
                if(leitura.next().equalsIgnoreCase("sim")){
                    clientes.add(cliente);
                    System.out.println("Dados salvos com sucesso!");
                } else if (leitura.next().equalsIgnoreCase("não")) {
                    System.out.println("Dados do cliente não foram salvos");
                }else {
                    System.out.println("Opção inválida os dados do cliente não foram salvos");
                }


            } else if (menu == 2) {

                System.out.println("Digite o CEP:");
                String cep = leitura.next();

                System.out.println(jsonEndereco.buscaEndereco(cep));

            }else if(menu == 0) {
                System.out.println("saindo do sistema!");
                if(!clientes.isEmpty()){
                    Gson gson =new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                            .setPrettyPrinting()
                            .create();
                    try {
                        FileWriter arquivo = new FileWriter("Clientes.json");
                        arquivo.write(gson.toJson(clientes));
                        arquivo.close();
                        System.out.println("Arquivo salvo com sucesso!");
                    }catch (IOException e){
                        System.out.println("Falha ao gerar o arquivo!");
                    }
                }

                break;
            }else {


                System.out.println("Opção inválida digite novamente!");
            }


        }while (menu != 0);






    }
}