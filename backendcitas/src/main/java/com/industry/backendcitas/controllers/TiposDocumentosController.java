package com.industry.backendcitas.controllers;

import com.industry.backendcitas.models.TipoDocumento;
import com.industry.backendcitas.services.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/center")
public class TiposDocumentosController {
    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping("/tipos-documentos")
    public List<TipoDocumento> getTiposDocumentos(){
        return this.tipoDocumentoService.readTiposDocumentos();
    }
}
