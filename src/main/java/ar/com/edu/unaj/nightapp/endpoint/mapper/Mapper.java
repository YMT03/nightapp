package ar.com.edu.unaj.nightapp.endpoint.mapper;

/**
 * Interfaz para respetar el mappeo de objeto BO a DTO
 * @param <U> U Es el Objeto BO
 * @param <T> T Es el Objeto DTO
 */
public interface Mapper<U,T> {

    T mapToDTO(U bo);
    U mapToBO(T dto);
}
