import java.util.ArrayList;

public class NBATeam {
    ArrayList<NBATeam> NBATeams;

    private String teamName;
    private String Conference;
    private double FGp;
    private double ThreePTp;
    private double FTp;
    private double FGa;
    private double ThreePTa;
    private double FTa;
    private double TOV;
    private double REB;

    public NBATeam(){
        teamName = "Milwaukee Bucks";
        Conference = "Eastern";
        FGp = 43.5;
        FGa = 90.4;
        ThreePTp = 13.4;
        ThreePTa = 38.1;
        FTp = 17.3;
        FTa = 22.6;
        TOV = 14.5;
        REB = 49.0;
    }


    public double getFGp() {return FGp;}
    public void setFGp(double FGp) {this.FGp = FGp;}
    public double getThreePTp() {return ThreePTp;}
    public void setThreePTp(double threePTp) {ThreePTp = threePTp;}
    public double getFTp() {return FTp;}
    public void setFTp(double FTp) {this.FTp = FTp;}
    public double getFGa() {return FGa;}
    public void setFGa(double FGa) {this.FGa = FGa;}
    public double getThreePTa() {return ThreePTa;}
    public void setThreePTa(double threePTa) {ThreePTa = threePTa;}
    public double getFTa() {return FTa;}
    public void setFTa(double FTa) {this.FTa = FTa;}
    public double getTOV() {return TOV;}
    public void setTOV(double TOV) {this.TOV = TOV;}
    public double getREB() {return REB;}
    public void setREB(double REB) {this.REB = REB;}




}
