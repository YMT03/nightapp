package ar.com.edu.unaj.nightapp.service;

import ar.com.edu.unaj.nightapp.dao.EstablecimientoDAO;
import ar.com.edu.unaj.nightapp.endpoint.dto.FiltroDTO;
import ar.com.edu.unaj.nightapp.endpoint.mapper.CategoriaMapper;
import ar.com.edu.unaj.nightapp.exception.EstablecimientoNotFoundException;
import ar.com.edu.unaj.nightapp.model.Establecimiento;
import ar.com.edu.unaj.nightapp.model.Orden;
import ar.com.edu.unaj.nightapp.service.interfaces.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio encargado de la logica respecto a Establecimiento
 */
@Service
public class EstablecimientoServiceImp implements EstablecimientoService {

    @Autowired
    private EstablecimientoDAO establecimientoDAO;
    @Autowired
    private CategoriaMapper categoriaMapper;//TODO SACAR

    /**
     * @return Lista completa de Establecimientos en la DB
     */
    @Override
    public List<Establecimiento> getAll() {
        return (List<Establecimiento>) establecimientoDAO.findAll();
    }

    /**
     * @return Lista paginada de Establecimientos de la DB. Filtrando por nombre
     */
    @Override
    public List<Establecimiento> getAllPaginatedByNameContaining(Integer offset, Integer size, String name) {
        Pageable pageable = PageRequest.of(offset,size);
        return establecimientoDAO.findByNombreContainingAndActivoTrueOrderByNombre(name, pageable);
    }

    /**
     * Elimina el Establecimiento con el id pasado como parametro.
     * @param id id del Establecimiento a eliminar
     * @throws EstablecimientoNotFoundException Cuando no existe
     */
    @Override
    public void removeById(Long id) throws EstablecimientoNotFoundException {
        establecimientoDAO.delete(establecimientoDAO.findById(id).orElseThrow(EstablecimientoNotFoundException::new));
    }

    /**
     * @param id id del Establecimiento a obtener
     * @return Establecimiento en cuestion
     * @throws EstablecimientoNotFoundException En caso de no existir un Establecimiento de id {id}.
     */
    @Override
    public Establecimiento getById(Long id) throws EstablecimientoNotFoundException {
        return establecimientoDAO.findById(id).orElseThrow(EstablecimientoNotFoundException::new);
    }

    /**
     * Inserta el Establecimiento recibido como param
     * @param establecimiento
     * @return El establecimiento insertado
     */
    @Override
    public Establecimiento insert(Establecimiento establecimiento) {
        return establecimientoDAO.save(establecimiento);
    }

    /**
     * @param establecimiento
     * @return Establecimiento actualizado
     * @throws EstablecimientoNotFoundException Tira excepcion si no existia un Establecimiento con ese Id. Se fuerza la Excepcion para evitar un INSERT. En tal caso la URL de peticion es otra.
     */
    @Override
    public Establecimiento update(Establecimiento establecimiento) throws EstablecimientoNotFoundException {
        establecimientoDAO.findById(establecimiento.getId()).orElseThrow(EstablecimientoNotFoundException::new);
        return establecimientoDAO.save(establecimiento);
    }

    @Override
    public List<Establecimiento> getAllPaginatedAndFiltered(Integer offset, Integer size, FiltroDTO filtroDTO) {
        Sort sort = new Sort(filtroDTO.getOrden().name().toLowerCase());
        switch (filtroDTO.getOrden()){
            case RATING:
                sort = sort.descending();
                sort = sort.and(new Sort(Orden.NOMBRE.name().toLowerCase()));
                break;
            case DISTANCIA:
                sort.and(new Sort(Orden.NOMBRE.name().toLowerCase()));
                break;
            default:
                sort.ascending();
                break;
        }
        Pageable pageable = PageRequest.of(offset,size, sort);
        return establecimientoDAO.getPaginatedAndFiltered(filtroDTO.getNombre(), filtroDTO.getCategorias(),filtroDTO.getServicios(),filtroDTO.getMenus(), pageable);
    }
}
