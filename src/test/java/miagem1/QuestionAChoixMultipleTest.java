package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple question;
    private ArrayList<Integer> indicesBonnesReponses;

    //given
    @Before
    public void setUp() throws Exception {
        //given : une instance de question à choix exclusif
        indicesBonnesReponses = new ArrayList<Integer>();
        indicesBonnesReponses.add(1);
        indicesBonnesReponses.add(2);
        indicesBonnesReponses.add(3);
        question = new QuestionAChoixMultiple("un énoncé", indicesBonnesReponses);
    }

    @Test
    public void testGetEnonce() {
        //When : on demande son énoncé à la question
        String resEnonce = question.getEnonce();
        //Then
        assertEquals("un énoncé", resEnonce);
    }

    @Test
    public void testGetScoreForIndiceBonneReponse() {
        //When
        int choixEtudiant = 1;
        //And
        float resScore = question.getScoreForIndice(choixEtudiant);
        //Then
        assertEquals(100f/3f, resScore, 0.01f);
    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        //When
        int choixEtudiant = 4;
        //And
        float resScore = question.getScoreForIndice(choixEtudiant);
        //Then
        assertEquals(0.00f, resScore, 0.01f);
    }
}