package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Bem-vindo ao ADALocateCar!");

        VehicleService vehicleService = new VehicleService(VehicleRepository.getVehicleRepository());

        PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService(PessoaJuridicaRepository.getPessoaJuridicaRepository());

        PessoaFisicaService pessoaFisicaService = new PessoaFisicaService(PessoaFisicaRepository.getPessoaFisicaRepository());

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 1) {

            opcao = scanner.nextInt();
            clearBuffer(scanner);

            switch (opcao) {

                case 1 -> {
                    System.out.println("Saindo do sistema!");
                }

                case 2 -> {
                    System.out.println("Cadastrar veículo no sistema");
                    System.out.println("Qual o nome do veiculo?");
                    String nome = scanner.nextLine();
                    System.out.println("Qual a placa do veiculo?");
                    String placa = scanner.nextLine();
                    System.out.println("Qual o tamanho do veiculo?");
                    Tamanho tamanho = Tamanho.valueOf(scanner.nextLine().toUpperCase().trim());

                    vehicleService.RegisterVehicle(nome, placa, tamanho);

                    System.out.println("Veiculo cadastrado");


                    //duvida aqui parra colocar as excecoes depois

                }

                case 3 -> {

                    System.out.println("Remover veículo");
                    System.out.println("Qual a placa do veiculo");
                    String placa = scanner.nextLine();

                    // aqui verifico se ele existe

                    Vehicle vehicle = VehicleRepository.getVehicleRepository().buscarPorID(placa);


                    if (vehicle != null ) {
                        vehicleService.removeVehicle(vehicle.getPlaca());
                        System.out.println("Veiculo removido com sucesso");
                        System.out.println(vehicleService.listarTodos().toString());
                    } else {
                        System.out.println("Nao foi possivel remover, n encontrado");
                    }

                }

                case 4 -> {

                    System.out.println("Buscar veículos");
                    System.out.println("Qual o nome do veículo?");

                    String nome = scanner.nextLine();

                      List<Vehicle> vehiclesFounded = vehicleService.buscarVeiculosPorParteDoNome(nome);

                      if(!vehiclesFounded.isEmpty()) {
                          System.out.println("Veículo(s) encontrado(s):");
                          System.out.println(vehiclesFounded);

                      } else {
                          System.out.println("Nenhum veículo foi encontrado");
                      }
                }

                case 5 -> {

                    System.out.println("Listando todos");
                    System.out.println(vehicleService.listarTodos().toString());

                }

                case 6 -> {

                    System.out.println("Testando as listagens de carros disponiveís por parte do nome");

                    System.out.println("Qual veículo você deseja alugar?");

                    String nomeDoVeiculo = scanner.nextLine();

                    System.out.println(vehicleService.veiculosDisponiveisPeloNome(nomeDoVeiculo));

                    // ideia de colocar o status do veículo como "ALUGADO" ou "DISPONÍVEL".
                    // LISTAR todos os CITROEN por exemplo, e ele escolher o veículo, o identificador.

                }

                case 7 -> {

                    System.out.println("Aluguel de um carro");

                    System.out.println("Qual dos veículos listados você deseja alugar, por favor digite a placa do veículo!");

                    String placaDoVeiculo = scanner.nextLine();

                    Vehicle veiculoASerALugado = VehicleRepository.getVehicleRepository().buscarPorID(placaDoVeiculo);
                }

            }



        }


    }

    private static void clearBuffer(Scanner scanner) {
        scanner.nextLine();
    }
}