package miagem1;

import java.util.List;

/**
 * Created by franck on 28/11/2016.
 */
public class ScoreCalculateur {
    /**
     * Calcule le score obtenu par un étudiant en répondant à une question à choix
     *
     * @return le score compris entre 0 et 100
     */
    float calculeScore(List<Integer> indicesReponseEtudiant, QuestionAChoix question) {
        float score = 0 ;
        for (int indice:indicesReponseEtudiant) {
            float scoreQuestion = question.getScoreForIndice(indice);
            if (scoreQuestion!=0)
                score += scoreQuestion;
            else
                score -= 50f;
        }
        if (score>0)
            return score;
        else
            return 0;
    }



}
