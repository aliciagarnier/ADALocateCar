package org.example;

 public class VehicleRepository extends AbstractRepository<Vehicle, String> {


  private static final VehicleRepository vehicleRepository = new VehicleRepository();


  public static VehicleRepository getVehicleRepository() {
   return vehicleRepository;
  }

  public Vehicle buscarVeiculoPorNome (String nome) {

   for (Vehicle vehicle : listarTodos())
   {
         if (vehicle.getNome().equalsIgnoreCase(nome))
         {
          return vehicle;
         }
   }
   return null;
  }





 }