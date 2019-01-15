import sun.plugin.javascript.navig4.Layer;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.dnd.DragGestureEvent;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;


public class CityView implements MouseMotionListener, MouseListener{
    CityConstruct build;


    private ArrayList<JLabel> createdPeople = new ArrayList<>();
    private int lastPersonIndex = -1;
    private int createdPeopleIndex =0;
    private int Layer =2;
    private static int index =0;
    Point diffDrag;


    private JFrame Frame;
    private JPanel SetPanel;
    private JPanel MapPanel;
    private JPanel CreatePanel;
    private JPanel CreatePolicePanel;
    private JLayeredPane LayeredMap;
    private JLabel PoliceLabel;
    private JTextField PoliceNameField;
    private JTextField PoliceAgeField;
    private JComboBox PoliceRollSelect;
    private JButton CreatePoliceButton;
    private JPanel CreateTeacherPanel;
    private JLabel TeacherLabel;
    private JTextField TeacherNameField;
    private JTextField TeacherAgeField;
    private JComboBox CerSelect;
    private JButton CreateTeacherButton;
    private JPanel CreateKidPanel;
    private JLabel KidLabel;
    private JTextField KidNameField;
    private JTextField KidAgeField;
    private JComboBox FavCandySelect;
    private JButton CreateKidButton;
    private JLabel MapLabel;
    private JLabel InfoLabel;
    private JLabel SchoolLabel;
    private JLabel CityHallLabel;
    private JPanel InfoPanel;
    private JLabel InfoDisplay;

    /**
     * Creates a new CityConstruct object which must be used to
     * move Person data to different places around the city.
     */

    public CityView() {
        build = new CityConstruct();
    }

    /**
     * Calls all functions needed to assemble the graphic and makes it visible.
     */
    public void CreateCityGraphic() {
        initialize();
        createUIComponents();
        addListeners();
        Frame.setVisible(true);
    }

    /**
     * Creates frame and base panel to allow a visual display.
     */
    public void initialize() {
        Frame = new JFrame();
        Frame.setSize(1000,800);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.add(SetPanel);
    }

    /**
     * Adds listeners to user manipulated text fields and buttons to set
     * basic functions of the interface such as creating people.
     */
    public void addListeners(){
        PoliceNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);

            }
        });
        PoliceAgeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        PoliceRollSelect.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });

        CreatePoliceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (PoliceRollSelect.getSelectedItem() == "Patrol") {
                    try {
                        Police newP = new Police(PoliceNameField.getText(), Integer.parseInt(PoliceAgeField.getText()), Police.Roll.Patrol);
                        userCreatePerson(newP);
                       }catch(Exception ex) {System.out.println("Information Incorrect");}
                }
                else if (PoliceRollSelect.getSelectedItem() == "Sargent") {
                    try {
                        Police newP = new Police(PoliceNameField.getText(), Integer.parseInt(PoliceAgeField.getText()), Police.Roll.Sargent);
                        userCreatePerson(newP);
                    }catch(Exception ex) {System.out.println("Information Incorrect");}
                }
                else if (PoliceRollSelect.getSelectedItem() == "Captain"){
                    try{
                        Police newP = new Police(PoliceNameField.getText(), Integer.parseInt(PoliceAgeField.getText()), Police.Roll.Captain);
                        userCreatePerson(newP);
                    }catch(Exception ex) {System.out.println("Information Incorrect");}
                }
                else if (PoliceRollSelect.getSelectedItem() == "Chief"){
                    try{
                        Police newP = new Police(PoliceNameField.getText(), Integer.parseInt(PoliceAgeField.getText()), Police.Roll.Chief);
                        userCreatePerson(newP);
                    }catch(Exception ex) {System.out.println("Information Incorrect");}
                }

            }


        });
        TeacherNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        TeacherAgeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
        });
        CerSelect.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
        CreateTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (CerSelect.getSelectedItem() == "Elementary School") {
                    try {
                        Teacher newT = new Teacher(TeacherNameField.getText(), Integer.parseInt(TeacherAgeField.getText()), Teacher.certification.Elementary);
                        userCreatePerson(newT);
                    } catch (Exception ex) {
                        System.out.println("Fail");
                    }
                }
                else if (CerSelect.getSelectedItem() == "Middle School") {
                    try {
                        Teacher newT = new Teacher(TeacherNameField.getText(), Integer.parseInt(TeacherAgeField.getText()), Teacher.certification.MiddleSchool);
                        userCreatePerson(newT);
                    } catch (Exception ex) {
                        System.out.println("Fail");
                    }
                }
                else if (CerSelect.getSelectedItem() == "High School") {
                    try {
                        Teacher newT = new Teacher(TeacherNameField.getText(), Integer.parseInt(TeacherAgeField.getText()), Teacher.certification.HighSchool);
                        userCreatePerson(newT);
                    } catch (Exception ex) {
                        System.out.println("Fail");
                    }

                }
            }
        });
        KidNameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }
        });
        KidAgeField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
        });
        FavCandySelect.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

            }
        });
        CreateKidButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (FavCandySelect.getSelectedItem() == "Snickers") {
                    try {
                        Kid newK = new Kid(KidNameField.getText(), Integer.parseInt(KidAgeField.getText()), Kid.favCandy.Snickers);
                        userCreatePerson(newK);
                    } catch (Exception ex) {
                        System.out.println("Fail");
                    }
                }
                else if (FavCandySelect.getSelectedItem() == "Twix"){
                    try {
                        Kid newK = new Kid(KidNameField.getText(), Integer.parseInt(KidAgeField.getText()), Kid.favCandy.Twix);
                        userCreatePerson(newK);
                    }catch(Exception ex){System.out.println("Fail");}
                }
                else if (FavCandySelect.getSelectedItem() == "KitKat"){
                    try {
                        Kid newK = new Kid(KidNameField.getText(), Integer.parseInt(KidAgeField.getText()), Kid.favCandy.KitKat);
                        userCreatePerson(newK);
                    }catch(Exception ex){System.out.println("Fail");}
                }
                else if (FavCandySelect.getSelectedItem() == "AlmondJoy"){
                    try {
                        Kid newK = new Kid(KidNameField.getText(), Integer.parseInt(KidAgeField.getText()), Kid.favCandy.AlmondJoy);
                        userCreatePerson(newK);
                    }catch(Exception ex){System.out.println("Fail");}
                }
            }
        });

    }

    /**
     * Creates additional components to be used in the interface such as the map(LayeredPane), school, and city hall.
     * Also adds the MouseMotionListener and MouseListener to the LayeredPane
     */
    public void createUIComponents(){
            LayeredMap = new JLayeredPane();
            LayeredMap.setPreferredSize(new Dimension(700,600));
            MapPanel.add(LayeredMap);


            Toolkit toolkit = Toolkit.getDefaultToolkit();
            URL mapURL = getClass().getResource("/Resources/map.jpg");
            Image map = toolkit.getImage(mapURL);
            map = map.getScaledInstance(700,600,Image.SCALE_SMOOTH);

            ImageIcon mapIcon = new ImageIcon(map);
            JLabel MapLabel = new JLabel(mapIcon);
            MapLabel.setBounds(0,0,700,600);
            LayeredMap.add(MapLabel,new Integer(0));



            URL schoolURL = getClass().getResource("/Resources/school.png");
            Image school = toolkit.getImage(schoolURL);
            school = school.getScaledInstance(200,200,Image.SCALE_SMOOTH);

            ImageIcon schoolIcon = new ImageIcon(school);
            SchoolLabel = new JLabel(schoolIcon);
            SchoolLabel.setBounds(50,10,200,200);
            LayeredMap.add(SchoolLabel,new Integer(1));


            URL CityHallURL = getClass().getResource("/Resources/CityHall.png");
            Image CityHall = toolkit.getImage(CityHallURL);
            CityHall = CityHall.getScaledInstance(200,200,Image.SCALE_SMOOTH);

            ImageIcon CityHallIcon = new ImageIcon(CityHall);
            CityHallLabel = new JLabel(CityHallIcon);
            CityHallLabel.setBounds(500,225,200,200);
            LayeredMap.add(CityHallLabel, new Integer(1));

            InfoPanel.setLayout(new BoxLayout(InfoPanel, BoxLayout.Y_AXIS));

            InfoLabel = new JLabel();
            InfoLabel.setBackground(Color.WHITE);
            InfoLabel.setText("Information Window: ");
            InfoLabel.setVerticalAlignment(SwingConstants.TOP);
            InfoLabel.setFont(new Font(InfoLabel.getFont().getName(),Font.LAYOUT_LEFT_TO_RIGHT,18));
            InfoPanel.add(InfoLabel);


            InfoDisplay = new JLabel();
            InfoDisplay.setBackground(Color.WHITE);
            InfoDisplay.setBorder(new LineBorder(Color.BLACK));
            InfoDisplay.setMinimumSize(new Dimension(250,200));
            InfoDisplay.setPreferredSize(new Dimension(250,200));
            InfoDisplay.setMaximumSize(new Dimension(250,200));
            InfoDisplay.setHorizontalAlignment(SwingConstants.LEFT);
            InfoPanel.add(InfoDisplay);



            LayeredMap.addMouseMotionListener(this);
            LayeredMap.addMouseListener(this);
            LayeredMap.revalidate();
            LayeredMap.setVisible(true);

    }

    /**
     * Creates JLabel for user created person, setting the person's name as the JLabel name.
     * Adds person object and Jlabel to respective ArrayLists and displays JLabel on the map.
     * @param p represents the person created by user input @see addListeners
     */
    public void userCreatePerson(Person p){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        ImageIcon icon;

        URL policemanURL = getClass().getResource("/Resources/policeman.png");
        Image policemanimg = toolkit.getImage(policemanURL);
        policemanimg = policemanimg.getScaledInstance(70, 90, Image.SCALE_SMOOTH);

        URL TeacherURL = getClass().getResource("/Resources/teacher.png");
        Image teacherimg = toolkit.getImage(TeacherURL);
        teacherimg = teacherimg.getScaledInstance(70,90,Image.SCALE_SMOOTH);

        URL KidURL = getClass().getResource("/Resources/kid.png");
        Image kidimg = toolkit.getImage(KidURL);
        kidimg = kidimg.getScaledInstance(70,90,Image.SCALE_SMOOTH);

        if (p instanceof Police)
            icon = new ImageIcon(policemanimg);
        else if (p instanceof Teacher)
            icon = new ImageIcon(teacherimg);
        else if (p instanceof Kid)
            icon = new ImageIcon(kidimg);
        else
            icon = new ImageIcon(policemanimg);


        build.addLabeltoCity(p);
        JLabel PersonLabel = new JLabel(p.getName());
        PersonLabel.setBounds(300,300,70, 90);
        PersonLabel.setIcon(icon);
        PersonLabel.setBackground(Color.yellow);
        PersonLabel.setName(p.getName());

        createdPeople.add(PersonLabel);
        LayeredMap.add(createdPeople.get(index), new Integer(Layer));
        Layer++;
        index++;

        LayeredMap.revalidate();
        LayeredMap.repaint();

        setDisplayText(build.getcityNames());
    }

    /**
     * Checks the ArrayList of JLabels and the ArrayList of People, looks for matching names.
     * Calls one of the movePerson functions to transfer data of the person object linked to the Jlabel, depending on
     * whether or not the person label is within the bounds of the school or city hall labels.
     *
     */
    public void checkOverlap() {
       for (int j=0; j<build.cityPeople.size();j++){
           for (int i=0;i < createdPeople.size();i++){
               if (createdPeople.get(i).getName() == build.cityPeople.get(j).getName()){
                   if (SchoolLabel.getBounds().contains(createdPeople.get(i).getX(), createdPeople.get(i).getY())){
                       build.movePersonSchool(build.cityPeople.get(j));
                       setDisplayText(build.cityPeople.get(j).getName() + " Moved to School");
                   }
                   else if (CityHallLabel.getBounds().contains(createdPeople.get(i).getX(), createdPeople.get(i).getY())){
                       build.movePersonCityHall(build.cityPeople.get(j));
                       setDisplayText(build.cityPeople.get(j).getName() + " Moved to City Hall");
                   }
                   else {
                       build.movePersonCity(build.cityPeople.get(j));
                   }
               }
           }
       }
    }

    /**
     * Takes a string and displays it on the InfoDisplay label.
     * @param s represents the string to be displayed
     */
    public void setDisplayText(String s){
        InfoDisplay.setText(s);
        InfoDisplay.revalidate();
        InfoDisplay.repaint();
        InfoDisplay.setVisible(true);
    }

    /**
     * Takes in a JLabel, if label is linked to a person object by name
     * displays the toString value of the label on the screen, toString was
     * overwritten but does not display the string I want it to
     * @param l represents the JLabel to be compared
     */
    public void displayPersonInfo(JLabel l){
        for(int i=0;i<createdPeople.size();i++){
            if (l.getName() == createdPeople.get(i).getName()){
                setDisplayText(l.toString());
            }
        }
    }

    /**
     * Tried to overwrite toString to display information of the person object
     * linked to passed in JLabel
     * @return returns the desired string
     */
    public String toString() {
        String info ="";
        for (int i = 0; i < build.cityPeople.size(); i++) {
                if (build.cityPeople.get(i) instanceof Police){
                    info += String.format(build.cityPeople.get(i).getName() + " is a " + build.cityPeople.get(i).getAge() + " year old " + ((Police) build.cityPeople.get(i)).getRoll());
                    return info;}
                else if (build.cityPeople.get(i) instanceof Teacher) {
                    info += String.format(build.cityPeople.get(i).getName() + " is a " + build.cityPeople.get(i).getAge() + " year old " + ((Teacher) build.cityPeople.get(i)).getCer());
                    return info;}
                else if (build.cityPeople.get(i) instanceof Kid){
                    info += String.format(build.cityPeople.get(i).getName() + " is a " + build.cityPeople.get(i).getAge() + " year old " + (((Kid) build.cityPeople.get(i)).getCandy()));
                    return info;}
            }
        return info;
    }

    /**
     * Allows created person labels to be dragged around the screen
     * @param e is the drag event
     */
    public void mouseDragged(MouseEvent e){
        JLabel dragLabel = null;
        for (int i =0; i < createdPeople.size(); i++) {
            if (createdPeople.get(i).getBounds().contains(e.getPoint())) {
                dragLabel = createdPeople.get(i);
            }
        }
        if (dragLabel != null){
            if(diffDrag == null)
                diffDrag = new Point(e.getX() - dragLabel.getBounds().x, e.getY() - dragLabel.getBounds().y);
            dragLabel.setBounds(e.getX() - diffDrag.x, e.getY()-diffDrag.y, dragLabel.getBounds().width, dragLabel.getBounds().height);

        }
    }

    /**
     * Displays the current inhabitants of the city hall or the school
     * when hovered over with the mouse
     * @param e represents the mouse event
     */
    @Override
    public void mouseMoved(MouseEvent e){
        diffDrag = null;
        if (CityHallLabel.getBounds().contains(e.getPoint())){
            setDisplayText(build.getCityHallNames());
        }
        else if (SchoolLabel.getBounds().contains(e.getPoint())){
            setDisplayText(build.getschoolNames());
        }
        else
            setDisplayText(" ");
    }

    /**
     * Displays information of the person when it's respective label is clicked on, doesn't work properly
     * @param e represents the mouse event
     */
    @Override
    public void mouseClicked(MouseEvent e){
        for (int i =0; i < createdPeople.size();i++){
            if(createdPeople.get(i).getBounds().contains(e.getPoint())){
                displayPersonInfo(createdPeople.get(i));
            }
        }
    }
    @Override
    public void mouseEntered(MouseEvent e){}
    @Override
    public void mouseExited(MouseEvent e){}
    @Override
    public void mousePressed(MouseEvent e){}

    /**
     * calls checkOverlap() to see if person Label overlaps with others
     * @param e represents the mouse event
     */
    @Override
    public void mouseReleased(MouseEvent e){ checkOverlap();}


}
