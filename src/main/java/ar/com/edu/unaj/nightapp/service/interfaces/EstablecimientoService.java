package ar.com.edu.unaj.nightapp.service.interfaces;

import ar.com.edu.unaj.nightapp.endpoint.dto.FiltroDTO;
import ar.com.edu.unaj.nightapp.exception.EstablecimientoNotFoundException;
import ar.com.edu.unaj.nightapp.model.Establecimiento;

import java.util.List;

public interface EstablecimientoService {

    List<Establecimiento> getAll();
    List<Establecimiento> getAllPaginatedByNameContaining(Integer offset, Integer size, String name);
    void removeById(Long id) throws EstablecimientoNotFoundException;
    Establecimiento getById(Long id) throws EstablecimientoNotFoundException;
    Establecimiento insert(Establecimiento establecimiento);
    Establecimiento update(Establecimiento establecimiento) throws EstablecimientoNotFoundException;
    List<Establecimiento> getAllPaginatedAndFiltered(Integer offset, Integer size, FiltroDTO filtroDTO);
}
