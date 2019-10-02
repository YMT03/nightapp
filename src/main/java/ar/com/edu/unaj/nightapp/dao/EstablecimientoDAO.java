package ar.com.edu.unaj.nightapp.dao;

import ar.com.edu.unaj.nightapp.endpoint.dto.FiltroDTO;
import ar.com.edu.unaj.nightapp.model.Categoria;
import ar.com.edu.unaj.nightapp.model.Establecimiento;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstablecimientoDAO  extends PagingAndSortingRepository<Establecimiento, Long> {

    List<Establecimiento> findByNombreContaining(String name, Pageable pageable);

    @Query(value = "SELECT * FROM ESTABLECIMIENTOS E\n" +
            "INNER JOIN ESTABLECIMIENTOS_CATEGORIAS EC\n" +
            "ON E.ID=EC.ESTABLECIMIENTO_ID\n" +
            "INNER JOIN CATEGORIAS C\n" +
            "ON C.ID=EC.CATEGORIA_ID\n" +
            "WHERE ACTIVO=1", nativeQuery = true)

    List<Establecimiento> findDistinctByCategorias_NombreInAndActivoTrueAndServicios_NombreInAndMenus_NombreIn(List<String> categorias, List<String> servicios, List<String> menus);

    /*@Query(value = "SELECT DISTINCT E.ID, E.NOMBRE, E.DESCRIPCION, E.UBICACION_ID, E.ACTIVO FROM ESTABLECIMIENTOS E " +

            //JOIN CATEGORIA
            "INNER JOIN ESTABLECIMIENTOS_CATEGORIAS EC " +
            "ON EC.ESTABLECIMIENTO_ID = E.ID " +
            "INNER JOIN CATEGORIAS C " +
            "ON EC.CATEGORIA_ID= C.ID " +
            //JOIN SERVICIO
            "INNER JOIN ESTABLECIMIENTOS_SERVICIOS ES " +
            "ON ES.ESTABLECIMIENTO_ID = E.ID " +
            "INNER JOIN SERVICIOS S " +
            "ON S.ID = ES.SERVICIO_ID " +
            //JOIN MENU
            "INNER JOIN ESTABLECIMIENTOS_MENUS EM " +
            "ON EM.ESTABLECIMIENTO_ID = E.ID " +
            "INNER JOIN MENUS M " +
            "ON M.ID = EM.MENU_ID " +
            "WHERE (C.NOMBRE IN (?1) OR CONCAT('',?1)='') " +
            "AND E.ACTIVO ",nativeQuery = true)*/

    @Query("SELECT DISTINCT e FROM ar.com.edu.unaj.nightapp.model.Establecimiento e " +
            "INNER JOIN e.categorias c " +
            "INNER JOIN e.servicios s " +
            "INNER JOIN e.menus m " +
            "WHERE c.nombre IN (?1) " +
            "AND s.nombre IN (?2) " +
            "AND m.nombre IN (?3) " +
            "ORDER BY e.nombre")

    List<Establecimiento> getPaginatedAndFiltered(List<String> categorias, List<String> servicios, List<String> menus, Pageable pageable);

}
