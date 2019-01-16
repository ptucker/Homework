import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.net.URL;

// Array Lists are used to store all of the shape objects as well as the strings of the
// shapes variables when read from the file.
public class ShapeDisplayUI {
    List<Shape> shapes= new ArrayList<>();
    ArrayList<String> shapeVars = new ArrayList<>();

    private JFrame Frame;
    private JPanel SetPanel;
    private JPanel ShapeListPanel;
    private JLabel InfoDisplay;
    private JPanel ShapeViewPanel;
    private JPanel ShapeInfoPanel;
    JList<String> shapelist;
    JScrollPane listScroller;
    ListModel names;

// Constructor reads the information from the file and initializes the interface.
    public ShapeDisplayUI(){
        readFile();
        initialize();
    }

// Calls functions needed to set up the interface
    public void initialize(){
      createUIComponents();
      addListeners();
      Frame.setVisible(true);
    }

//  Creates components not created in the layout manager, and manipulates the ones that were.
    public void createUIComponents(){
        Frame = new JFrame();
        Frame.setSize(700,750);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Frame.add(SetPanel);

        ShapeListPanel.setMinimumSize(new Dimension(50,700));
        ShapeListPanel.setPreferredSize(new Dimension(50,700));
        ShapeListPanel.setMaximumSize(new Dimension(50,700));

        // Creation of the scrolling list of shapes required a list model, which all of the names
        // of the shape objects were added to. The ID number of the shape is also added to its name
        // here to differentiate the shapes.
        names = new DefaultListModel();
        for(int i =0; i < shapes.size(); i++){
            shapes.get(i).setName(shapes.get(i).getName() + "(" + shapes.get(i).getID() + ")");
            ((DefaultListModel) names).addElement(shapes.get(i).getName());

        }

        // A JList is then created using the list model's data, here I adjust the selection mode
        // and the general look of the list.
        shapelist = new JList(names);
        shapelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        shapelist.setLayoutOrientation(JList.VERTICAL);
        shapelist.setVisibleRowCount(-1);
        shapelist.setVisible(true);
        ShapeListPanel.add(shapelist);

        // Finally I add a scroll pane using the data and the settings from the prior list and list model.
        // This gives it a much cleaner look and is easier to use.
        listScroller = new JScrollPane(shapelist);
        listScroller.setPreferredSize(new Dimension(125,700));
        ShapeListPanel.add(listScroller);
        listScroller.setVisible(true);


        InfoDisplay = new JLabel();
        InfoDisplay.setBackground(Color.WHITE);
        InfoDisplay.setMinimumSize(new Dimension(450,150));
        InfoDisplay.setPreferredSize(new Dimension(450,150));
        InfoDisplay.setMaximumSize(new Dimension(450,150));
        InfoDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        InfoDisplay.setVerticalAlignment(SwingConstants.CENTER);
        ShapeInfoPanel.add(InfoDisplay);

    }

    // Displays the information of the object once selected from the list,
    // I use the getDetailedString functions to set the text of the JLabel.
    public void DisplayShapeInfo(Shape s){
        InfoDisplay.setText(s.getDetailedString());
        InfoDisplay.revalidate();
        InfoDisplay.revalidate();
        InfoDisplay.setVisible(true);
    }

    //Generating the image of the shape type to be displayed on the screen.
    // pulls from images saved to Resources and creates a JLabel
    // with the image of the shape selected.
    // I used removeAll to clear the panel so there would be no overlapping.
    public void generateShapePicture(Shape s){
        ShapeViewPanel.removeAll();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        ImageIcon icon;

        URL squareURL = getClass().getResource("/Resources/square.png");
        Image squareimg = toolkit.getImage(squareURL);
        squareimg = squareimg.getScaledInstance(200,200, Image.SCALE_SMOOTH);

        URL rectangleURL = getClass().getResource("/Resources/rectangle.png");
        Image rectangleimg = toolkit.getImage(rectangleURL);
        rectangleimg = rectangleimg.getScaledInstance(200,200,Image.SCALE_SMOOTH);

        URL triangleURL = getClass().getResource("Resources/triangle.png");
        Image triangleimg = toolkit.getImage(triangleURL);
        triangleimg = triangleimg.getScaledInstance(200,200,Image.SCALE_SMOOTH);

        URL circleURL = getClass().getResource("/Resources/circle.png");
        Image circleimg = toolkit.getImage(circleURL);
        circleimg = circleimg.getScaledInstance(200,200,Image.SCALE_SMOOTH);

        if(s instanceof Square)
            icon = new ImageIcon(squareimg);
        else if (s instanceof Rectangle)
            icon = new ImageIcon(rectangleimg);
        else if (s instanceof Triangle)
            icon = new ImageIcon(triangleimg);
        else if (s instanceof Circle)
            icon = new ImageIcon(circleimg);
        else
            icon = new ImageIcon(circleimg);

        JLabel ShapeLabel = new JLabel();
        ShapeLabel.setBounds(100,100,200,200);
        ShapeLabel.setIcon(icon);
        ShapeLabel.setBackground(Color.white);
        ShapeViewPanel.add(ShapeLabel);
        ShapeLabel.revalidate();
        ShapeLabel.repaint();

    }

    //adds a mouse listener to the list of shapes so that when DOUBLE clicked it compares
    // the selected value and finds the matching shape within the shapes arraylist.
    // since the ID number was added to the end of the name it will always access the correct shape.
    // Then calls the functions to generate the image and information.
    public void addListeners(){
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getClickCount() == 2) {
                    String selectedItem = shapelist.getSelectedValue();
                    for (int i = 0; i < shapes.size(); i++) {
                        if (selectedItem == shapes.get(i).getName()) {
                            generateShapePicture(shapes.get(i));
                            DisplayShapeInfo(shapes.get(i));
                        }
                    }
                }
            }
        };
        shapelist.addMouseListener(mouseListener);
    }

    // This function is called in the readFile function, it uses the string values stored in the shapeVars
    // arraylist to create shape objects and adds them to the shape arraylist before clearing the temporary arraylist.
    // since the variables of the shapes are always in a specific order the constructors for each object are set to match them.
    public void constructShape(){
        if (shapeVars.get(0).contains("circle")){
            Circle c = new Circle(shapeVars.get(0),Integer.parseInt(shapeVars.get(1)),Integer.parseInt(shapeVars.get(2)),shapeVars.get(3));
            shapes.add(c);
            shapeVars.clear();
        } else if (shapeVars.get(0).contains("square")) {
            Square s = new Square(shapeVars.get(0),Integer.parseInt(shapeVars.get(1)),Integer.parseInt(shapeVars.get(2)),shapeVars.get(3));
            shapes.add(s);
            shapeVars.clear();
        } else if (shapeVars.get(0).contains("rectangle")){
            Rectangle r = new Rectangle(shapeVars.get(0),Integer.parseInt(shapeVars.get(1)),Integer.parseInt(shapeVars.get(2)),Integer.parseInt(shapeVars.get(3)),shapeVars.get(4));
            shapes.add(r);
            shapeVars.clear();
        }else if (shapeVars.get(0).contains("triangle")) {
            Triangle t = new Triangle(shapeVars.get(0),Integer.parseInt(shapeVars.get(1)),Integer.parseInt(shapeVars.get(2)),Integer.parseInt(shapeVars.get(3)),Integer.parseInt(shapeVars.get(4)),shapeVars.get(5));
            shapes.add(t);
            shapeVars.clear();
        }else
            System.out.printf("Wrong variable");

    }

    // To get the information from this file how I wanted it, I basically checked the value of the first
    // string to verify that it was a shape, then I added all of the following members that didnt contain quotes to
    // a temporary arraylist to be turned into objects. Since the color variable has quotes I kept track of the number
    // of variables with quotes, so I know that when there were two variables with quotes added, all of the shape's information had been added and the constructShape
    // function is called. Then the temporary arraylist is cleared and the process starts over.
    public void readFile(){
        int quoteCount = 0;
        try (FileInputStream is = new FileInputStream("shapes.csv")) {
            InputStreamReader ir = new InputStreamReader(is);
            BufferedReader rdr = new BufferedReader(ir);
            String line = rdr.readLine();
            while (line != null) {
                String[] parts = line.split(",");
                for (int i =0;i < parts.length; i++) {
                    quoteCount =0;
                    if(parts[i].contains("circle")|| parts[i].contains("square")|| parts[i].contains("triangle")||parts[i].contains("rectangle")){
                       quoteCount++;
                       if(shapeVars.size()> 0) {
                           constructShape();
                       }
                        while(quoteCount !=2){
                            shapeVars.add((parts[i]));
                            if(parts[i].charAt(0) == '"') {
                                quoteCount++;
                                break;
                            }
                            i++;
                        }
                    }
                }
                if(shapeVars.size()> 0) {
                    constructShape();
                }
                line = rdr.readLine();

            }
        } catch (Exception ex) {
            System.out.println("Failed");
        }
    }


}
