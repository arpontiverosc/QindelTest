package com.qindel.test.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PricesApiIntegrationTests {

    @Autowired
    private MockMvc mockMvc;



    @Test
    void test1() throws Exception {

        String priceDate = "2020-06-14T10:00";
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("priceDate", priceDate)
                        .param("productId", productId)
                        .param("brandId", brandId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
               .andExpect(jsonPath("$[0].price").value("35.50EUR"));
    }


    @Test
    void test2() throws Exception {

        String priceDate = "2020-06-14T16:00:00";
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("priceDate", priceDate)
                        .param("productId", productId)
                        .param("brandId", brandId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].price").value("25.45EUR"));
    }

    @Test
    void test3() throws Exception {

        String priceDate = "2020-06-14T21:00:00";
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("priceDate", priceDate)
                        .param("productId", productId)
                        .param("brandId", brandId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].price").value("35.50EUR"));
    }


    @Test
    void test4() throws Exception {

        String priceDate = "2020-06-15T10:00:00";
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("priceDate", priceDate)
                        .param("productId", productId)
                        .param("brandId", brandId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].price").value("30.50EUR"));
    }

    @Test
    void test5() throws Exception {

        String priceDate = "2020-06-16T21:00:00";
        String productId = "35455";
        String brandId = "1";

        mockMvc.perform(MockMvcRequestBuilders.get("/prices")
                        .param("priceDate", priceDate)
                        .param("productId", productId)
                        .param("brandId", brandId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].price").value("38.95EUR"));
    }
}
