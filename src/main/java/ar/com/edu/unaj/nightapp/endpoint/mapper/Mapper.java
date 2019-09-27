package ar.com.edu.unaj.nightapp.endpoint.mapper;

/**
 * Interfaz para respetar el mappeo de objeto BO a DTO
 * @param <U> U Es el Objeto BO
 * @param <T> T Es el Objeto DTO
 */
public interface Mapper<U,T> {

    T mapToDTO(U bo);
    default T mapToDTO(U bo, boolean eager){
        return mapToDTO(bo);
    }
    U mapToBO(T dto);
    default U mapToBO(T dto, boolean eager){
        return mapToBO(dto);
    };
}
