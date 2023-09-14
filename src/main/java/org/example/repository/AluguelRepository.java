package org.example.repository;

import org.example.domain.Aluguel;

public class AluguelRepository extends AbstractRepository<Aluguel, Long> {


    private static final AluguelRepository aluguelRepository = new AluguelRepository();

    private AluguelRepository () {

    }

    public static AluguelRepository getAluguelRepository () {

        return aluguelRepository;
    }








}
