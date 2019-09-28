package ar.com.edu.unaj.nightapp.service.interfaces;


import ar.com.edu.unaj.nightapp.model.Servicio;

import java.util.List;

public interface ServicioService {
    List<Servicio> getAll();
    Servicio insert(Servicio servicio);
    Servicio getById(Long id);
    Servicio update(Servicio servicio);
    void removeById(Long id);
}
