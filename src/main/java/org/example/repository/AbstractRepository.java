package org.example.repository;

import org.example.domain.Entidade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractRepository<E extends Entidade<ID>, ID> implements Repository<E, ID> {

  private final Map<ID, E> dados = new HashMap<>();

  @Override
    public E salvar (E entidade) {
        E jaCadastrado = buscarPorID(entidade.getID());
           if (jaCadastrado != null) {
               remover(jaCadastrado);

           }
           dados.put(entidade.getID(), entidade);
           return entidade;

    }
    @Override
    public boolean remover(E entidade) {
        E elementoRemovido = dados.remove(entidade.getID());
        return elementoRemovido != null;
    }

    @Override
    public List<E> listarTodos() {

      return new ArrayList<>(dados.values());
    }

    @Override
    public E buscarPorID(ID identificador) {

      return dados.get(identificador);
    }




    }



