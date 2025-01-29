package com.awesomepizza;

import com.awesomepizza.service.OrdineRequest;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrdineController {
    private final List<Ordine> ordini = new ArrayList<>();
    private int idCounter = 1;

    @PostMapping
    public Ordine createOrdine(@RequestBody OrdineRequest request) {
        Ordine ordine = new Ordine(idCounter++, request.getNomePizza(), "da preparare");
        ordini.add(ordine);
        return ordine;
    }

    @GetMapping
    public List<Ordine> getOrdini() {
        return new ArrayList<>(ordini);
    }

    @PutMapping("/next")
    public Ordine updateNextOrdine() {
        for (Ordine ordine : ordini) {
            if (ordine.getStatus().equals("da preparare")) {
                ordine.setStatus("pronta");
                return ordine;
            }
        }
        throw new RuntimeException("Nessun ordine da aggiornare");
    }
}
