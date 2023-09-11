package org.example;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository extends AbstractRepository<Vehicle, String> {

  private static final VehicleRepository vehicleRepository = new VehicleRepository();


  public static VehicleRepository getVehicleRepository() {

      return vehicleRepository;
  }

  public List<Vehicle> buscarVeiculoPorParteDoNome (String nome) {

   List<Vehicle> veiculosEncontrados = new ArrayList<>();

   for (Vehicle vehicle : listarTodos())
   {
         if (vehicle.getNome().toLowerCase().contains(nome.toLowerCase()))
         {
          veiculosEncontrados.add(vehicle);
         }
   }
   return veiculosEncontrados;

  }





 }