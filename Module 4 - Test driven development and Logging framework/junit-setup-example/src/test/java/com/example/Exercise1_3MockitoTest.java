package com.example;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class Exercise1_3MockitoTest {
    @Test
    public void testExternalApi() {

        // Create a mock object
        Exercise1_3ExternalApi mockApi = Mockito.mock(Exercise1_3ExternalApi.class);

        // Stub the method
        when(mockApi.getData()).thenReturn("Mock Data");

        // Pass mock object to service
        Exercise1_3MyService service = new Exercise1_3MyService(mockApi);

        // Call service method
        String result = service.fetchData();

        // Verify result
        assertEquals("Mock Data", result);
    }
}
