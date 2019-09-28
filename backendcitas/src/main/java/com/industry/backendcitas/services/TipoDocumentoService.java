package com.industry.backendcitas.services;

import com.industry.backendcitas.models.TipoDocumento;
import com.industry.backendcitas.repository.TipoDocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoDocumentoService {
    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoService(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    public List<TipoDocumento> readTiposDocumentos() {
        return this.tipoDocumentoRepository.findAll();
    }

    public TipoDocumento createTipoDocumento(TipoDocumento tipoDocumento) {
        return this.tipoDocumentoRepository.save(tipoDocumento);
    }

    public TipoDocumento updateTipoDocumento(TipoDocumento tipoDocumento) {
        return this.tipoDocumentoRepository.save(tipoDocumento);
    }

    public void deleteTipoDocumento(int idTipoDocumento) {
        this.tipoDocumentoRepository.deleteById(idTipoDocumento);
    }
}
