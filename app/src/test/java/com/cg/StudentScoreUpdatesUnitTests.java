package com.cg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


public class StudentScoreUpdatesUnitTests {
	
    
@Mock
/**
 * Mock replacement of a dependency , we are reprogramming ,deciding what should be the responses
 * every method
 * for a mock object it will provide default implementation for every method
 */
public IDatabase mockDatabase;

public StudentScore studentScores;

@BeforeEach
public void beforeEach()
{
MockitoAnnotations.initMocks(this);
}

@Test
public void calculateSumAndStore_withValidInput_shouldCalculateAndUpdateResultInDb()
{
// Arrange
studentScores = new StudentScore(mockDatabase);
int[] scores = {60,70,90};
Mockito.doNothing().when(mockDatabase).updateScores(Mockito.anyString(), Mockito.anyInt());

// Act
studentScores.calculateSum("student1", scores);

// Assert
Mockito.verify(mockDatabase, Mockito.times(1)).updateScores("student1", 220);
}

}

