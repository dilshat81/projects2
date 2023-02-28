package fr.educentre.demo.e2e;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class VehiculeTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testCreateVehiculeCategory() throws Exception {
        String requestBody = "{\"name\": \"Cars\"}";
        MvcResult result =
                mvc.perform(MockMvcRequestBuilders.post("/api/v1/categories")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                        .andExpect(status().isCreated())
                        .andReturn();
        String responseBody = result.getResponse().getContentAsString();
        Assertions.assertTrue(responseBody.contains("Cars"));


    }
    @Test
    public void testGetVehiculeCategories() throws Exception {

                mvc.perform(MockMvcRequestBuilders.get("/api/v1/categories"))
                        .andExpect(status().isOk());


    }
    @Test
    public void testGetVehiculeCategoryById() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/categories/{id}", 1))
                .andExpect(status().isOk());


    }
    @Test
    public void testCreateVehiculeSubCategory() throws Exception {
        String requestBody = "{\"name\": \"Cars\"}";
        MvcResult result =
                mvc.perform(MockMvcRequestBuilders.post("/api/v1/categories/{id}/sub-categories", 1)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(requestBody))
                        .andExpect(status().isCreated())
                        .andReturn();
        String responseBody = result.getResponse().getContentAsString();
        Assertions.assertTrue(responseBody.contains("Cars"));


    }
    @Test
    public void testGetVehiculeSubCategoryById() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/categories/{id}/sub-categories", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name",is("Cars")));


    }
    @Test
    public void testGetSubCategoryById() throws Exception {
        //GET
        ///api/v1/sub-categories/{id}

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/sub-categories/{id}", 1))
                .andExpect(status().isOk());
               // .andExpect(jsonPath("$[0].name",is("Cars")));


    }


}
