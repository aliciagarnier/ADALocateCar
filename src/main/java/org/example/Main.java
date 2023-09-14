package org.example;

import org.example.domain.Vehicle;
import org.example.repository.AluguelRepository;
import org.example.repository.PessoaFisicaRepository;
import org.example.repository.PessoaJuridicaRepository;
import org.example.repository.VehicleRepository;
import org.example.service.AluguelService;
import org.example.service.PessoaFisicaService;
import org.example.service.PessoaJuridicaService;
import org.example.service.VehicleService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Bem-vindo ao ADALocateCar!");

        // inicializar com dados.

        VehicleService vehicleService = new VehicleService(VehicleRepository.getVehicleRepository());

        PessoaJuridicaService pessoaJuridicaService = new PessoaJuridicaService(PessoaJuridicaRepository.getPessoaJuridicaRepository());

        PessoaFisicaService pessoaFisicaService = new PessoaFisicaService(PessoaFisicaRepository.getPessoaFisicaRepository());

        AluguelService aluguelService = new AluguelService(AluguelRepository.getAluguelRepository());

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        while (opcao != 11) {

            Menu.exibirMenuInicial();

            opcao = scanner.nextInt();
            clearBuffer(scanner);

            switch (opcao) {

                case 1 -> {

                    System.out.println("Digite o nome: ");
                    String nomePessoaFisica = scanner.nextLine();
                    System.out.println("Digite o cpf: ");
                    String cpf = scanner.nextLine();

                    pessoaFisicaService.CadastrarPessoaFisica(nomePessoaFisica, cpf);

                    if (pessoaFisicaService.existePessoaFisica(cpf)) {
                        System.out.println("Cadastro realizado com sucesso: ");
                        System.out.println(pessoaFisicaService.getPessoaFisicaRepository().buscarPorID(cpf).toString());
                    }


                }

                case 2 -> {

                    System.out.println("Qual o CPF do cadastro: ");
                    String CPF = scanner.nextLine();
                        if (pessoaFisicaService.existePessoaFisica(CPF)) {
                            System.out.println("Novo nome desejado: ");
                            String nome = scanner.nextLine();
                            pessoaFisicaService.atualizarPessoaFisica(nome, CPF);
                        }

                }

                case 3 -> {

                    System.out.println("Digite o nome: ");
                    String nomePessoaFisica = scanner.nextLine();
                    System.out.println("Digite o CNPJ: ");
                    String CNPJ = scanner.nextLine();

                    pessoaJuridicaService.CadastrarPessoaJuridica(nomePessoaFisica, CNPJ);

                    if (pessoaJuridicaService.existePessoaJuridica(CNPJ)) {
                        System.out.println("Cadastro realizado com sucesso: ");

                    }
                }

                    case 4 -> {

                        System.out.println("Buscar veículos");
                        System.out.println("Qual o nome do veículo?");

                        String nome = scanner.nextLine();

                        List<Vehicle> vehiclesFounded = vehicleService.buscarVeiculosPorParteDoNome(nome);

                        if (!vehiclesFounded.isEmpty()) {
                            System.out.println("Veículo(s) encontrado(s):");
                            System.out.println(vehiclesFounded);

                        } else {
                            System.out.println("Nenhum veículo foi encontrado");
                        }
                    }


                case 5 -> {

                    System.out.println("Listando todas as pessoas físicas cadastradas: ");

                    pessoaFisicaService.listarTodasPessoasFisicas();

                }

                case 6 -> {

                    System.out.println("Listando todas as empresas cadastradas: ");

                    pessoaJuridicaService.listarTodasPessoasJuridicas();
                }


                case 7 -> {

                    System.out.println("Digite o nome do veículo: ");

                    String nomeVeiculo = scanner.nextLine();

                    System.out.println("Digite a placa do veículo: ");

                    String placaVeiculo = scanner.nextLine();

                    System.out.println("Qual o tamanho do veículo? ATENÇÃO, os tamanhos válidos são: PEQUENO, MEDIO, SUV");

                    Tamanho tamanho = Tamanho.valueOf(scanner.nextLine().toUpperCase().trim());

                    vehicleService.RegisterVehicle(nomeVeiculo, placaVeiculo, tamanho);

                        if (vehicleService.existsVehicle(placaVeiculo)) {
                            System.out.println("Cadastro realizado com sucesso");


                        }

                }

                case 8 -> {

                    System.out.println("====== VEÍCULOS CADASTRADOS NO SISTEMA ========");
                    vehicleService.listarTodos();

                    System.out.println();


                }
                case 9 -> {

                    System.out.println("Qual a pessoa responsável pela locação? DIGITE 1 PARA PESSOA FÍSICA E 2 PARA PESSOA JURÍDICA: ");

                    int tipoPessoaLocacao = scanner.nextInt();

                     switch (tipoPessoaLocacao) {

                         case 1 -> {

                             clearBuffer(scanner);

                             System.out.println("Digite o CPF: ");

                             String cpf = scanner.nextLine();

                             System.out.println("Qual veículo você deseja alugar?");

                             if (pessoaFisicaService.existePessoaFisica(cpf)) {

                                 String nomeDoVeiculo = scanner.nextLine();

                                 System.out.println("VEÍCULOS " + nomeDoVeiculo + "DISPONÍVEIS PARA LOCAÇÃO: ");

                                 System.out.println(vehicleService.veiculosDisponiveisPeloNome(nomeDoVeiculo));

                                 System.out.println("Qual dos veículos listados você deseja alugar? ATENÇÃO: Digite a placa do veículo!");

                                 String placaDoVeiculo = scanner.nextLine();

                                 System.out.println("Data do fim da locação: ");

                                 String dataLocacao = scanner.nextLine();

                                 System.out.println("Local da locação: ");

                                 String localLocacao = scanner.nextLine();

                                 System.out.println("Local da devolução: ");

                                 String localDevolucao = scanner.nextLine();

                                 aluguelService.alugarVeiculo(vehicleService.buscarVeiculo(placaDoVeiculo), pessoaFisicaService.getPessoaFisicaRepository().buscarPorID(cpf), dataLocacao, localLocacao, localDevolucao);

                             }

                             System.out.println("ERRO: Pessoa não cadastrada.");

                         }

                         case 2 -> {

                             System.out.println("Digite o CNPJ: ");

                             String CNPJ = scanner.nextLine();

                             if (pessoaJuridicaService.existePessoaJuridica(CNPJ)) {

                                 System.out.println("Qual veículo você deseja alugar?");

                                 String nomeDoVeiculo = scanner.nextLine();

                                 System.out.println("VEÍCULOS " + nomeDoVeiculo + "DISPONÍVEIS PARA LOCAÇÃO: ");

                                 System.out.println(vehicleService.veiculosDisponiveisPeloNome(nomeDoVeiculo));

                                 System.out.println("Qual dos veículos listados você deseja alugar? ATENÇÃO: Digite a placa do veículo!");

                                 String placaDoVeiculo = scanner.nextLine();

                                 System.out.println("Data do fim da locação: ");

                                 String dataLocacao = scanner.nextLine();

                                 System.out.println("Local da locação: ");

                                 String localLocacao = scanner.nextLine();

                                 System.out.println("Local da devolução: ");

                                 String localDevolucao = scanner.nextLine();

                                 aluguelService.alugarVeiculo(vehicleService.buscarVeiculo(placaDoVeiculo), pessoaJuridicaService.getPessoaJuridicaRepository().buscarPorID(CNPJ), dataLocacao, localLocacao, localDevolucao);

                             }

                             System.out.println("ERRO: Empresa não cadastrada.");
                         }
                     }



                }
                case 10 -> {

                    System.out.println("Digite o CPF ou CNPJ do locador: ");

                        String identificador = scanner.nextLine();

                        if (pessoaFisicaService.existePessoaFisica(identificador)) {

                            System.out.println(aluguelService.buscarAluguelPorCliente(identificador));

                            System.out.println("Qual o aluguel deseja realizar a devolução? ATENÇÃO: Digite o ID do aluguel");

                            Long idAluguel = scanner.nextLong();

                            System.out.println(aluguelService.finalizarAluguel(idAluguel));



                        }

                        if (pessoaJuridicaService.existePessoaJuridica(identificador)) {

                            System.out.println(aluguelService.buscarAluguelPorCliente(identificador));

                            System.out.println("Qual o aluguel deseja realizar a devolução? ATENÇÃO: Digite o ID do aluguel");

                            Long idAluguel = scanner.nextLong();

                            System.out.println(aluguelService.finalizarAluguel(idAluguel));

                        }


                }
                case 11 -> {
                    System.out.println("Sistema encerrado. Obrigada!");
                }


            }



        }


    }

    private static void clearBuffer(Scanner scanner) {

        scanner.nextLine();
    }
}