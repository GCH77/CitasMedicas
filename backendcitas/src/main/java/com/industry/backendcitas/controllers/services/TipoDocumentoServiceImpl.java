package com.industry.backendcitas.controllers.services;

import com.industry.backendcitas.controllers.repository.TipoDocumentoRepository;
import com.industry.backendcitas.models.TipoDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TipoDocumentoServiceImpl implements TipoDocumentoService{
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    @Transactional
    public TipoDocumento saveTipoDocumento(TipoDocumento tipoDocumento) { return tipoDocumentoRepository.save(tipoDocumento); }
}
