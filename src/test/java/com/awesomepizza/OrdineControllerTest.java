package com.awesomepizza;

import com.awesomepizza.service.OrdineRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class OrdineControllerTest {

    private OrdineController ordineController;

    @BeforeEach
    void setUp() {
        ordineController = new OrdineController();
    }

    @Test
    void testCreateOrdine() {
        OrdineRequest request = new OrdineRequest();
        request.setNomePizza("Margherita");

        Ordine ordine = ordineController.createOrdine(request);
        assertNotNull(ordine);
        assertEquals("Margherita", ordine.getNomePizza());
        assertEquals("da preparare", ordine.getStatus());
    }

    @Test
    void testGetOrdini() {
        List<Ordine> ordini = ordineController.getOrdini();
        assertNotNull(ordini);
        assertTrue(ordini.isEmpty());
    }

    @Test
    void testUpdateNextOrdine() {
        OrdineRequest request = new OrdineRequest();
        request.setNomePizza("Diavola");
        ordineController.createOrdine(request);

        Ordine ordineAggiornato = ordineController.updateNextOrdine();
        assertNotNull(ordineAggiornato);
        assertEquals("pronta", ordineAggiornato.getStatus());
    }
}
