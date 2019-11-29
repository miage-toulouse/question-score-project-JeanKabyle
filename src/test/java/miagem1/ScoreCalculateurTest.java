package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private QuestionAChoixMultiple questionAChoixMultiple;
    private ScoreCalculateur scoreCalc;


    //given
    @Before
    public void setUp() throws Exception{
        questionAChoixMultiple = new QuestionAChoixMultiple("q1", new ArrayList<Integer>(Arrays.asList(2, 3, 5)));
        scoreCalc = new ScoreCalculateur();
    }

    @Test
    public void calculeScoreMauvaisesReponses() {
        //When
        float resScore = scoreCalc.calculeScore(new ArrayList<Integer>(Arrays.asList(1, 4)), questionAChoixMultiple);
        //Then
        assertEquals(0f,resScore,0.01f);
    }

    @Test
    public void calculeScoreBonnesReponsesPartielles() {
        //When
        float resScore = scoreCalc.calculeScore(new ArrayList<Integer>(Arrays.asList(2, 3)), questionAChoixMultiple);
        //Then
        assertEquals(2f*100f/3f,resScore,0.01f);
    }

    @Test
    public void calculeScoreBonnesReponses() {
        //When
        float resScore = scoreCalc.calculeScore(new ArrayList<Integer>(Arrays.asList(2, 3, 5)), questionAChoixMultiple);
        //Then
        assertEquals(100f,resScore,0.01f);
    }

    @Test
    public void calculeScoreToutesLesReponses() {
        //When
        float resScore = scoreCalc.calculeScore(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5)), questionAChoixMultiple);
        //Then
        assertEquals(0f,resScore,0.01f);
    }

    @Test
    public void calculeScoreTroisReponses() {
        //When
        float resScore = scoreCalc.calculeScore(new ArrayList<Integer>(Arrays.asList(1, 2, 3)), questionAChoixMultiple);
        //Then
        assertEquals(16.66f,resScore,0.01f);
    }
}