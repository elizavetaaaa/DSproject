package com.company;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;




public class Main {

    static JLabel title, title1, title0;
    static  JTextField input;
    static int number;
    //static JButton ok;
    static JDialog result;

    public static void main(String[] args) {



        Dict mydict = new Dict();//new object of dict class
        number = 1;
        //here I will use:
        JPanel p, p1, p2, p0;
        JButton inputButton;

        //Defining my frame
        final JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(new BorderLayout() );
        myFrame.setBounds(50, 100, 350, 250);//is it here?

        //Defining panels
        p = new JPanel();
        myFrame.add(p, BorderLayout.NORTH);
        p0 = new JPanel();
        myFrame.add(p0,BorderLayout.CENTER);
        p1 = new JPanel();
        myFrame.add(p1, BorderLayout.CENTER);
        p2= new JPanel();
        myFrame.add(p2, BorderLayout.SOUTH);

        //Defining Label for question
        title1 = new JLabel("Question № 1:");//label for 1 panel
        title1.setForeground(Color.BLUE);
        title0 = new JLabel("(select a letter)");
        title0.setBackground(Color.CYAN);
        title = new JLabel("Here wiil be the question!");//label for 2 panel
        title.setBounds(60, 7, 200, 30);

        // Defining input for answer
        input = new JTextField("write here",SwingConstants.CENTER);
        input.setForeground(Color.GRAY);
        input.setPreferredSize(new Dimension(100,25));

        //Defining inputButton Button
        inputButton = new JButton("submit");
        inputButton.setBounds(210, 50, 80, 30);

        //adding components to panels
        p.add(title1);
        p.add(title0);
        p1.add(title);
        p2.add(input);
        p2.add(inputButton);



        myFrame.setVisible(true);

        //изменяет содержимое label title при нажатии кнопки
        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = input.getText();
                int key = mydict.keys.get(mydict.index);
                if(a.equals("")) {
                    JPanel empPan = new JPanel();
                    empPan.add(new JLabel("answer can not be blank!"));
                    JButton okay = new JButton("OK");
                    empPan.setVisible(true);
                    empPan.add(okay);
                    empPan.setLayout(new FlowLayout());
                    empPan.setSize(200, 150);

                    //creting a msg appears in case test is finished
                    result = new JDialog(myFrame);
                    result.setSize(200, 100);
                    result.setLocationRelativeTo(myFrame);
                    result.add(empPan);
                    result.setVisible(true);


                    okay.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            result.setVisible(false);
                        }
                    });
                }


               else{
                   if(a.equals(mydict.getQuestion(key).getAnswer())){
                    System.out.println("correct");//check is answer correct or not
                    mydict.maks ++; }
                     else {
                        System.out.println("incorrect");}

                 if (number < 10) {number++;
                  key = mydict.keys.get(mydict.index);
                  title1.setText("Question № "+ number );}
                if (mydict.index <9){
                    mydict.index++;
                    mydict.quiz();
                }
                else {//appears when all questions are answered
                    JPanel pan=new JPanel();
                    String ex = "Excellent!";
                    String good = "Not bad!";
                    String bad = "Hmm... ";
                    String score = " YOUR SCORE IS ";
                    if (mydict.maks==10)
                        pan.add(new JLabel(ex + score + mydict.maks + "/10!"));
                    else if (mydict.maks>5 && mydict.maks<10)
                        pan.add(new JLabel(good+ score + mydict.maks + "/10!"));
                    else
                        pan.add(new JLabel(bad+ score + mydict.maks + "/10!"));

                    JLabel exta = new JLabel("Know more about India!!!");
                    exta.setFont (exta.getFont ().deriveFont (18.0f));
                    exta.setBackground(Color.ORANGE);
                    pan.add(exta);
                    EmptyBorder border = new EmptyBorder(5, 20, 5, 20);
                    exta.setBorder(border);

                    JLabel Chandigarh = new JLabel("Chandigarh is the capital  of two states.");
                    Chandigarh.setBackground(Color.ORANGE);
                    pan.add(Chandigarh);
                    JLabel contries = new JLabel("India borders 7 countries.");
                    contries.setBackground(Color.ORANGE);
                    pan.add(contries);

                    JLabel  Gandhinagar= new JLabel(" Gandhinagar is the capital of Gujarat.");
                    Gandhinagar.setBackground(Color.ORANGE);
                    pan.add( Gandhinagar);

                    JLabel Bangalor = new JLabel("Bangalor is the IT capital of India.");
                    Bangalor.setBackground(Color.ORANGE);
                    pan.add(Bangalor);

                    JLabel Patil= new JLabel("<html>Smt. Pratibha Devisingh Patil was <br/>the president of India in 2009.</html>");
                    Patil.setBackground(Color.WHITE);
                    pan.add(Patil);

                    JLabel Goa= new JLabel("Goa is India’s smallest state.");
                    Goa.setBackground(Color.WHITE);
                    pan.add(Goa);

                    JLabel the_red_sea = new JLabel("India does not border the Red Sea.");
                    the_red_sea.setBackground(Color.WHITE);
                    pan.add (the_red_sea);

                    JLabel yamuna= new JLabel("Delhi is located along Yamuna.");
                    yamuna.setBackground(Color.GREEN);
                    pan.add(yamuna);

                    JLabel mekong = new JLabel("<html>Yamuna , Ganges and Brahmaputra are India's <br/>rivers , but not the Mekong.</html>");
                    mekong.setBackground(Color.GREEN);
                    pan.add(mekong);

                    JLabel rishikesh = new JLabel("<html>Rishikesh is the world's yoga capital. <br></br></html>");
                    rishikesh.setBackground(Color.GREEN);
                    EmptyBorder border1 = new EmptyBorder(1, 20, 10, 20);
                    rishikesh.setBorder(border1);
                    pan.add(rishikesh);




                    pan.add(new JLabel("Do you want to play again?", SwingConstants.CENTER));

                    JButton ok = new JButton("YES");
                    pan.add(ok);
                    //pan.add(ok,BorderLayout.SOUTH);

                    JButton cancel =  new JButton("EXIT");
                    pan.add(cancel,BorderLayout.PAGE_END);


                    cancel.addActionListener(new ActionListener() {//disposing everything in click case
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            myFrame.dispose();
                        }
                    });


                    ok.addActionListener(new ActionListener() {//play quiz again in click case
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            result.setVisible(false);
                            mydict.index=0;//обновление переменной
                            number=1;//обновление переменной
                            mydict.maks=0;//обновление переменной

                            Dict mydict = new Dict();// new dict to change questions' positions
                            mydict.quiz();

                            title1.setText("Question № "+ number);
                            myFrame.repaint();//creating frame again
                        }});

                    pan.setLayout(new FlowLayout());
                    pan.setSize(400,400);

                    //creting a msg appears in case test is finished
                    result = new JDialog(myFrame);
                    result.setSize(400,400);
                    result.setLocationRelativeTo(myFrame);
                    result.add(pan);
                    result.setVisible(true);
                    System.out.println(mydict.maks);//prints score to console


                }}}

        });


        mydict.quiz();//first calling the method after program stars working

    }



                }











