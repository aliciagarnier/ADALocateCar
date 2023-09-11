package org.example;

import java.util.List;

public interface Repository <T extends Entidade <ID>, ID> {

    T salvar (T entidade);

    boolean remover(T entidade);

    List<T> listarTodos();

    T buscarPorID (ID identificador);
    
}
