import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Tests {

    @Test
    public void testEncapsulationGrades() throws IOException {
        Student student = checkGrade("true");
        student.addGrade(4);
        List grades = student.getGrades();
        grades.add(5);
        Assertions.assertNotEquals(student.getGrades(), grades);
    }

    @Test
    public void testSetName() {
        Student student = new Student("John");
        student.setName("Tom");
        Assertions.assertEquals(student.getName(), "Tom");
    }

    @Test
    public void testGetName() {
        Student student = new Student("Mike");
        Assertions.assertEquals(student.getName(), "Mike");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 6})
    public void testIncorrectAddGrade(int arg) throws IOException {
        Student student = checkGrade("false");
        Assertions.assertThrows(IllegalArgumentException.class, () -> student.addGrade(arg));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    public void testCorrectAddGrade(int arg) throws IOException {
        Student student = checkGrade("true");
        student.addGrade(arg);
        Assertions.assertEquals(arg, student.getGrades().get(0));
    }

    private Student checkGrade(String flag) throws IOException {
        Student student = new Student("Mike");
        CloseableHttpClient httpClientMock = Mockito.mock(CloseableHttpClient.class);
        student.httpClient = httpClientMock;
        CloseableHttpResponse httpResponseMock = Mockito.mock(CloseableHttpResponse.class);
        HttpEntity entityMock = mock(HttpEntity.class);

        when(httpClientMock.execute(any())).thenReturn(httpResponseMock);
        when(httpResponseMock.getEntity()).thenReturn(entityMock);

        InputStream istr = new ByteArrayInputStream(flag.getBytes());
        when(entityMock.getContent()).thenReturn(istr);
        return student;
    }
}
