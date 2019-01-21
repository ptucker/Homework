import java.util.Random;

public class NBATeamSelect extends NBATeam implements GenStats{

    private NBATeam T;
    private int TotalPTS;
    private int madeTwoPointers;


    public NBATeamSelect(NBATeam t){
        T = t;
        genFGM(T.getFGa(),T.getFGp(),T.getThreePTa(), T.getThreePTp());
        genFTM(T.getFTa(), T.getFTp());
        genREB(T.getREB());
        genTOV(T.getTOV());
        genTotalPTS();
    }


    public void genFGM(double avgFGAttempts, double avgFGMakes, double avgThreeAttempts, double avgThreeMakes){
        Random FGMakernd = new Random();
        Random FGAttemptrnd = new Random();
        Random ThreeMakernd = new Random();
        Random ThreeAttemptrnd = new Random();

        double FGMakerange = 15;
        double FGAttemptrange = 5;
        double ThreeMakeRange = 8;
        double ThreeAttemptRange = 5;

        double FGMakeMax = avgFGMakes + FGMakerange;
        double FGMakeMin = avgFGMakes - FGMakerange;
        double FGAttemptMax = avgFGAttempts + FGAttemptrange;
        double FGAttemptMin = avgFGAttempts - FGAttemptrange;

        double ThreeMakeMax = avgThreeMakes + ThreeMakeRange;
        double ThreeMakeMin = avgThreeMakes - ThreeMakeRange;
        double ThreeAttemptMax = avgThreeAttempts + ThreeAttemptRange;
        double ThreeAttemptMin = avgThreeAttempts - ThreeAttemptRange;

        int FGAttemptnum = FGAttemptrnd.nextInt(((int)FGAttemptMax - (int)FGAttemptMin) +1);
        int FGMakenum = FGMakernd.nextInt(((int)FGMakeMax - (int)FGMakeMin) +1);

        int ThreeAttemptnum = ThreeAttemptrnd.nextInt(((int)ThreeAttemptMax - (int)ThreeAttemptMin)+1);
        int ThreeMakenum = ThreeMakernd.nextInt(((int)ThreeMakeMax - (int)ThreeMakeMin)+1);

        int madeFGs = (FGMakenum +(int)FGMakeMin);
        int madeThrees = (ThreeMakenum + (int)ThreeMakeMin);
        this.setThreePTp(madeThrees);
        madeTwoPointers = madeFGs - madeThrees;

        this.setFGa(FGAttemptnum + (int)FGAttemptMin);
        this.setThreePTa(ThreeAttemptnum + (int)ThreeAttemptMin);
    }

    public void genFTM(double avgAttempts, double avgMakes){
        Random Mrnd = new Random();
        Random Arnd = new Random();

        double Mrange = 10;
        double Arange = 5;

        double mMax = avgMakes + Mrange;
        double mMin = avgMakes - Mrange;

        double aMax = avgAttempts + Arange;
        double aMin = avgAttempts - Arange;

        int Anum = Arnd.nextInt(((int)aMax - (int)aMin) +1);
        int Mnum = Mrnd.nextInt(((int)mMax - (int)mMin) +1);

        this.setFTp(Mnum +(int)mMin);
        this.setFTa(Anum + (int)aMin);
    }
    public void genREB(double avg){
        Random rnd = new Random();

        double max = avg + 10;
        double min = avg - 10;

        int num = rnd.nextInt(((int)max - (int)min) +1);
        this.setREB(num + (int)min);
    }
    public void genTOV(double avg){
        Random rnd = new Random();

        double max = avg + 3;
        double min = avg - 3;

        int num = rnd.nextInt(((int)max - (int)min) +1);
        this.setTOV(num + (int)min);
    }
    public void genTotalPTS(){
        TotalPTS = ((madeTwoPointers * 2) + ((int)T.getThreePTp() * 3) + ((int)T.getFTp()));
    }
    public void display(){
        //System.out.println(String.format("2PTS: %d", ))
    }

}
