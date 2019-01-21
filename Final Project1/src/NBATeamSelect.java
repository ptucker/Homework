import java.util.Random;

public class NBATeamSelect extends NBATeam implements GenStats{

    private NBATeam T;
    private int FGM;
    private int ThreePTM;
    private int FTM;
    private int TotalPTS;
    private int REB;
    private int TOV;

    public void genTotalPTS(){}
    public void genFGM(double avg){
        Random rnd = new Random();
        int max = (int)avg + 15;
        int min = (int)avg - 15;
        rnd.nextInt((max - min) +1);

    }
    public void genThreePTM(double avg){
        Random rnd = new Random();
        int max = (int)avg + 8;
        int min = (int)avg -8;
    }
    public void genFTM(double avg){

    }
    public void genREB(double avg){

    }
    public void genTOV(double avg){

    }
}
