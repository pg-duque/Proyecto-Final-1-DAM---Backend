package dam.code.backendgaleriaspringboot.controller;

import dam.code.backendgaleriaspringboot.model.FuentePoder;
import dam.code.backendgaleriaspringboot.repository.FuentePoderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fuentes")
@CrossOrigin(origins = "*")
public class FuentePoderController {

    @Autowired
    private FuentePoderRepository fuentePoderRepository;
    @GetMapping
    public List<FuentePoder> listarTodas() {
        return fuentePoderRepository.findAll();
    }

    @PostMapping
    public FuentePoder crear(@RequestBody FuentePoder fuentePoder) {
        return fuentePoderRepository.save(fuentePoder);
    }
}
