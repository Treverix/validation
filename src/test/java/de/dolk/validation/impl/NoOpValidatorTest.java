package de.dolk.validation.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import de.dolk.validation.ValidationContext;
import de.dolk.validation.ValidationResult;
import de.dolk.validation.ValidationStatus;

public class NoOpValidatorTest {

    @Mock
    private ValidationContext context;

    @Captor
    private ArgumentCaptor<ValidationResult<Object>> resultCaptor;

    private NoOpValidator validator;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        validator = new NoOpValidator();
    }

    @Test
    public void usesStatusFromContextHints() {
        // Given
        when(context.getHint(NoOpValidator.STATUS_HINT)).thenReturn(ValidationStatus.FAIL);
        Object object = new Object();

        // When
        ValidationStatus status = validator.validate(context, object);

        // Then
        assertEquals(ValidationStatus.FAIL, status);
        verify(context).addResult(resultCaptor.capture());
        assertEquals(ValidationStatus.FAIL, resultCaptor.getValue().getStatus());
        assertEquals("FAIL", resultCaptor.getValue().getStatus().toString());
        assertEquals(object, resultCaptor.getValue().getValidatedObject());
        assertEquals(validator, resultCaptor.getValue().getOrigin());
    }

    @Test
    public void usesOKIfNoHintFound() {
        // Given
        when(context.getHint(NoOpValidator.STATUS_HINT)).thenReturn(null);
        Object object = new Object();

        // When
        ValidationStatus status = validator.validate(context, object);

        // Then
        assertEquals(ValidationStatus.OK, status);
    }

    @Test
    public void usesErrorIfHintIsNotAVerificationStatus() {
        // Given
        when(context.getHint(NoOpValidator.STATUS_HINT)).thenReturn("invalid");
        Object object = new Object();

        // When
        ValidationStatus status = validator.validate(context, object);

        // Then
        assertEquals(ValidationStatus.ERROR, status);
    }

}
