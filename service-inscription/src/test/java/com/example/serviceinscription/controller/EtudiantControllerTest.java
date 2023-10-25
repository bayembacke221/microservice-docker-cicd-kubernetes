package com.example.serviceinscription.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.serviceinscription.dto.EtudiantDto;
import com.example.serviceinscription.service.EtudiantService;


import java.util.List;

class EtudiantControllerTest {

    @InjectMocks
    private EtudiantController etudiantController;

    @Mock
    private EtudiantService etudiantService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(etudiantController).build();
    }

    @Test
     void testGetAllEtudiant() throws Exception {
        EtudiantDto etudiant1 = new EtudiantDto("12345",
                "John",
                "Doe",
                "Math");
        EtudiantDto etudiant2 = new EtudiantDto("123456",
                "Jane",
                "Smith",
                "Anglais");
        when(etudiantService.getAllEtudiant()).thenReturn(List.of(etudiant1, etudiant2));

        mockMvc.perform(get("/etudiant/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
     void testGetEtudiantById() throws Exception {
        String numCarte = "12345";
        EtudiantDto etudiantDto = new EtudiantDto(numCarte,
                "John",
                "Doe",
                "Math");
        when(etudiantService.getEtudiantById(numCarte)).thenReturn(etudiantDto);

        mockMvc.perform(get("/etudiant/{numCarte}", numCarte))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
     void testAjouterEtudiant() throws Exception {
        EtudiantDto etudiantDto = new EtudiantDto("12345",
                "John",
                "Doe",
                "Math");

        mockMvc.perform(post("/etudiant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(etudiantDto)))
                .andExpect(status().isOk());

        verify(etudiantService, times(1)).ajouterNouveauEtudiant(etudiantDto);
    }

    @Test
     void testModifierEtudiant() throws Exception {
        EtudiantDto etudiantDto = new EtudiantDto("12345",
                "John",
                "Doe",
                "Math");

        mockMvc.perform(put("/etudiant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(etudiantDto)))
                .andExpect(status().isOk());

        verify(etudiantService, times(1)).updateEtudiant(etudiantDto);
    }

    @Test
     void testSupprimerEtudiant() throws Exception {
        String numCarte = "12345";

        mockMvc.perform(delete("/etudiant/{idEtudiant}", numCarte))
                .andExpect(status().isOk());

        verify(etudiantService, times(1)).supprimerEtudiant(numCarte);
    }

    // Helper method to convert an object to JSON string
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
