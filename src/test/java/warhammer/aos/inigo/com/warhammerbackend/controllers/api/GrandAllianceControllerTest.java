package warhammer.aos.inigo.com.warhammerbackend.controllers.api;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import warhammer.aos.inigo.com.warhammerbackend.controllers.helpers.ValidationControllerHelper;
import warhammer.aos.inigo.com.warhammerbackend.models.api.GrandAlliance;
import warhammer.aos.inigo.com.warhammerbackend.resources.Data;
import warhammer.aos.inigo.com.warhammerbackend.services.api.GrandAllianceService;

@WebMvcTest(controllers = GrandAllianceController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class GrandAllianceControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockBean
        private GrandAllianceService service;

        @MockBean
        private ValidationControllerHelper helper;

        ObjectMapper objectMapper;

        @BeforeEach
        void setUp() {
                objectMapper = new ObjectMapper();
        }

        @Test
        void testList() throws Exception {
                // Given
                List<GrandAlliance> grandAlliances = Arrays.asList(
                                Data.createGrandAlliance1().orElseThrow(),
                                Data.createGrandAlliance2().orElseThrow());

                // When
                when(service.findAll()).thenReturn(grandAlliances);
                mockMvc.perform(get("/api/grand-alliance").contentType(MediaType.APPLICATION_JSON))

                                // Then
                                .andExpect(status().isOk())
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.[0].id").value(1))
                                .andExpect(jsonPath("$.[0].name").value("Destruction"))
                                .andExpect(jsonPath("$.[1].id").value(2))
                                .andExpect(jsonPath("$.[1].name").value("Chaos"))
                                .andExpect(jsonPath("$", hasSize(2)))
                                .andExpect(content().json(objectMapper.writeValueAsString(grandAlliances)));
                verify(service).findAll();
        }

        @Test
        void testFindOne() throws Exception {
                // Given
                Long id = 1L;
                Long badId = 2L;

                // When
                when(service.findById(id)).thenReturn(Data.createGrandAlliance1());
                mockMvc.perform(get("/api/grand-alliance/{id}", id).contentType(MediaType.APPLICATION_JSON))

                                // Then
                                .andExpect(status().isOk())
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.id").value(id))
                                .andExpect(jsonPath("$.name").value("Destruction"));
                verify(service).findById(anyLong());

                // When
                mockMvc.perform(get("/api/grand-alliance/{id}", badId))

                                // Then
                                .andExpect(status().isNotFound());
        }

        @Test
        void testCreate() throws JsonProcessingException, Exception {
                // Given
                GrandAlliance grandAlliance = Data.createGrandAlliance1().orElseThrow();

                // When
                when(service.save(any())).then(invocation -> {
                        GrandAlliance g = invocation.getArgument(0);
                        g.setId(1L);
                        return g;
                });
                mockMvc.perform(post("/api/grand-alliance").contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(grandAlliance)))

                                // Then
                                .andExpect(status().isCreated())
                                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                                .andExpect(jsonPath("$.id", is(1)))
                                .andExpect(jsonPath("$.name", is("Destruction")));

                verify(service).save(any());
        }

        @Test
        void testUpdate() throws Exception {
                // Given
                Long id = 1L;
                Long badId = 2L;
                GrandAlliance grandAlliance = Data.createGrandAlliance1().orElseThrow();

                GrandAlliance grandAllianceUpdated = GrandAlliance.builder()
                                .id(id)
                                .name("Death")
                                .build();

                // When
                when(service.update(eq(id), any())).thenAnswer(invocation -> {
                        Long updatedId = invocation.getArgument(0);
                        GrandAlliance g = invocation.getArgument(1);

                        if (updatedId.equals(id)) {
                                grandAlliance.setName(g.getName());
                                return Optional.of(grandAlliance);
                        }

                        return Optional.empty();
                });
                mockMvc.perform(put("/api/grand-alliance/{id}", id)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(grandAllianceUpdated)))

                                // Then
                                .andExpect(status().isCreated())
                                .andExpect(jsonPath("$.id").value(id))
                                .andExpect(jsonPath("$.name").value("Death"));

                verify(service).update(eq(id), any());

                // When
                mockMvc.perform(put("/api/grand-alliance/{id}", badId)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(grandAllianceUpdated)))

                                // Then
                                .andExpect(status().isNotFound());
        }

        @Test
        void testDelete() throws Exception {
                // Given
                Long id = 1L;
                Long badId = 2L;

                // When
                when(service.delete(eq(id))).thenReturn(Data.createGrandAlliance1());
                mockMvc.perform(delete("/api/grand-alliance/{id}", id)
                                .contentType(MediaType.APPLICATION_JSON))

                                // Then
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.id").value(id))
                                .andExpect(jsonPath("$.name").value("Destruction"));
                verify(service).delete(eq(id));

                // When
                mockMvc.perform(delete("/api/grand-alliance/{id}", badId))
                                .andExpect(status().isNotFound());

        }

}
