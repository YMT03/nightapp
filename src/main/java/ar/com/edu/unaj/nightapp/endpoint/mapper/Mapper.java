package ar.com.edu.unaj.nightapp.endpoint.mapper;

public interface Mapper<U,T> {

    T mapToDTO(U bo);
    U mapToBO(T dto);
}
