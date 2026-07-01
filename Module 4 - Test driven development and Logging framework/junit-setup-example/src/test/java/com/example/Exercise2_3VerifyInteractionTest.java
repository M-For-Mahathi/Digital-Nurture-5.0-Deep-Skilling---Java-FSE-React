package com.example;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;

public class Exercise2_3VerifyInteractionTest {

    @Test
    public void testVerifyInteraction() {

        // Step 1: Create a mock object
        Exercise1_3ExternalApi mockApi =
                Mockito.mock(Exercise1_3ExternalApi.class);

        // Step 2: Pass the mock object to the service
        Exercise1_3MyService service =
                new Exercise1_3MyService(mockApi);

        // Step 3: Call the service method
        service.fetchData();

        // Step 4: Verify that getData() was called
        verify(mockApi).getData();
    }
}