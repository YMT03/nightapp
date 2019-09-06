package ar.com.edu.unaj.nightapp.service;

import ar.com.edu.unaj.nightapp.dao.EstablecimientoDAO;
import ar.com.edu.unaj.nightapp.model.Establecimiento;
import ar.com.edu.unaj.nightapp.service.interfaces.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablecimientoServiceImp implements EstablecimientoService {

    @Autowired
    private EstablecimientoDAO establecimientoDAO;

    @Override
    public List<Establecimiento> getAll() {
        return establecimientoDAO.findAll();
    }

    @Override
    public void removeById(Long id) throws Exception {
        establecimientoDAO.delete(establecimientoDAO.findById(id).orElseThrow(Exception::new));
    }
}
