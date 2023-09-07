package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Bem-vindo ao ADALocateCar!");

        VehicleService vehicleService = new VehicleService(VehicleRepository.getVehicleRepository());

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

                    Tamanho tamanho = Tamanho.valueOf(scanner.next().toUpperCase());

                    Vehicle registeredVehicle = vehicleService.RegisterVehicle(nome, placa, tamanho);

                    System.out.println(registeredVehicle.toString());


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

                    System.out.println("Buscar veiculo por nome");
                    System.out.println("Qual o nome do veiculo");
                    String nome = scanner.nextLine();

                      Vehicle vehicleFounded = vehicleService.searchVehicle(nome);

                      if(vehicleFounded != null) {
                          System.out.println("Encontrado");
                          System.out.println(vehicleFounded.toString());

                      } else {
                          System.out.println("Nao encontrado");
                      }

                }

            }



        }


    }

    private static void clearBuffer(Scanner scanner) {
        scanner.nextLine();
    }
}