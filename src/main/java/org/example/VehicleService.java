package org.example;

import java.util.List;


public class VehicleService {


    private final VehicleRepository vehicleRepository;


    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }


    public Vehicle RegisterVehicle(String nome, String placa, Tamanho tamanho) throws Exception {

        if (existsVehicle(placa)) {
            throw new Exception("veiculo ja registrado");
        }

        Vehicle newVehicle = new Vehicle(nome, placa, tamanho);
        return vehicleRepository.salvar(newVehicle);

    }

    public boolean existsVehicle (String placa) {
        Vehicle vehicle = vehicleRepository.buscarPorID(placa);
        return vehicle != null;
    }

    public Vehicle updateVehicle (String placa, String nome, Tamanho tamanho) throws Exception {

        if (!(existsVehicle(placa))) {
            throw new Exception("Veiculo nao encontrado");
        }

        Vehicle updatedVehicle = new Vehicle(placa, nome, tamanho);
        return vehicleRepository.salvar(updatedVehicle);


    }

    public boolean removeVehicle(String placa) {
        return vehicleRepository.remover(vehicleRepository.buscarPorID(placa));

    }


    public List<Vehicle> listarTodos() {
        return vehicleRepository.listarTodos();
    }

    public Vehicle searchVehicle (String nome) {

        return vehicleRepository.buscarVeiculoPorNome(nome);

    }




}
